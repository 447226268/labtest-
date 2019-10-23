package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.service.impl.PostgraduateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postgraduate")
public class PostgraduateController {
    @Autowired
    private PostgraduateServiceImpl postgraduateService;
}
