package com.ourfinal.Service.Impl;

import com.ourfinal.DAO.User;
import com.ourfinal.Repository.UserRepository;
import com.ourfinal.Service.UserService;
import com.ourfinal.exeption.InsertException;
import com.ourfinal.exeption.LoginException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findUserByActAndPwd(String loginAct, String loginPwd) throws LoginException {
        Map<String,String> map = new HashMap<>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        User user = userRepository.findUserByActAndPwd(map);
        if(user == null){
            throw new LoginException();
        }
        return user;
    }

    @Override
    public boolean register(User user) throws InsertException {
        boolean flag = true;
        int count = userRepository.register(user);
        if(count != 1){
            throw new InsertException();
        }
        return flag;
    }
}
