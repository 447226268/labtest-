package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.entity.HeadlineNews;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.HeadlineNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/headlineNews")
public class HeadlineNewsController {
    @Autowired
    private HeadlineNewsService headlineNewsService;

    @GetMapping("/insertHeadlineNews")
    public BaseResponse<String> insertHeadlineNews(@RequestBody List<HeadlineNews> list) {
        BaseResponse<String> response = new BaseResponse<>();
        List<HeadlineNews> list1 = headlineNewsService.findHeadlineNews();
        for (int i = 0; i < list.size(); i++) {
            headlineNewsService.insertHeadlineNews(list.get(i));
        }
        return response;
    }

    @GetMapping("/getFigure")
    public BaseResponse<List<HeadlineNews>> getHeadlineNews() {
        BaseResponse<List<HeadlineNews>> response = new BaseResponse<>();
        List<HeadlineNews> list1 = headlineNewsService.findHeadlineNews();
        List<HeadlineNews> list = new ArrayList<HeadlineNews>();
        if (list1.size() < 5) {
            response.setResult(list1);
        } else {
            for (int i = 0; i < 5; i++) {
                list.add(list1.get(i));
            }
            response.setResult(list);
        }
        return response;
    }
}
