package com.wj.ding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @date 2022/4/30 16:04
 * @author: wj
 */
@RestController
public class FilesController {

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("download")
    public void download(){
        
    }

}
