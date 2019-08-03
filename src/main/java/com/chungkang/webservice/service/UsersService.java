package com.chungkang.webservice.service;

import com.chungkang.webservice.domain.users.UsersRepository;
import com.chungkang.webservice.dto.users.UsersMainResponseDto;
import com.chungkang.webservice.dto.users.UsersSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UsersService {
    private UsersRepository usersRepository;

    @Transactional
    public Long save(UsersSaveRequestDto dto){
        BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
        String password = scpwd.encode(dto.getPassword());
        dto.setPassword(password);
        return usersRepository.save(dto.toEntity()).getUser_no();
    }

    @Transactional(readOnly = true)
    public List<UsersMainResponseDto> findAllDesc() {
        return usersRepository.findAllDesc()
                .map(UsersMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
