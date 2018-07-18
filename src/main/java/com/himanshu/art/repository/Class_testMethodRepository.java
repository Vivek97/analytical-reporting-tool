package com.himanshu.art.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.himanshu.art.entity.Class_Testmethod;

public interface Class_testMethodRepository extends JpaRepository<Class_Testmethod, Integer>{
@Query("select cm.method_id from Class_Testmethod as cm where cm.class_id in (?1)")
List<Integer> FindMethodIdByClassId(List<Integer> id);
}
