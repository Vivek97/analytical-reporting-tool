package com.himanshu.art.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.art.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
