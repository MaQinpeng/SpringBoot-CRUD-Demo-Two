package com.littlema.forspringboot.comtroller;

import com.littlema.forspringboot.exceptioin.UserNotExitException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandlr {

//    @ResponseBody
//    @ExceptionHandler(UserNotExitException.class)
//    public Map<String,Object> handleException(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("message","用户不存在");
//        map.put("date",new Date());
//        map.put("code","userNotExit");
//        return map;
//    }

    @ExceptionHandler(UserNotExitException.class)
    public String handleException(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("message","用户不存在");
        map.put("date",new Date());
        map.put("code","userNotExit");
        request.setAttribute("javax.servlet.error.status_code",400);
        request.setAttribute("ext",map);
        return "forward:/error";
    }

}
