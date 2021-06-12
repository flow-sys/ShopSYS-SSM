package com.ourfinal.Controller;

import com.ourfinal.DAO.User;
import com.ourfinal.Service.UserService;
import com.ourfinal.exeption.InsertException;
import com.ourfinal.exeption.LoginException;
import com.ourfinal.utils.MD5Util;
import com.ourfinal.utils.UUIDUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login.do")
    public Map<String,Object> login(String loginAct, String loginPwd, HttpServletRequest request){
        User user = null;
        Map<String,Object> map = new HashMap<>();
        loginPwd = MD5Util.getMD5(loginPwd);
        try {
            user = userService.findUserByActAndPwd(loginAct,loginPwd);
            request.getSession().setAttribute("user",user);
            String type = user.getType();
            map.put("success",true);
            map.put("type",type);
            return map;
        } catch (LoginException loginException) {
            loginException.printStackTrace();
            map.put("success",false);
            map.put("msg", loginException.getMessage());
            return map;
        }
    }

    @ResponseBody
    @RequestMapping("/register.do")
    public Map<String,Object> register(User user){
        String type = "0";
        String id = UUIDUtil.getUUID();
        String loginPwd = user.getLoginPwd();
        loginPwd = MD5Util.getMD5(loginPwd);
        user.setId(id);
        user.setType(type);
        user.setLoginPwd(loginPwd);
        Map<String,Object> map = new HashMap<>();
        try {
            boolean flag = userService.register(user);
            map.put("success",flag);
            return map;
        } catch (InsertException insertException) {
            map.put("success",false);
            map.put("msg",insertException.getMessage());
            return map;
        }
    }

}
