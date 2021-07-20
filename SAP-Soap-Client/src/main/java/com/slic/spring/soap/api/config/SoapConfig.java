package com.slic.spring.soap.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

	@Bean
	public Jaxb2Marshaller marsheller() {
		// check generated class object and convert to XML
		Jaxb2Marshaller marsheller = new Jaxb2Marshaller();
		marsheller.setPackagesToScan("com.slic.spring.soap.wsdl");
		return marsheller;
	}

}
