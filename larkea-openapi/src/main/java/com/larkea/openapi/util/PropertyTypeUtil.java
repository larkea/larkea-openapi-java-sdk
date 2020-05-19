package com.larkea.openapi.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

import com.google.common.collect.Sets;

/**
 * 检查属性类型是否被系统支持.
 */
public class PropertyTypeUtil {

	private static final Set<Class<?>> typesSupported = Sets.newHashSet();

	static {
		typesSupported.add(Byte.class);
		typesSupported.add(Short.class);
		typesSupported.add(Integer.class);
		typesSupported.add(Long.class);
		typesSupported.add(BigInteger.class);
		typesSupported.add(Float.class);
		typesSupported.add(Double.class);
		typesSupported.add(BigDecimal.class);
		typesSupported.add(Boolean.class);
		typesSupported.add(String.class);
	}

	private PropertyTypeUtil() {
	}

	public static boolean isTypeOfValueSupported(Object value) {
		if (value instanceof Byte
				|| value instanceof Short
				|| value instanceof Integer
				|| value instanceof Long
				|| value instanceof BigInteger
				|| value instanceof Float
				|| value instanceof Double
				|| value instanceof BigDecimal
				|| value instanceof Boolean
				|| value instanceof String) {
			return true;
		}

		return false;
	}

	public static boolean isTypeOfValueSupported2(Object value) {
		return typesSupported.contains(value.getClass());
	}
}
