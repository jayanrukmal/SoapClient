package com.slic.spring.soap.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.slic.spring.soap.wsdl.GetCountryRequest;
import com.slic.spring.soap.wsdl.GetCountryResponse;

@Service
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller marsheller; // created from soapconfig

	private WebServiceTemplate template;

	public GetCountryResponse getCountry(String name) {
		
		GetCountryRequest request =  new GetCountryRequest();
		request.setName(name);

		template = new WebServiceTemplate(marsheller);
		GetCountryResponse response = (GetCountryResponse) template.marshalSendAndReceive(
				"http://localhost:8080/ws/countries", request,
				new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
		return response;

	}

}
