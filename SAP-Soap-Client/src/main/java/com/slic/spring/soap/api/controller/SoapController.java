package com.slic.spring.soap.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.slic.spring.soap.api.client.SoapClient;
import com.slic.spring.soap.wsdl.GetCountryResponse;

@RestController
public class SoapController {
	
	@Autowired
	SoapClient client;
	
	@GetMapping("/getCountry")
	public GetCountryResponse getCountry(@RequestParam String name) {
		return client.getCountry(name);
	}

}
 