package com.burakkucuk.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

	private MessageType messageType;
	
	
	private String ofStatic;
	
	public String prepareErorrMessage() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(messageType.getMessage());
		
		if(ofStatic != null) {
			
			builder.append(" : " + ofStatic);
		}
		return builder.toString();
	}
}
