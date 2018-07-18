package com.himanshu.art.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.art.entity.Match;

public interface MatchRepository extends JpaRepository<Match, Integer> {

}
