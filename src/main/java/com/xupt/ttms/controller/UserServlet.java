package com.xupt.ttms.controller;

import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaType;
import com.xupt.ttms.pojo.Code;
import com.xupt.ttms.pojo.User;
import com.xupt.ttms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/userServlet")
@Controller
public class UserServlet {
    private String message;
    @Autowired
    private UserService userService;
    @Autowired
    private Code code;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public Code login(HttpServletRequest httpServletRequest,User user2, @RequestParam("captcha") String captcha, HttpServletRequest request) throws Exception {
        String error = "";
        boolean flag = HappyCaptcha.verification(request, captcha, true);
        if (!flag) {  //验证码输入错误
            error = "验证码输入有误";
            HappyCaptcha.remove(request);//清理验证码
            code.setInfo(error);
            return code;
        }
        String username = user2.getUsername();
        String password = user2.getPassword();
        System.out.println(username + " " + password);
        User user = userService.getUserByUsername(username);
        if (user == null) {
            error = "用户不存在";
            code.setInfo(error);
            return code;
        }
        User user1 = userService.getUserByUsernameAndPwd(username, password);
        if (user1 == null) {
            error = "密码错误";
        }
        if (user1 != null) {
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user",user1);
            error = "登陆成功";
        }
        code.setInfo(error);
        return code;
    }

    @RequestMapping(value = "/user/checkUserName/{username}", method = RequestMethod.POST)
    @ResponseBody
    public Code checkUserName(@PathVariable("username") String username) {
        String error = "";
        if (userService.getUserByUsername(username) != null) {
            error += "用户名已存在";
        }else {
            error+="用户名不存在";
        }
        code.setInfo(error);
        return code;
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public Code register(User user,@RequestParam("captcha") String captcha,HttpServletRequest request) {
        String error = "";
        boolean flag = HappyCaptcha.verification(request, captcha, true);
        if (!flag) {  //验证码输入错误
            error = "验证码输入有误";
            HappyCaptcha.remove(request);//清理验证码
            code.setInfo(error);
            return code;
        }
        System.out.println(user+"1111111111111111111111");
        int i = userService.register(user);
        if (i == 1) {
            code.setInfo("注册成功");
            return code;
        }
        code.setInfo("");
        return code;
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
    }

    @RequestMapping(value = "/user/forgetPassword", method = RequestMethod.POST)
    @ResponseBody
    public Code forgetPassword(User user,@RequestParam("captcha") String captcha,HttpServletRequest request) {
        String error = "";
        boolean flag = HappyCaptcha.verification(request, captcha, true);
        if (!flag) {  //验证码输入错误
            error = "验证码输入有误";
            HappyCaptcha.remove(request);//清理验证码
            code.setInfo(error);
            return code;
        }
        if (userService.getUserByUsernameAndPwd(user.getUsername(), user.getPassword())!=null){
            code.setInfo("新密码不能与原密码一致，请重新输入");
            return code;
        }
        int i = userService.updateUserByUsernameAndPhone(user.getUsername(), user.getPassword(), user.getPhone());
        if (i < 1) {
            code.setInfo("预留手机号输入有误，请重新输入");
            return code;
        } else {
            code.setInfo("修改成功");
            return code;
        }
    }

    //获取验证码
    @GetMapping("/captcha")
    public void happyCaptcha(HttpServletRequest request, HttpServletResponse response) {
        HappyCaptcha.require(request, response).type(CaptchaType.ARITHMETIC).build().finish();
    }//获取验证码
    @GetMapping("/captchaCommon")
    public void happyCaptchaCommon(HttpServletRequest request, HttpServletResponse response) {
        HappyCaptcha.require(request, response).type(CaptchaType.DEFAULT).build().finish();
    }



}