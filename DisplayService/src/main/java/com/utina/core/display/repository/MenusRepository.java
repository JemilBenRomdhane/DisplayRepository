package com.utina.core.display.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utina.core.display.entity.Menus;



@Repository
public interface MenusRepository extends JpaRepository<Menus, Long> {
	
    Menus findMenuByMenuid(Long menuid);
    
    
    @Procedure("f_update_menustatus")
	Integer f_update_menustatus(@Param("imenuid") Long imenuid,@Param("istatus") String istatus);
    
	
}