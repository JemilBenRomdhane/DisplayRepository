package com.utina.core.display.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.utina.core.display.bean.MenusDisplayResponse;


public interface MenusDisplayRepository extends JpaRepository<MenusDisplayResponse, Long>{
	
@Query("select distinct NEW com.utina.core.display.bean.MenusDisplayResponse(i.pitemid,i.itemid,i.itemlabel,"
		+ "i.itemidparent,i.itemorder,i.pagcode,p.pagurl,p.pagicon,l.paglabel,i.pagparams) "
		+ "from Menus m, ViewMenusItem i, ViewParPage p, ParPageLabel l,"
		+ "ViewMenusUsers mu,ViewMenusRoles mr "
		+ " where m.menuid=i.menuid and m.menustatus='ACTIVE'"
		+ " and ((m.menuid=mu.menuid and mu.userid=:userid) or ( m.menuid=mr.menuid and mr.rolcode=:rolcode))"
		+ " and i.pagcode=p.pagcode and p.pagcode=l.pagcode and l.lancode=:lancode"
		+ " and ((i.pagcode is not null) and (i.pagcode!=''))")
List<MenusDisplayResponse> getCurrentUserMenu(@Param("userid") Long userid,
		@Param("rolcode") String rolcode,@Param("lancode") String lancode);

@Query("select distinct NEW com.utina.core.display.bean.MenusDisplayResponse(i.pitemid,i.itemid,i.itemlabel,"
				+ "i.itemidparent,i.itemorder,i.pagcode,'',i.menuicon,i.itemlabel,'') "
				+ "from Menus m, ViewMenusItem i,"
				+ "ViewMenusUsers mu,ViewMenusRoles mr "
				+ " where m.menuid=i.menuid and m.menustatus='ACTIVE'"
				+ " and ((m.menuid=mu.menuid and mu.userid=:userid) or ( m.menuid=mr.menuid and mr.rolcode=:rolcode))"
				+ " and ((i.pagcode is null) or (i.pagcode=''))")
List<MenusDisplayResponse> getCurrentUserHeaderMenu(@Param("userid") Long userid,
		@Param("rolcode") String rolcode);


}
