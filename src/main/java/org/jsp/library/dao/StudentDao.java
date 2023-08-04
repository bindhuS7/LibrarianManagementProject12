package org.jsp.library.dao;

import org.jsp.library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class StudentDao {

	@Autowired
	StudentRepository repository;
	
}
