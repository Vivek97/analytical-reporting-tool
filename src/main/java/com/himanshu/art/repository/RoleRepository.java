package com.himanshu.art.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.art.entity.Role;


public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
