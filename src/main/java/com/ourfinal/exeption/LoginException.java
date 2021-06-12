package com.ourfinal.exeption;

public class LoginException extends Exception{
    public LoginException(){
        super("用户名或密码错误");
    }
}
