package com.qiuxk.learn_lamada.exception;

public class BaseException extends Throwable {

    public  BaseException(){
        super();
    }

    public  BaseException(String errorMsg){
       super(errorMsg);
    }

    @Override
    public String  getMessage(){
       return  "error message";
    }
}
