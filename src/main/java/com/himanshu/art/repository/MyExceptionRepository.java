package com.himanshu.art.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import com.himanshu.art.entity.MyException;

public interface MyExceptionRepository extends JpaRepository<MyException, Integer> {

	/*@Query("Select * From MyException")
	List<MyException> fetchAllExceptionDetails();

	@Query("SELECT * FROM MyException t WHERE t.cls= ?1")
	MyException findByExceptionClass(String name);
	
	@Query("SELECT * FROM MyException WHERE exception_id= ?1")
	MyException findByExceptionID(Integer id);*/
}
