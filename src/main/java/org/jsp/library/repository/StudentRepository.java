package org.jsp.library.repository;

import org.jsp.library.dto.Librarian;
import org.jsp.library.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepository  extends JpaRepository<Student, Integer>{

	
}
