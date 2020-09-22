package com.kyunghwan.loginskeleton.Account;


import com.kyunghwan.loginskeleton.Account.dto.AccountDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("로그인 화면 조회 테스트")
    @Test
    public void getSignIn() throws Exception {
        mockMvc.perform(get("/sign-in"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("account/sign-in"))
        ;
    }

    @DisplayName("리소스 적용 테스트")
    @Test
    public void getResource() throws Exception {
        mockMvc.perform(get("/css/sign-in.css"))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

    @DisplayName("회원가입 화면 조회 테스트")
    @Test
    public void getSignUp() throws Exception {
        mockMvc.perform(get("/sign-up"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("account/sign-up"))
        ;
    }

    @DisplayName("회원가입 성공 테스트")
    @Test
    public void successSignUp() throws Exception {
        String email = "email@email.com";
        String password = "password";

        mockMvc.perform(post("/sign-up")
                .param("email", email)
                .param("password", password)
                .with(csrf()))
                .andDo(print())
                .andExpect(status().isCreated())
        ;
    }

}