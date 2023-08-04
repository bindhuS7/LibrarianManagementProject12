package org.jsp.library.service;

import org.jsp.library.dto.Librarian;
import org.jsp.library.exception.NotFoundException;
import org.jsp.library.exception.SholudNotRepeateException;
import org.jsp.library.helper.LoginHelper;
import org.jsp.library.repository.ResponseStructure;

import org.springframework.http.ResponseEntity;

public interface LibrarianService {

	public ResponseEntity<ResponseStructure<Librarian>> createLabrarianAccount(Librarian librarian) throws SholudNotRepeateException;

	

	public ResponseEntity<ResponseStructure<Librarian>> login(LoginHelper helper);



	public ResponseEntity<ResponseStructure<Librarian>> verifyOtp(int id, int otp) throws NotFoundException;
	
}
