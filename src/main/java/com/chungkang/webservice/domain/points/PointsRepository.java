package com.chungkang.webservice.domain.points;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;
import java.util.stream.Stream;

public interface PointsRepository extends JpaRepository<Points, Long>{

    @Query("SELECT p FROM Points p ")
    Stream<Points> findAllPoints();

    @Query("SELECT p FROM Points p WHERE p.permit='Y'")
    Stream<Points> findByPermit();

    @Query("SELECT count(p) FROM Points p WHERE p.permit='Y'")
    int countPermit();
}
