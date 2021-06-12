package com.ourfinal.exeption;

public class RepeatIdException extends Exception{
    public RepeatIdException(){
        super("此ID重复请修改一个唯一的ID");
    }
}
