package org.jsp.library.repository;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	String message;
	int status;
	T data;
	
}
