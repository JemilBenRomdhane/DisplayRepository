package com.utina.core.display.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utina.core.display.entity.ParPageLabel;

public interface ParPageLabelRepository extends JpaRepository<ParPageLabel, Long>{

	
	@Query("select v from ParPageLabel v "
			+ " where v.pagcode like %:pagcode% and v.paglabel like %:paglabel% and lancode=:lancode ")
	List<ParPageLabel> getParPageList( 
			@Param("pagcode") String pagcode,
			@Param("paglabel") String paglabel,
			@Param("lancode") String lancode);


	
}
