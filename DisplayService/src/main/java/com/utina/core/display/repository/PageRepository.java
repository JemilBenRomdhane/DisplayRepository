package com.utina.core.display.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utina.core.display.entity.Menus;
import com.utina.core.display.entity.ParPage;



@Repository
public interface PageRepository extends JpaRepository<ParPage, Long> {
	
	ParPage findPageByPagcode(String pagcode);
    
	@Procedure("f_update_pagelabel")
	int f_update_pagelabel(@Param("ipagcode") String ipagcode,@Param("ilancode") String ilancode,
			@Param("ipaglabel") String ipaglabel);
	
	
	@Procedure("f_update_pagecomponentlabel")
	int f_update_pagecomponentlabel(@Param("ipagcode") String ipagcode,
			@Param("icomcode") String icomcode,
			@Param("ilancode") String ilancode,
			@Param("icomlabel") String icomlabel,
			@Param("icomplaceholder") String icomplaceholder,
			@Param("icomhint") String icomhint,
			@Param("icommessage") String icommessage);
	
	
	
	
	
	
}