package com.chungkang.webservice.dto.users;

import com.chungkang.webservice.domain.users.Users;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class UsersMainResponseDto {

    private Long user_no;       // 회원번호
    private String name;        // 이름
    private String email;       // 이메일
    private String password;    // 비밀번호
    private String modifiedDate;

    public UsersMainResponseDto(Users entity) {
        user_no = entity.getUser_no();
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
