package com.chungkang.webservice.dto.users;

import com.chungkang.webservice.domain.users.Users;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSaveRequestDto {

    private String name;
    private String email;
    private String password;

    @Builder
    public UsersSaveRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Users toEntity(){
        return Users.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
