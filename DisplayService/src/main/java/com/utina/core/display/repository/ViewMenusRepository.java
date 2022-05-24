package com.utina.core.display.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utina.core.display.entity.ViewMenus;



@Repository
public interface ViewMenusRepository extends JpaRepository<ViewMenus, Long> {
	
	@Query("select v from ViewMenus v "
			+ " where v.menulabel like %:menulabel% ")
	List<ViewMenus> getMenusByLabel( 
			@Param("menulabel") String menulabel);
    
	
}