package com.littlema.forspringboot.exceptioin;


public class UserNotExitException extends RuntimeException {

    public UserNotExitException(){
        super("用户不存在");
    }
}
