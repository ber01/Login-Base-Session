package com.kyunghwan.loginskeleton.Account;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/")
    public String getMain() {
        return "main";
    }

    @GetMapping("/sign-in")
    public String getLogin() {
        return "account/sign-in";
    }

}
