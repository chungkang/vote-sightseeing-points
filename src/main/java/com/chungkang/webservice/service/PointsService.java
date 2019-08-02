package com.chungkang.webservice.service;

import com.chungkang.webservice.domain.points.PointsRepository;
import com.chungkang.webservice.dto.points.PointsMainResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PointsService {
    private PointsRepository pointsRepository;

    @Transactional(readOnly = true)
    public List<PointsMainResponseDto> findAllPoints() {
        return pointsRepository.findAllPoints()
                .map(PointsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
