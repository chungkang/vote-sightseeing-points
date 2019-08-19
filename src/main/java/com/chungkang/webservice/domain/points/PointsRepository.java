package com.chungkang.webservice.domain.points;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.stream.Stream;

public interface PointsRepository extends JpaRepository<Points, Long>{

    @Query("SELECT p FROM Points p ORDER BY p.modifiedDate DESC ")
    Stream<Points> findAllPoints();

    @Query("SELECT p FROM Points p WHERE p.permit='Y' ORDER BY p.point_no DESC")
    Stream<Points> findByPermit();

    @Query("SELECT count(p) FROM Points p WHERE p.permit='Y'")
    int countPermit();
}
