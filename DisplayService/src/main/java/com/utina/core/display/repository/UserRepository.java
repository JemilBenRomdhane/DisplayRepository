package com.utina.core.display.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.utina.core.display.entity.Users;




@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(String email);

    Optional<Users> findByUsernameOrEmail(String username, String email);

    List<Users> findByIdIn(List<Long> userIds);

    Optional<Users> findByUsername(String username);

    @Query("select v from Users v where v.id=:userid")
    Users findByUserId(Long userid);

    @Query("select v from Users v where v.username like %:username% and name like %:name%")
    List<Users> findByUserByNameofUsername(String username,String name);
    
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
}