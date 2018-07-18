package com.himanshu.art.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.himanshu.art.entity.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {

	/*@Query("SELECT * FROM Test")
	List<Test> FetchAllTestDetails();

	@Query("SELECT * FROM Test t WHERE t.name= ?1")
	Test FindByTestName(String name);

	@Query("SELECT * FROM Test t WHERE t.test_id= ?1")
	Test FindByTestId(Integer id);*/
	

	@Query("SELECT t FROM Test as t where t.name=?1")
	Test FetchAllTestDetails(String test_name);	


	@Query("SELECT t FROM Test t WHERE t.test_id in(?1)")
	List<Test> FindByTestName(List<Integer> test_idList);
	
	
}
