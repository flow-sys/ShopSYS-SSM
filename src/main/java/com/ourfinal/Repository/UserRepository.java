package com.ourfinal.Repository;

import com.ourfinal.DAO.User;

import java.util.Map;

public interface UserRepository {
    User findUserByActAndPwd(Map<String, String> map);

    int register(User user);
}
