package org.jsp.library.service.serviceImplementation;

import java.util.InputMismatchException;
import java.util.Random;

import org.jsp.library.dao.Dao;
import org.jsp.library.dto.Librarian;
import org.jsp.library.exception.NotFoundException;
import org.jsp.library.exception.SholudNotRepeateException;
import org.jsp.library.helper.LoginHelper;
import org.jsp.library.helper.SendMailLogic;
import org.jsp.library.repository.ResponseStructure;
import org.jsp.library.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceImplementationClass implements LibrarianService {

	@Autowired
	SendMailLogic maillogic;

	@Autowired
	Dao dao;

	
	
	@Override
	public ResponseEntity<ResponseStructure<Librarian>> createLabrarianAccount(Librarian librarian)
			throws SholudNotRepeateException {
		int opt = new Random().nextInt(100000, 999999);
		librarian.setOtp(opt);

		Librarian librarian2 = dao.fetchByEmail(librarian.getEmail());
		if (librarian2 == null) {
			dao.saveLibrarian(librarian);
			// logic to send to DB
			maillogic.librarianSignupMail(librarian);
			ResponseStructure<Librarian> structure = new ResponseStructure<>();
			structure.setData(librarian);
			structure.setStatus(HttpStatus.PROCESSING.value());
			structure.setMessage("otp is generated successfully");
			return new ResponseEntity<ResponseStructure<Librarian>>(structure, HttpStatus.FOUND);
		} else {
			throw new SholudNotRepeateException("email should not be repeated");

		}
	}
	@Override
	public ResponseEntity<ResponseStructure<Librarian>> verifyOtp(int id, int otp) throws NotFoundException  {
		Librarian librarian=dao.fetchById(id);
		
		if(librarian==null) {
			throw new NotFoundException("otp missmatched");
		}else {
			if(librarian.getOtp()!=otp) {
				throw new InputMismatchException("otp missmatched");
				
			}else {
				librarian.setStatus(true);
				dao.saveLibrarian(librarian);
ResponseStructure<Librarian> structur=new ResponseStructure<>();
structur.setData(librarian);
structur.setMessage("account created successfully");
structur.setStatus(HttpStatus.CREATED.value());
			
return new ResponseEntity<ResponseStructure<Librarian>>(structur,HttpStatus.CREATED);
			}
		}
 }


	@Override
	public ResponseEntity<ResponseStructure<Librarian>> login(LoginHelper helper) {
       Librarian librarian=dao.fetchByEmail(helper.getEmail());
		
		if(librarian==null) {
			throw  new InputMismatchException("invalid email");
		}else {
			if(librarian.getPassword().equals(helper.getPassword())) {
				
				
ResponseStructure<Librarian> structur=new ResponseStructure<>();
structur.setData(librarian);
structur.setMessage("Login success");
structur.setStatus(HttpStatus.FOUND.value());
			
return new ResponseEntity<ResponseStructure<Librarian>>(structur,HttpStatus.FOUND);
			
	       }else {
	    	   throw new InputMismatchException("password incorrect");
	       }
		}
		
		
	}
	
		
}
	
