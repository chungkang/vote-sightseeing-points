package com.chungkang.webservice.domain.points;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface PointsRepository extends JpaRepository<Points, Long>{

    @Query("SELECT p " +
            "FROM Points p ")
    Stream<Points> findAllPoints();
}
