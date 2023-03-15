package com.demo.ewallet.controller;

import com.demo.ewallet.service.UserService;
import com.demo.ewallet.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Regist a user
     *
     * @param userVo
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserVo userVo) {
        return ResponseEntity.ok(userService.createUser(userVo));
    }

    /**
     * Login with account and pwd
     *
     * @param account
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ResponseEntity<?> login(String account, String password) {
        return ResponseEntity.ok(userService.login(account, password));
    }


}
