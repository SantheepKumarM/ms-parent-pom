package org.licensing.service.simple.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
	@Autowired
	private Environment cloudEnv;

	public String getPropertyByKey(String propertyKey) {
		String returnValue = "No Value";
		String keyValue = cloudEnv.getProperty(propertyKey);
		if (keyValue != null && !keyValue.isEmpty()) {
			returnValue = keyValue;
		}
		return returnValue;
	}
}
