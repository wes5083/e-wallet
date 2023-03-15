package com.demo.ewallet.service;

import com.demo.ewallet.entity.User;
import com.demo.ewallet.exception.NotSupportException;
import com.demo.ewallet.mapper.UserMapper;
import com.demo.ewallet.repo.UserRepo;
import com.demo.ewallet.utils.Constants;
import com.demo.ewallet.utils.MD5Util;
import com.demo.ewallet.utils.RandomUtil;
import com.demo.ewallet.vo.ResponseVo;
import com.demo.ewallet.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;

    /**
     * Register / add a user
     *
     * @param userVo
     * @return
     */
    public ResponseVo createUser(UserVo userVo) {

        var user = userRepo.findOneByAccount(userVo.getAccount()).orElse(null);
        if (user != null) {
            throw new NotSupportException(userVo.getAccount() + Constants.SEPARATOR_COMMA_DASH + Constants.USER_ALREADY_EXIST);
        }

        User newUser = userMapper.toEntity(userVo);
        String passKey = RandomUtil.generatePassKey();
        newUser.setPassKey(passKey);
        newUser.setPassword(MD5Util.getInstance().md5(userVo.getPassword(), passKey));

        userRepo.save(newUser);
        return ResponseVo.success(userVo);
    }

    /**
     * Login
     *
     * @param account
     * @param password
     * @return
     */
    public ResponseVo login(String account, String password) {
        var user = userRepo.findOneByAccount(account).orElse(null);
        if (user == null) {
            throw new NotSupportException(account + Constants.SEPARATOR_COMMA_DASH + Constants.USER_NOT_EXIST);
        }

        if (!user.getPassword().equals(MD5Util.getInstance().md5(password, user.getPassKey()))) {
            throw new NotSupportException(account + Constants.SEPARATOR_COMMA_DASH + Constants.USER_PASSWORD_ERROR);
        }

        return ResponseVo.success(userMapper.toVo(user));
    }


}