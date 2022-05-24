package com.utina.core.display.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import com.utina.core.display.entity.MenusItem;

import feign.Param;

public interface MenusItemRepository extends JpaRepository<MenusItem, Long> {
	
	@Query("select mi from MenusItem mi where mi.menuid =:menuid and mi.itemidparent =0 order by itemorder")
	List<MenusItem>findByMenuid(@Param ("menuid") Long menuid );
	
	@Query("select mi from MenusItem mi where mi.menuid =:menuid")
	List<MenusItem>findByallMenuid(@Param ("menuid") Long menuid );
	
	@Query("select mi from MenusItem mi where mi.pitemid =:pitemid")
	MenusItem getMenusItem(@Param ("pitemid") Long pitemid );
	
	@Procedure("f_set_menuitem_id")
    Long getItemid( @Param("userid") Long userid);


}
