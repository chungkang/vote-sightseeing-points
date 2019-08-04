package com.chungkang.webservice.dto.members;

import com.chungkang.webservice.domain.members.Members;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MembersSaveRequestDto {

    private String name;
    private String email;
    private String password;

    @Builder
    public MembersSaveRequestDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Members toEntity(){
        return Members.builder()
                .name(name)
                .email(email)
                .password(password)
                .build();
    }
}
