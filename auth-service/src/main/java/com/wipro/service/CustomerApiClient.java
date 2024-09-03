package com.wipro.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.dto.CustomerDto;

@FeignClient(name = "customer-service")
public interface CustomerApiClient {
	
	@PostMapping("api/customer")
	public CustomerDto createCustomer(@RequestBody CustomerDto customerDto);
}
