package com.utina.core.display.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.utina.core.display.entity.MenusRoles;

import feign.Param;

public interface MenusRolesRepository extends JpaRepository<MenusRoles, Long> {
	
List<MenusRoles> findByMenuid(Long menuid);

@Query("select mr from MenusRoles mr where associd =:associd ")
MenusRoles getMenusRolesById (@Param("associd") Long associd);


}
