package org.jsp.library.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SholudNotRepeateException extends Exception{

	
	@Override
	public String  getMessage() {
		return message;
	}
	String message="This field sholud not berepeated";
}
