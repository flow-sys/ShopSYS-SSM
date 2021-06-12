package com.ourfinal.Service;

import com.ourfinal.DAO.User;
import com.ourfinal.exeption.InsertException;
import com.ourfinal.exeption.LoginException;

public interface UserService {
    User findUserByActAndPwd(String loginAct, String loginPwd) throws LoginException;

    boolean register(User user) throws InsertException;
}
