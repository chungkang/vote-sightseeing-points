package com.chungkang.webservice.service;

import com.chungkang.webservice.domain.members.MembersRepository;
import com.chungkang.webservice.dto.members.MembersSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class MembersService {
    private MembersRepository membersRepository;

    @Transactional
    public Long save(MembersSaveRequestDto dto){
        BCryptPasswordEncoder scpwd = new BCryptPasswordEncoder();
        String password = scpwd.encode(dto.getPassword());
        dto.setPassword(password);
        return membersRepository.save(dto.toEntity()).getMember_no();
    }

    @Transactional(readOnly = true)
    public int emailCheck(String email) {
        return membersRepository.countByEmail(email);
    }
}
