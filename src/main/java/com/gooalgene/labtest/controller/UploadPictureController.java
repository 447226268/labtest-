package com.gooalgene.labtest.controller;


import com.gooalgene.labtest.dao.NewsSubTypeMapper;
import com.gooalgene.labtest.dao.NewsTypeMapper;
import com.gooalgene.labtest.entity.News_List;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.UploadPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadPictureController {
    @Autowired
    NewsSubTypeMapper newsSubTypeMapper;
    @Autowired
    NewsTypeMapper newsTypeMapper;
    @Autowired
    private UploadPictureService uploadPictureService;

//    @GetMapping("/findHeadline")
//    public BaseResponse<Map> GetHeadline() {
//        BaseResponse<Map> response = new BaseResponse<Map>();
//        Map m = new HashMap();
//        News_List n = newsService.findById(id);
//        m.put("notice", n);
//        m.put("type", newsSubTypeMapper.findByType(newsTypeMapper.findByName("新闻").getNt_id()));
//        response.setResult(m);
//        return response;
//    }
//
//    @GetMapping("/findById/{id}")
//    public BaseResponse<Map> GetNotice2(@RequestParam("id") int id) {
//        BaseResponse<Map> response1 = new BaseResponse<Map>();
//        Map m = new HashMap();
//        News_List n = newsService.findById(id);
//        m.put("notice", n);
//        m.put("type", newsSubTypeMapper.findByType(newsTypeMapper.findByName("新闻").getNt_id()));
//        System.out.println(m);
//        response1.setResult(m);
//        return response1;
//    }

    @GetMapping("/findHeadline")
    public BaseResponse<List<News_List>> findHeadline() {
        BaseResponse<List<News_List>> response = new BaseResponse<>();
        List<News_List> list = uploadPictureService.findHeadline();
        response.setResult(list);
        return response;
    }

    @GetMapping("/findAcademic")
    public BaseResponse<List<News_List>> findAcademic() {
        BaseResponse<List<News_List>> response = new BaseResponse<>();
        List<News_List> list = uploadPictureService.findAcademic();
        response.setResult(list);
        return response;
    }
}
