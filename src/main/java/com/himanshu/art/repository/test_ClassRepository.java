package com.himanshu.art.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.himanshu.art.entity.Test_Class;

public interface test_ClassRepository extends  JpaRepository<Test_Class, Integer>{
@Query("select tc.Class_id from Test_Class as tc where tc.Test_id in(?1) ")
List<Integer> FindClassIdByTestId(List<Integer> tid);

}
