package com.himanshu.art.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.himanshu.art.entity.MyClass;

public interface MyClassRepository extends JpaRepository<MyClass, Integer> {

	@Query("Select c From MyClass as c where c.class_id in(?1)")
	List<MyClass> fetchAllClassDetails(List<Integer> class_idList);
	/*
	 * @Query("Select * From MyClass") List<MyClass> fetchAllClassDetails();
	 * 
	 * @Query("SELECT * FROM MyClass c WHERE c.name= ?1") MyClass
	 * findByClassName(String name);
	 * 
	 * @Query("SELECT * FROM myClass WHERE class_id= ?1") MyClass
	 * findByClassID(Integer id);
	 */
}
