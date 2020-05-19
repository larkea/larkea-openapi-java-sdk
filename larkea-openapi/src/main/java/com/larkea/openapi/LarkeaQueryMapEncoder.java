package com.larkea.openapi;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.huitongio.pete.core.util.CollectionUtil;
import com.huitongio.pete.core.util.StringUtil;

import com.google.common.collect.Maps;
import feign.Param;
import feign.QueryMapEncoder;
import feign.codec.EncodeException;

/**
 * the query map will be generated using java beans accessible getter property as query parameter
 * names.
 *
 * eg: "/uri?name={name}&number={number}"
 *
 * order of included query parameters not guaranteed, and as usual, if any value is null, it will be
 * left out
 */
public class LarkeaQueryMapEncoder implements QueryMapEncoder {
	private final Map<Class<?>, ObjectParamMetadata> classToMetadata = Maps.newHashMap();

	@Override
	public Map<String, Object> encode(Object object) throws EncodeException {
		try {
			ObjectParamMetadata metadata = getMetadata(object.getClass());
			Map<String, Object> propertyNameToValue = Maps.newHashMap();
			for (PropertyDescriptor pd : metadata.objectProperties) {
				Method method = pd.getReadMethod();
				Object value = method.invoke(object);
				if (value != null && value != object) {
					Param alias = method.getAnnotation(Param.class);
					String name = alias != null ? alias.value() : pd.getName();
					if (value.getClass().isArray()) {
						if (Array.getLength(value) == 0) {
							continue;
						}
						propertyNameToValue.put(name, StringUtil.join((Object[]) value, ','));
					} else {
						if ((value instanceof Collection) && !CollectionUtil.isEmpty((Collection<?>) value)) {
							propertyNameToValue.put(name, StringUtil.join(value, ','));
							continue;
						}
						propertyNameToValue.put(name, value);
					}
				}
			}
			return propertyNameToValue;
		}
		catch (IllegalAccessException | IntrospectionException | InvocationTargetException e) {
			throw new EncodeException("Failure encoding object into query map", e);
		}
	}

	private ObjectParamMetadata getMetadata(Class<?> objectType) throws IntrospectionException {
		ObjectParamMetadata metadata = classToMetadata.get(objectType);
		if (metadata == null) {
			metadata = ObjectParamMetadata.parseObjectType(objectType);
			classToMetadata.put(objectType, metadata);
		}
		return metadata;
	}

	private static class ObjectParamMetadata {

		private final List<PropertyDescriptor> objectProperties;

		private ObjectParamMetadata(List<PropertyDescriptor> objectProperties) {
			this.objectProperties = Collections.unmodifiableList(objectProperties);
		}

		private static ObjectParamMetadata parseObjectType(Class<?> type)
				throws IntrospectionException {
			List<PropertyDescriptor> properties = new ArrayList<PropertyDescriptor>();

			for (PropertyDescriptor pd : Introspector.getBeanInfo(type).getPropertyDescriptors()) {
				boolean isGetterMethod = pd.getReadMethod() != null && !"class".equals(pd.getName());
				if (isGetterMethod) {
					properties.add(pd);
				}
			}

			return new ObjectParamMetadata(properties);
		}
	}
}


