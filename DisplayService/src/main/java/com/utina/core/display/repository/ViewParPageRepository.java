package com.utina.core.display.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utina.core.display.entity.ViewParPage;

public interface ViewParPageRepository extends JpaRepository<ViewParPage, Long>{

	
	@Query("select v from ViewParPage v "
			+ " where v.pagcode=:pagcode ")
	ViewParPage getParPage( 
			@Param("pagcode") String pagcode);


	
}
