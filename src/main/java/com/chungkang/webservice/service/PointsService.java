package com.chungkang.webservice.service;

import com.chungkang.webservice.domain.points.Points;
import com.chungkang.webservice.domain.points.PointsRepository;
import com.chungkang.webservice.dto.points.PointsMainResponseDto;
import com.chungkang.webservice.dto.points.PointsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PointsService {
    private PointsRepository pointsRepository;

    @Transactional
    public Long save(PointsSaveRequestDto dto){
        dto.setPermit("N");
        return pointsRepository.save(dto.toEntity()).getPoint_no();
    }

    @Transactional(readOnly = true)
    public List<PointsMainResponseDto> findAllPoints() {
        return pointsRepository.findAllPoints()
                .map(PointsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PointsMainResponseDto> findByPermit() {
        return pointsRepository.findByPermit()
                .map(PointsMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public int countPermit() {
        return (int)pointsRepository.countPermit();
    }

    @Transactional(readOnly = true)
    public Points findOne(Long point_no) {
        return pointsRepository.findOne(point_no);
    }
}
