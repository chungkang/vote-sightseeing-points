package com.chungkang.webservice.dto.members;

import com.chungkang.webservice.domain.members.Members;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class MembersMainResponseDto {

    private Long member_no;       // 회원번호
    private String name;        // 이름
    private String email;       // 이메일
    private String password;    // 비밀번호
    private String modifiedDate;    // 최종수정일

    public MembersMainResponseDto(Members entity) {
        member_no = entity.getMember_no();
        name = entity.getName();
        email = entity.getEmail();
        password = entity.getPassword();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
