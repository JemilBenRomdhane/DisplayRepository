package com.utina.core.display.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utina.core.display.entity.ParList;

public interface ParListRepository extends JpaRepository<ParList, Long> {
	

	@Query("select v from vparlist v "
			+ " where v.parcode=:parcode "
			+ " and v.lancode=:lancode "
			+ " and (v.mgid=:mgid or v.mgid is null) ")
	Page<ParList> getParList( 
			@Param("parcode") String parcode,
			@Param("lancode") String lancode,
			@Param("mgid") Long mgid,
			Pageable pageable);
	
	@Query("select v from vparlist v "
			+ " where v.parcode=:parcode "
			+ " and v.lancode=:lancode "
			+ " and (v.mgid=:mgid or v.mgid is null) ")
	List<ParList> getListParList( 
			@Param("parcode") String parcode,
			@Param("lancode") String lancode,
			@Param("mgid") Long mgid);
	
	@Query("select v from vparlist v "
			+ " where v.parcode=:parcode "
			+ " and v.parvalueparent=:parvalueparent "
			+ " and v.lancode=:lancode "
			+ " and (v.mgid=:mgid or v.mgid is null) ")
	Page<ParList> getChildParList( 
			@Param("parcode") String parcode,
			@Param("parvalueparent") String parvalueparent,
			@Param("lancode") String lancode,
			@Param("mgid") Long mgid,
			Pageable pageable);
	

}
