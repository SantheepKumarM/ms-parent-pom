package org.licensing.service.simple.controllers;

import java.util.List;

import org.licensing.service.simple.config.ServiceConfig;
import org.licensing.service.simple.model.License;
import org.licensing.service.simple.services.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {
	@Autowired
	private LicenseService licenseService;

	@Autowired
	private ServiceConfig serviceConfig;

	@GetMapping(value = "/")
	public List<License> getLicenses(@PathVariable("organizationId") String organizationId) {
		return licenseService.getLicensesByOrg(organizationId);
	}

	@GetMapping(value = "/{licenseId}")
	public License getLicenses(@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {
		return licenseService.getLicense(organizationId, licenseId);
	}

	@PutMapping(value = "/")
	public void updateLicenses(@RequestBody License license) {
		licenseService.updateLicense(license);
	}

	@PostMapping(value = "/")
	public void saveLicenses(@RequestBody License license) {
		licenseService.saveLicense(license);
	}

	@DeleteMapping(value = "{licenseId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLicenses(@PathVariable("licenseId") String licenseId) {
		licenseService.deleteLicense(licenseId);
	}
}