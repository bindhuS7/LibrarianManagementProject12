package org.jsp.library.repository;

import org.jsp.library.dto.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface LabrarianRepository  extends JpaRepository<Librarian, Integer>{

	Librarian findByEmail(String email);

}
