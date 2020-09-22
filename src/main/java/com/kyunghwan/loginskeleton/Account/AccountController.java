package com.kyunghwan.loginskeleton.Account;

import com.kyunghwan.loginskeleton.Account.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AccountController {

    AccountRepository accountRepository;
    PasswordEncoder passwordEncoder;

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
    public ResponseEntity<?> signUp(@RequestParam Map<String,String> allParams) {
        // accountRepository.save(accountDTO.toEntity(passwordEncoder));
        System.out.println(allParams);
        return new ResponseEntity<>("회원가입 성공!", HttpStatus.CREATED);
    }

}
