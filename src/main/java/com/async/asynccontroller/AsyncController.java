package com.async.asynccontroller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.async.asyncService.AsyncService;
import com.async.model.EmployeeAddresses;
import com.async.model.EmployeeNames;
import com.async.model.EmployeePhone;

@RestController
public class AsyncController {
	
	
	   @Autowired
	    private AsyncService service;
	 
	    @RequestMapping(value = "/testAsynch", method = RequestMethod.GET)
	    public void testAsynch() throws InterruptedException, ExecutionException 
	    {
	    	 System.out.println("testAsynch Start");
	 
	        CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress();
	        CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName();
	        CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();
	 
	        // Wait until they are all done
	        CompletableFuture.allOf(employeeAddress, employeeName, employeePhone).join();
	         
	       System.out.println("EmployeeAddress--> " + employeeAddress.get());
	       System.out.println("EmployeeName--> " + employeeName.get());
	       System.out.println("EmployeePhone--> " + employeePhone.get());
	    }

}
