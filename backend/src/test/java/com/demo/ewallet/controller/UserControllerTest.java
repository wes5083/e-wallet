package com.demo.ewallet.controller;


import com.demo.ewallet.vo.UserVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Rollback
@Transactional
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    UserVo userVo = new UserVo();

    @BeforeEach
    void setUp() {
        userVo.setAccount("test");
        userVo.setPassword("123456");
    }

    @Test
    void testRegisterUser() throws Exception {
        var customerVoJson = objectMapper.writeValueAsString(userVo);
        var req = MockMvcRequestBuilders.post("/api/users/register")
                .content(customerVoJson);
        this.mockMvc.perform(req).andExpect(status().isOk());
    }

    @Test
    void testLogin() throws Exception {
        var customerVoJson = objectMapper.writeValueAsString(userVo);
        var req = MockMvcRequestBuilders.get("/api/users/login")
                .content(customerVoJson);
        this.mockMvc.perform(req).andExpect(status().isOk());
    }
}
