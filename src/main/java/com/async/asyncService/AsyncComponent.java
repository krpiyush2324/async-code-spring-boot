package com.async.asyncService;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncComponent {

	
	    @Async
	    public void asyncMethodWithVoidReturnType() {
	        System.out.println("Execute method asynchronously. " + Thread.currentThread().getName());
	    }

	    @Async
	    public Future<String> asyncMethodWithReturnType() {
	        System.out.println("Execute method asynchronously " + Thread.currentThread().getName());
	        try {
	            Thread.sleep(5000);
	          return new AsyncResult<String>(new String("welcome to spring boot asynchronous code"));
	        } catch (final InterruptedException e) {

	        }
			return null;
	        
	    }

	    @Async("threadPoolTaskExecutor")
	    public void asyncMethodWithConfiguredExecutor() {
	        System.out.println("Execute method asynchronously with configured executor" + Thread.currentThread().getName());
	    }

	    @Async
	    public void asyncMethodWithExceptions() throws Exception {
	        throw new Exception("Throw message from asynchronous method. ");
	    }
}
