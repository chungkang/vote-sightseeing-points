package com.chungkang.webservice.domain.votes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface VotesRepository extends JpaRepository<Votes, Long>{

    @Query("SELECT p " +
            "FROM Votes p " +
            "ORDER BY p.id DESC")
    Stream<Votes> findAllDesc();
}
