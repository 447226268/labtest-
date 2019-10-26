package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.dao.NewsSubTypeMapper;
import com.gooalgene.labtest.dao.NewsTypeMapper;
import com.gooalgene.labtest.entity.News_List;
import com.gooalgene.labtest.entity.News_SubType;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.NewsService;
import com.gooalgene.labtest.util.PicTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    NewsSubTypeMapper newsSubTypeMapper;
    @Autowired
    NewsTypeMapper newsTypeMapper;
    @Autowired
    private NewsService newsService;

    @GetMapping("/deleteById/{id}")
    public BaseResponse<String> DeleteNotice1(@RequestParam("id") int id) {
        BaseResponse<String> response = new BaseResponse<>();
        newsService.deleteNews(id);
        response.setResult("删除成功");
        return response;
    }

    @GetMapping("/deleteById")
    public BaseResponse<String> DeleteNotice(@RequestParam("id") int id) {
        BaseResponse<String> response = new BaseResponse<>();
        newsService.deleteNews(id);
        response.setResult("删除成功");
        return response;
    }

    @GetMapping("/findById")
    public BaseResponse<Map> GetNotice(@RequestParam("id") int id) {
        BaseResponse<Map> response = new BaseResponse<Map>();
        Map m = new HashMap();
        News_List n = newsService.findById(id);
        m.put("notice", n);
        m.put("type", newsSubTypeMapper.findByType(newsTypeMapper.findByName("新闻").getNt_id()));
        response.setResult(m);
        return response;
    }

    @GetMapping("/findById/{id}")
    public BaseResponse<Map> GetNotice2(@RequestParam("id") int id) {
        BaseResponse<Map> response1 = new BaseResponse<Map>();
        Map m = new HashMap();
        News_List n = newsService.findById(id);
        m.put("notice", n);
        m.put("type", newsSubTypeMapper.findByType(newsTypeMapper.findByName("新闻").getNt_id()));
        System.out.println(m);
        response1.setResult(m);
        return response1;
    }

    @GetMapping("/findAll")
    public BaseResponse<List<News_List>> findAll() {
        BaseResponse<List<News_List>> response = new BaseResponse<>();
        List<News_List> list = newsService.findNews();
        response.setResult(list);
        return response;
    }

    @PostMapping("/updateNews")
    public BaseResponse<String> update(@RequestBody News_List news) {
        BaseResponse<String> response = new BaseResponse<>();
        News_SubType ns = newsSubTypeMapper.findById(news.getNl_subType_id());
        news.setNl_type_id(ns.getNs_type_id());
        System.out.println(news);
        newsService.updateNews(news);
        response.setResult("更新成功");
        return response;
    }

    @PostMapping("/insertNews")
    public BaseResponse<String> Insert(@RequestBody News_List news) {
        BaseResponse<String> response = new BaseResponse<>();
        newsService.updateNews(news);
        newsService.insertNews(news);
        response.setResult("插入成功");
        return response;
    }
    @PostMapping("/uploadPic")
    public BaseResponse<String> upload(@RequestParam(name = "file", required = false) MultipartFile file) {
        BaseResponse<String> response = new BaseResponse<>();
        PicTool pt = new PicTool();
        System.out.println("---------------------");
        String s = pt.uploadFiles(file);
        System.out.println(s);
        System.out.println("---------------------");
        response.setResult(s);
        return response;
    }

}
