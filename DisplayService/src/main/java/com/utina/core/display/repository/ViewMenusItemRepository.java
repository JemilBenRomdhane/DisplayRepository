package com.utina.core.display.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utina.core.display.entity.ViewMenus;
import com.utina.core.display.entity.ViewMenusItem;



@Repository
public interface ViewMenusItemRepository extends JpaRepository<ViewMenusItem, Long> {
	
	@Query("select v from ViewMenusItem v "
			+ " where v.menuid=:menuid and v.itemidparent=:idparent order by v.itemorder")
	List<ViewMenusItem> getMenusItemChildren( 
			@Param("menuid") Long menuid,
			@Param("idparent") Long idparent);
    
	
}