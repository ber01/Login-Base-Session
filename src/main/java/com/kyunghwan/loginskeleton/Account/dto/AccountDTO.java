package com.kyunghwan.loginskeleton.Account.dto;

import com.kyunghwan.loginskeleton.Account.Account;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class AccountDTO {

    public String email;

    public String password;

    public Account toEntity(PasswordEncoder passwordEncoder) {
        return Account.builder()
                .email(this.email)
                .password(passwordEncoder.encode(this.password))
                .build();
    }
}
