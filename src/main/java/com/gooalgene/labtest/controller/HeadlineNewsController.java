package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.entity.HeadlineNews;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.HeadlineNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/headlineNews")
public class HeadlineNewsController {
    @Autowired
    private HeadlineNewsService headlineNewsService;

    @GetMapping("/insertHeadlineNews")
    public BaseResponse<String> insertHeadlineNews(@RequestParam HeadlineNews headlineNews) {
        BaseResponse<String> response = new BaseResponse<>();
        if (headlineNews.getHh_date().compareTo(headlineNewsService.findHeadlineNews().get(4).getHh_date()) < 0) {
            response.setResult("插入失败");
        } else {
            headlineNews.setHh_id(headlineNewsService.findHeadlineNews().get(4).getHh_id());
            headlineNewsService.updateHeadlineNews(headlineNews);
            response.setResult("插入成功");
        }
        return response;
    }

    @GetMapping("/getFigure")
    public BaseResponse<List<HeadlineNews>> getHeadlineNews() {
        BaseResponse<List<HeadlineNews>> response = new BaseResponse<>();
        response.setResult(headlineNewsService.findHeadlineNews());
        return response;
    }
}
