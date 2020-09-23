package com.kyunghwan.loginskeleton.Account.dto;

import com.kyunghwan.loginskeleton.Account.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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

    public Account toEntity(PasswordEncoder passwordEncoder) {
        return Account.builder()
                .email(this.email)
                .password(passwordEncoder.encode(this.password))
                .build();
    }

}
