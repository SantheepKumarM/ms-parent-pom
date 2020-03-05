package org.licensing.service.simple.controllers;

import org.licensing.service.simple.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/license/env/properties")
public class PropertyController {
	@Autowired
	private PropertyService propertyService;

	@GetMapping(value = "/{propertyKey}/")
	public String getPropertyByKey(@PathVariable String propertyKey) {
		return propertyService.getPropertyByKey(propertyKey);
	}
}
