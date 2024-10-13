package com.burakkucuk.handler;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.burakkucuk.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	
	@ExceptionHandler(value = {BaseException.class})
	public ResponseEntity<ApiError<String>> handleBaseException(BaseException exception , WebRequest request) {
		
		return ResponseEntity.badRequest().body(createApiError(exception.getMessage(), request));
	 
	}
	
	
	
	private String getHostName() {
		
	  	try {
		return	InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
 			 System.out.println("Hata oluştu " + e.getMessage());
		}
	  	
	  	return null;
	}
	
	 public <E> ApiError<E> createApiError(E mesage ,WebRequest request){
		 
		 ApiError<E> apiError = new ApiError<>();
		 apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		 
		 
		 Exception<E> exception = new Exception<>();
		 
		 exception.setCreateTime(new Date());
		 exception.setHostName(getHostName());
		 exception.setPath(request.getDescription(false).substring(4));
		 exception.setMessage(mesage);
		 
		 apiError.setException(exception);
		 
		 return apiError;
	 }
	
}





