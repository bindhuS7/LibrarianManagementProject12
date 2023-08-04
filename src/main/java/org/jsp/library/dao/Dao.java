package org.jsp.library.dao;

import org.apache.tomcat.jni.Library;
import org.jsp.library.dto.Librarian;
import org.jsp.library.repository.LabrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Dao {

	@Autowired
	LabrarianRepository repository;
	
	public Librarian saveLibrarian(Librarian librarian) {
		
		return repository.save(librarian);
		
	}
	
	public Librarian fetchByEmail(String email) {
		
		return repository.findByEmail(email);
	}

	public Librarian fetchById(int id) {
		
		return repository.findById(id).orElse(null);
	}
	
	
}
