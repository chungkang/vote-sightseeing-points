package com.chungkang.webservice.domain.members;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Authorities{

    @Id
    private Long member_no;

    @Column(length = 100, nullable = false)
    private String authority;

    @Builder
    public Authorities(Long member_no, String authority) {
        this.member_no = member_no;
        this.authority = authority;
    }
}
