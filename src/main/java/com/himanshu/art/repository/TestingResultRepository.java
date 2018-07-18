package com.himanshu.art.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.art.entity.TestingResult;

public interface TestingResultRepository extends
		JpaRepository<TestingResult, Integer> {

/*
	@Query("Select * From TestingResult")
	List<TestingResult> fetchAllTestngResultDetails();

	@Query("SELECT * FROM TestingResult WHERE tst_res_id= ?1")
	TestingResult findByTestngResultID(Integer id);*/

}
