package com.kyunghwan.loginskeleton.Account.dto;

import com.kyunghwan.loginskeleton.Account.Account;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
public class AccountDTO {

    @NotBlank
    @Email
    public String email;

    @NotBlank
    @Length(min = 8, max = 20)
    public String password;

    public Account toEntity(String pwd) {
        return Account.builder()
                .email(this.email)
                .password(pwd)
                .build();
    }

}
