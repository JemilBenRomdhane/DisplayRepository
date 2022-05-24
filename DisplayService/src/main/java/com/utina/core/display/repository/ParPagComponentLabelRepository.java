package com.utina.core.display.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utina.core.display.entity.ParPagComponentLabel;



@Repository
public interface ParPagComponentLabelRepository extends JpaRepository<ParPagComponentLabel, Long> {
	
	@Query("select v from ParPagComponentLabel v "
			+ " where v.lancode=:lancode and v.pagcode=:pagcode and v.comcode=:comcode ")
	ParPagComponentLabel getComponentLabel( 
			@Param("lancode") String lancode,
			@Param("pagcode") String pagcode,
			@Param("comcode") String comcode);
    
	
}