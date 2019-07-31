package com.chungkang.webservice.domain.votes;

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
public class Votes extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long vote_no;

    @Column
    private Long point_no;

    @Column
    private Long user_no;

    @Builder
    public Votes(Long vote_no, Long point_no, Long user_no) {
        this.vote_no = vote_no;
        this.point_no = point_no;
        this.user_no = user_no;
    }
}
