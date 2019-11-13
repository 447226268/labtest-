package com.gooalgene.labtest.controller;


import com.gooalgene.labtest.entity.Homepage_links;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/link")
public class LinkController {
    @Autowired
    private LinksService linksService;

    @GetMapping("/getLinks")
    public BaseResponse<List<Homepage_links>> getNewsFigure() {
        BaseResponse<List<Homepage_links>> response = new BaseResponse<>();
        response.setResult(linksService.findAll());
        return response;
    }

    @PostMapping("/insertLink")
    public BaseResponse<String> insertLink(@RequestBody List<Homepage_links> homepage_links) {
        BaseResponse<String> response = new BaseResponse<>();
        List<Homepage_links> list = linksService.findAll();
        for (int i = 0; i < list.size(); i++) {
            linksService.deleteLink(list.get(i).getHl_id());
        }
        for (int i = 0; i < homepage_links.size(); i++) {
            linksService.insertLink(homepage_links.get(i));
        }
        response.setResult("插入成功");
        return response;
    }


}
