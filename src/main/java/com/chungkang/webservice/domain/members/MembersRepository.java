package com.chungkang.webservice.domain.members;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Long>{

    int countByEmail(String email);

}
