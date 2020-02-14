package com.littlema.forspringboot.comtroller;

import com.littlema.forspringboot.exceptioin.UserNotExitException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class Login {

    @PostMapping("/loginCheck")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Map<String,Object> map,
                        HttpSession session){
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            map.put("msg","账号或密码不能为空");
            return "/login";
        }
        if("123456".equals(username)&&"4396".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/index.html";
        }
        map.put("msg","账号或密码错误");
        return "/login";
    }

    @GetMapping("examException")
    @ResponseBody
    public String examException(String user){
        if(!"4396".equals(user)){
            throw new UserNotExitException();
        }
        return "77777";
    }
}
