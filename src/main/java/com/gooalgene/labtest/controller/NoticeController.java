package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.dao.NoticeMapper;
import com.gooalgene.labtest.entity.News_List;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.NoticeService;
import com.gooalgene.labtest.service.impl.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test2")
public class NoticeController {
    @Autowired
    private StaffServiceImpl staffServiceImpl;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private NoticeMapper noticeMapper;
    @GetMapping("/hello")
    public BaseResponse<List<News_List>> hello() {
        BaseResponse<List<News_List>> response = new BaseResponse<>();
//        News_List n= noticeService.findById(1);
        List<News_List> list1 = noticeService.findNotice();

//        for(News_List n:list1){
//            if(n.getNl_type_id()==)
//            System.out.println(n);
//        }
////        list.add(n);
        response.setResult(list1);
        return response;
    }

    @GetMapping("/hello1")
    public BaseResponse<News_List> GetNotice(@PathVariable int nl_id) {
        News_List n = noticeService.findById(nl_id);
        return new BaseResponse<>(n);
    }
}
