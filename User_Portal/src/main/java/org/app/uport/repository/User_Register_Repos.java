package org.app.uport.repository;

import org.app.uport.entity.User_Register_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Register_Repos  extends JpaRepository<User_Register_Entity, Long>{

}

