package com.utina.core.display.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utina.core.display.entity.MenusRoles;
import com.utina.core.display.entity.MenusUsers;

import feign.Param;

public interface MenusUsersRepository extends JpaRepository<MenusUsers, Long> {
	
	List<MenusUsers> findByMenuid(Long menuid);
	
	@Query("select mr from MenusUsers mr where associd =:associd ")
	MenusUsers getMenusRolesById (@Param("associd") Long associd);

}
