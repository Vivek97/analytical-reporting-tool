package com.himanshu.art.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.art.entity.Element;

public interface ElementsRepository extends JpaRepository<Element, Integer> {

}
