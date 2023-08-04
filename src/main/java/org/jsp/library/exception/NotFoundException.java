package org.jsp.library.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class NotFoundException extends Exception {
	String message = "Not Found";

	@Override
	public String getMessage() {
		return message;
	}

}
