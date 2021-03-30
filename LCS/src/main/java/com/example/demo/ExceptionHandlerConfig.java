package com.example.demo;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequest;

@Configuration
public class ExceptionHandlerConfig {

	private static final String DEFAULT_KEY_STATUS = "status";
	private static final String DEFAULT_KEY_ERROR = "error";
	private static final String DEFAULT_KEY_ERRORS = "errors";
	private static final String DEFAULT_KEY_MESSAGE = "message";

	public static final String KEY_STATUS = "status";
	public static final String KEY_ERROR = "error";
	public static final String KEY_MESSAGE = "message";
	public static final String KEY_TIMESTAMP = "timestamp";
	public static final String KEY_ERRORS = "errors";

	@Bean
	public ErrorAttributes errorAttributes() {
		return new DefaultErrorAttributes() {

			@Override
			public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
				Map<String, Object> defaultMap = super.getErrorAttributes(webRequest, includeStackTrace);

				Map<String, Object> errorAttributes = new LinkedHashMap<>();
				// Customize.
				// For eg: Only add the keys you want.
				Integer status = (Integer) defaultMap.get(DEFAULT_KEY_STATUS);
				String message = "";

				if (status == 500) {
					if (!defaultMap.get(KEY_MESSAGE).toString().isEmpty()) {
						message = defaultMap.get(KEY_MESSAGE).toString();
					} else {
						message = "setOfStrings null";
					}
				}
				if (status == 400) {
					message = "emty json or wrong format";
				}
				errorAttributes.put(KEY_STATUS, status);
				// errorAttributes.put(KEY_MESSAGE, message);
				errorAttributes.put(KEY_ERROR, message);

				return errorAttributes;
			}
		};
	}
}