package com.chungkang.webservice.domain.points;

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
public class Points extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long point_no;      // 포인트번호

    @Column(length = 500, nullable = false)
    private String name;        // 포인트명칭

    @Column(nullable = false)
    private String location;    // 좌표

    @Column(columnDefinition = "TEXT", nullable = false)
    private String memo;        // 메모

    private String author;      // 요청자

    @Builder
    public Points(Long point_no, String name, String location, String memo, String author) {
        this.point_no = point_no;
        this.name = name;
        this.location = location;
        this.memo = memo;
        this.author = author;
    }
}
