package com.yl.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/3/22.
 */
@Controller
public class OtherController {

    @RequestMapping("other")
    public String other(){
        return "other";
    }
}
