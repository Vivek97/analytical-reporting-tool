package com.himanshu.art.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.art.entity.Embedding;

public interface EmbeddingRepository extends JpaRepository<Embedding, Integer> {

}
