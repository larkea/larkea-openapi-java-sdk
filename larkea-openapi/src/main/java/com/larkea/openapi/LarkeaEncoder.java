package com.larkea.openapi;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.form.ContentType;
import feign.form.FormEncoder;
import feign.jackson.JacksonEncoder;
import lombok.val;

public class LarkeaEncoder implements Encoder {

	private static final String CONTENT_TYPE_HEADER = "Content-Type";

	private final FormEncoder formEncoder;

	private final JacksonEncoder jacksonEncoder;

	public LarkeaEncoder(ObjectMapper mapper) {
		formEncoder = new FormEncoder();
		jacksonEncoder = new JacksonEncoder(mapper);
	}

	@Override
	public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
		String contentTypeValue = getContentTypeValue(template.headers());
		ContentType contentType = ContentType.of(contentTypeValue);

		if (ContentType.UNDEFINED.equals(contentType)) {
			jacksonEncoder.encode(object, bodyType, template);
		}
		else {
			formEncoder.encode(object, bodyType, template);
		}
	}

	private String getContentTypeValue(Map<String, Collection<String>> headers) {
		for (val entry : headers.entrySet()) {
			if (!entry.getKey().equalsIgnoreCase(CONTENT_TYPE_HEADER)) {
				continue;
			}
			for (val contentTypeValue : entry.getValue()) {
				if (contentTypeValue == null) {
					continue;
				}
				return contentTypeValue;
			}
		}
		return null;
	}
}
