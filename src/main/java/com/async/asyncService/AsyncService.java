package com.async.asyncService;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.async.model.EmployeeAddresses;
import com.async.model.EmployeeNames;
import com.async.model.EmployeePhone;

@Service
public class AsyncService {

	
	    @Autowired
	    private RestTemplate restTemplate;
	 
	    
	 
	    @Async("asyncExecutor")
	    public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException 
	    {
	        System.out.println("getEmployeeName starts");
	 
	        EmployeeNames employeeNameData = restTemplate.getForObject("http://localhost:8081/names", EmployeeNames.class);
	 
	        System.out.println("employeeNameData, {}" + employeeNameData);
	        Thread.sleep(1000L);    //Intentional delay
	        System.out.println("employeeNameData completed");
	        return CompletableFuture.completedFuture(employeeNameData);
	    }
	 
	    @Async("asyncExecutor")
	    public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException 
	    {
	        System.out.println("getEmployeeAddress starts");
	 
	        EmployeeAddresses employeeAddressData = restTemplate.getForObject("http://localhost:8081/addresses", EmployeeAddresses.class);
	 
	        System.out.println("employeeAddressData, {}" + employeeAddressData);
	        Thread.sleep(1000L);    //Intentional delay
	        System.out.println("employeeAddressData completed");
	        return CompletableFuture.completedFuture(employeeAddressData);
	    }
	 
	    @Async("asyncExecutor")
	    public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException 
	    {
	        System.out.println("getEmployeePhone starts");
	 
	        EmployeePhone employeePhoneData = restTemplate.getForObject("http://localhost:8081/phones", EmployeePhone.class);
	 
	        System.out.println("employeePhoneData, {}"+ employeePhoneData);
	        Thread.sleep(1000L);    //Intentional delay
	        System.out.println("employeePhoneData completed");
	        return CompletableFuture.completedFuture(employeePhoneData);
	    }
}
