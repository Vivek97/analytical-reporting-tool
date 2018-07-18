package com.himanshu.art.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.himanshu.art.entity.TestMethod;

public interface TestMethodRepository extends
		JpaRepository<TestMethod, Integer> {

	@Query("Select t from TestMethod as t where t.method_id in(?1)")
	List<TestMethod> fetchAllMethods();	
	
/*	@Query("Select * From TestMethod")
	List<TestMethod> fetchAllClassDetails();

	@Query("SELECT * FROM TestMethod t WHERE t.name= ?1")
	TestMethod findByMethodName(String name);
	
	@Query("SELECT * FROM TestMethod WHERE method_id= ?1")
	TestMethod findByMethodID(Integer id);*/
	

	@Query("Select tm From TestMethod as tm where tm.method_id in(?1)")
	List<TestMethod> fetchAllClassDetails(List<Integer> method_idList);

}
