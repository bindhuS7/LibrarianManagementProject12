package org.jsp.library.service.serviceImplementation;

import org.jsp.library.dao.StudentDao;
import org.jsp.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImplementationclass  implements StudentService{

	
	@Autowired
	StudentDao dao;
	
}
