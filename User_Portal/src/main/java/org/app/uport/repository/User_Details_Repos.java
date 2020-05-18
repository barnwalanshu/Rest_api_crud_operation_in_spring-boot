package org.app.uport.repository;

import org.app.uport.entity.User_Detail_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Details_Repos extends JpaRepository<User_Detail_Entity, Long> {

	User_Detail_Entity findAllById(Long id);
//	User_Detail_Entity findById(Long id) ;
	
}
