package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.dao.NewsSubTypeMapper;
import com.gooalgene.labtest.dao.NewsTypeMapper;
import com.gooalgene.labtest.entity.News_List;
import com.gooalgene.labtest.entity.News_SubType;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    @Autowired
    NewsSubTypeMapper newsSubTypeMapper;
    @Autowired
    NewsTypeMapper newsTypeMapper;

    @GetMapping("/deleteById/{id}")
    public BaseResponse<String> DeleteNotice1(@RequestParam("id") int id) {
        BaseResponse<String> response = new BaseResponse<>();
        noticeService.deleteNotices(id);
        response.setResult("删除成功");
        return response;
    }
    @GetMapping("/deleteById")
    public BaseResponse<String> DeleteNotice(@RequestParam("id") int id) {
        BaseResponse<String> response = new BaseResponse<>();
        noticeService.deleteNotices(id);
        response.setResult("删除成功");
        return response;
    }
    @GetMapping("/findById")
    public BaseResponse<Map> GetNotice(@RequestParam("id") int id) {
        BaseResponse<Map> response = new BaseResponse<>();
        Map m = new HashMap();
        News_List n = noticeService.findById(id);
        m.put("notice", n);
        m.put("type", newsSubTypeMapper.findByType(newsTypeMapper.findByName("公告").getNt_id()));
        response.setResult(m);
        return response;
    }
    @GetMapping("/findById/{id}")
    public BaseResponse<Map> GetNotice2(@RequestParam("id") int id) {
        BaseResponse<Map> response1 = new BaseResponse<Map>();
        Map m = new HashMap();
        News_List n = noticeService.findById(id);
        m.put("notice", n);
        m.put("type", newsSubTypeMapper.findByType(newsTypeMapper.findByName("公告").getNt_id()));
        System.out.println(m);
        response1.setResult(m);
        return response1;
    }
    @GetMapping("/findAll")
    public BaseResponse<List<News_List>> findAll() {
        BaseResponse<List<News_List>> response = new BaseResponse<>();
        List<News_List> list = noticeService.findNotice();
        response.setResult(list);
        return response;
    }
    @PostMapping("/updateNotice")
    public BaseResponse<String> update(@RequestBody News_List news) {
        BaseResponse<String> response = new BaseResponse<>();
        News_SubType ns = newsSubTypeMapper.findById(news.getNl_subType_id());
        news.setNl_type_id(ns.getNs_type_id());
        System.out.println(news);
        System.out.println(news.getNl_date());
        noticeService.updateNotice(news);
        response.setResult("更新成功");
        return response;
    }

    @PostMapping("/insertNotice")
    public BaseResponse<String> Insert(@RequestBody News_List news) {
        BaseResponse<String> response = new BaseResponse<>();
        News_SubType ns = newsSubTypeMapper.findById(news.getNl_subType_id());
        news.setNl_type_id(ns.getNs_type_id());
        System.out.println(news);
        System.out.println(news.getNl_date());
        noticeService.insertNotice(news);
        response.setResult("插入成功");
        return response;
    }


}
