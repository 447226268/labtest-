package com.gooalgene.labtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 2019/10/9 15:24
 *
 * @author XL
 * @version 1.0
 */
@RestController
@RequestMapping("/test")
public class IndexController {

    @GetMapping("/hello")
    public List<String> hello(){
        List<String> list = Arrays.asList("name:11","a:11");
        return list;
    }
}
