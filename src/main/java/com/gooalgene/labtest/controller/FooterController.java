package com.gooalgene.labtest.controller;


import com.gooalgene.labtest.entity.Homepage_footer;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.FootersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/footer")
public class FooterController {
    @Autowired
    private FootersService footersService;

    @GetMapping("/getFooters")
    public BaseResponse<List<Homepage_footer>> getNewsFigure() {
        BaseResponse<List<Homepage_footer>> response = new BaseResponse<>();
        response.setResult(footersService.findAll());
        return response;
    }

    @PostMapping("/insertFooter")
    public BaseResponse<String> insertLink(@RequestBody List<Homepage_footer> homepage_footer) {
        BaseResponse<String> response = new BaseResponse<>();
        List<Homepage_footer> list = footersService.findAll();
        for (int i = 0; i < list.size(); i++) {
            footersService.deleteFooter(list.get(i).getHf_id());
        }
        for (int i = 0; i < homepage_footer.size(); i++) {
            footersService.insertFooter(homepage_footer.get(i));
        }
        response.setResult("插入成功");
        return response;
    }
}
