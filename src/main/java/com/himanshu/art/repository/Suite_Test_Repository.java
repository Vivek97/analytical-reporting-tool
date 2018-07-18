package com.himanshu.art.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.himanshu.art.entity.Suite_Test;

public interface Suite_Test_Repository extends JpaRepository<Suite_Test, Integer> {
	
	@Query("select t.test_id from Suite_Test as t where t.suite_id=?1" )
	List<Integer> FindTest_idBySuite_ID(Integer id);

}
