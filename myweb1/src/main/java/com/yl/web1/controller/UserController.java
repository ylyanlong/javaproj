package com.yl.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/3/22.
 */
@Controller
public class UserController {

    /*@RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(String username, String password){
        if(this.checkParams(new String[]{username, password})){
            ModelAndView modelAndView = new ModelAndView("success_login");
            modelAndView.addObject("username", username);
            modelAndView.addObject("password", password);

            return modelAndView;
        }

        return new ModelAndView("home");
    }*/


    /***
	 * 另一种参数传递的形式
	 * 通过request来处理请求过来的参数。
	 * @param username
	 * @param password
	 * @param request
	 * @return
     */
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView login(String username,String password,HttpServletRequest request){
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		return new ModelAndView("success_login");
	}

    private boolean checkParams(String[] params){
        for(String param: params){
            if((param.equals("")) || (param == null) || (param.isEmpty())){
                return false;
            }
        }

        return true;
    }
}
