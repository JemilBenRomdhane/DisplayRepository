package com.utina.core.display.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utina.core.display.bean.MenusDisplayResponse;
import com.utina.core.display.bean.ParPageListResponse;
import com.utina.core.display.entity.Menus;


public interface PageListRepository extends JpaRepository<ParPageListResponse, Long>{
	
@Query("select NEW com.utina.core.display.bean.ParPageListResponse(p.pagcode,p.pagmodule,"
		+ "p.pagurl,p.pagicon,l.paglabel,p.flaglanding) from ViewParPage p, ParPageLabel l"
		+ " where p.pagcode=l.pagcode"
		+ " and p.pagcode like %:pagcode% and l.paglabel like %:paglabel% and l.lancode=:lancode")
List<ParPageListResponse> getParPageList(@Param("pagcode") String pagcode,
		@Param("paglabel") String paglabel,@Param("lancode") String lancode);

@Query("select NEW com.utina.core.display.bean.ParPageListResponse(p.pagcode,p.pagmodule,"
		+ "p.pagurl,p.pagicon,l.paglabel,p.flaglanding) from ViewParPage p, ParPageLabel l"
		+ " where p.pagcode=l.pagcode"
		+ " and p.pagcode like %:pagcode% and l.paglabel like %:paglabel% and l.lancode=:lancode and p.flaglanding=true")
List<ParPageListResponse> getLandingPageList(@Param("pagcode") String pagcode,
		@Param("paglabel") String paglabel,@Param("lancode") String lancode);

}
