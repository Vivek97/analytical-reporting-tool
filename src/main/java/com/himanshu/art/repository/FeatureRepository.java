package com.himanshu.art.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.art.entity.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Integer> {

}
