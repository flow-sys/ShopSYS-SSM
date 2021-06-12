package com.ourfinal.exeption;

public class DeleteException extends Exception{
    public DeleteException(){
        super("删除失败");
    }
}
