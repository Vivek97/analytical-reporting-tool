package com.himanshu.art.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.himanshu.art.entity.Suite;

public interface SuiteRepository extends JpaRepository<Suite, Integer> {
	/*
	 * @Query("Select * From Suite") List<Suite> fetchAllSuiteDetails();
	 * 
	 * @Query("SELECT * FROM Suite s WHERE s.name= ?1") Suite
	 * findBySuiteName(String name);
	 * 
	 * @Query("SELECT * FROM Suite WHERE suite_id= ?1") Suite
	 * findBySuiteID(Integer id);
	 */

	@Query("Select s  From Suite as s where s.suite_id in(?1)")
	List<Suite> fetchAllSuiteDetails(List<Integer> Suite_idList);

	@Query("SELECT s FROM Suite s WHERE s.name= ?1")
	Suite findBySuiteName(String name);

}
