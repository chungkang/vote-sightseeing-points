package com.chungkang.webservice.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface UsersRepository extends JpaRepository<Users, Long>{

    @Query("SELECT p " +
            "FROM Users p " +
            "ORDER BY p.id DESC")
    Stream<Users> findAllDesc();
}
