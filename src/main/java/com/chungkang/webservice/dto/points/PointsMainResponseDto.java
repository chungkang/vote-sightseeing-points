package com.chungkang.webservice.dto.points;

import com.chungkang.webservice.domain.points.Points;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PointsMainResponseDto {
    private Long point_no;      // 포인트번호
    private String name;        // 포인트명칭
    private String location;    // 좌표
    private String memo;        // 메모
    private String author;      // 요청자
    private String modifiedDate;

    public PointsMainResponseDto(Points entity) {
        point_no = entity.getPoint_no();
        name = entity.getName();
        location = entity.getLocation();
        memo = entity.getMemo();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
