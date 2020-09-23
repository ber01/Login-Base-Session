package com.kyunghwan.loginskeleton.Account;

import com.kyunghwan.loginskeleton.Account.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String getMain() {
        return "main";
    }

    @GetMapping("/sign-in")
    public String getSignIn() {
        return "account/sign-in";
    }

    @GetMapping("/sign-up")
    public String getSignUp() {
        return "account/sign-up";
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody AccountDTO accountDTO) {
        System.out.println("POST /sign-up");
        System.out.println(accountDTO);
        accountRepository.save(accountDTO.toEntity(passwordEncoder));
        return new ResponseEntity<>("회원가입 성공!", HttpStatus.CREATED);
    }

}
