package com.chungkang.webservice.dto.points;

import com.chungkang.webservice.domain.points.Points;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PointsSaveRequestDto {

    private String name;
    private String location;
    private String memo;
    private String permit;
    private String author;

    @Builder
    public PointsSaveRequestDto(String name, String location, String memo, String permit, String author) {
        this.name = name;
        this.location = location;
        this.memo = memo;
        this.permit = permit;
        this.author = author;
    }

    public Points toEntity(){
        return Points.builder()
                .name(name)
                .location(location)
                .memo(memo)
                .permit(permit)
                .author(author)
                .build();
    }
}
