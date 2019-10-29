package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.dao.NewsSubTypeMapper;
import com.gooalgene.labtest.dao.NewsTypeMapper;
import com.gooalgene.labtest.entity.News_List;
import com.gooalgene.labtest.entity.News_SubType;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    NewsSubTypeMapper newsSubTypeMapper;
    @Autowired
    NewsTypeMapper newsTypeMapper;

    @GetMapping("/deleteById/{id}")
    public BaseResponse<String> DeleteResource1(@RequestParam("id")  int id){
        BaseResponse<String> response = new BaseResponse<>();
        resourceService.deleteResource(id);
        response.setResult("删除成功");
        return response;
    }

    @GetMapping("/deleteById")
    public BaseResponse<String> DeleteResource(@RequestParam("id") int id) {
        BaseResponse<String> response = new BaseResponse<>();
        resourceService.deleteResource(id);
        response.setResult("删除成功");
        return response;
    }

    @GetMapping("/findById")
    public BaseResponse<Map> GetResource(@RequestParam("id") int id){
        BaseResponse<Map> response = new BaseResponse<Map>();
        Map m = new HashMap();
        News_List n = resourceService.findById(id);
        m.put("resource",n);
        m.put("type",newsSubTypeMapper.findByType(newsTypeMapper.findByName("资源").getNt_id()));
        System.out.println(m);
        response.setResult(m);
        return response;
    }

    @GetMapping("/findById/{id}")
    public BaseResponse<Map> GetResource1(@RequestParam("id") int id){
        BaseResponse<Map> response1 = new BaseResponse<Map>();
        Map m = new HashMap();
        News_List n = resourceService.findById(id);
        m.put("resource",n);
        m.put("type",newsSubTypeMapper.findByType(newsTypeMapper.findByName("资源").getNt_id()));
        System.out.println(m);
        response1.setResult(m);
        return response1;
    }

    @GetMapping("/findAll")
    public BaseResponse<List<News_List>> findAll(){
        BaseResponse<List<News_List>> response = new BaseResponse<>();
        List<News_List> list = resourceService.findResource();
        response.setResult(list);
        return response;
    }

    @PostMapping("/updateResource")
    public BaseResponse<String> update(@RequestBody News_List news_list){
        BaseResponse<String> response = new BaseResponse<>();
        News_SubType ns = newsSubTypeMapper.findById(news_list.getNl_subType_id());
        System.out.println(news_list);
        resourceService.updateResource(news_list);
        response.setResult("更新成功");
        return response;
    }

    @GetMapping("/insertResource")
    public BaseResponse<String> Insert(@RequestBody News_List news_list){
        BaseResponse<String> response = new BaseResponse<>();
        News_SubType ns = newsSubTypeMapper.findById(news_list.getNl_subType_id());
        news_list.setNl_type_id(ns.getNs_type_id());
        System.out.println(news_list);
        System.out.println(news_list.getNl_date());
        resourceService.insertResource(news_list);
        response.setResult("插入成功");
        return response;
    }
}
