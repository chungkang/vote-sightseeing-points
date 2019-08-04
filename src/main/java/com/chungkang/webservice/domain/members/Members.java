package com.chungkang.webservice.domain.members;

import com.chungkang.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Members extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long member_no;

    @Column(length = 500, nullable = false)
    private String name;

    @Column(length = 500, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Builder
    public Members(Long member_no, String name, String email, String password) {
        this.member_no = member_no;
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
