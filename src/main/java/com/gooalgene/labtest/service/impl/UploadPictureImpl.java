package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.NewsMapper;
import com.gooalgene.labtest.dao.NewsSubTypeMapper;
import com.gooalgene.labtest.dao.NewsTypeMapper;
import com.gooalgene.labtest.dao.UploadPictureMapper;
import com.gooalgene.labtest.entity.News_List;
import com.gooalgene.labtest.service.UploadPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UploadPictureImpl implements UploadPictureService {
    @Autowired
    UploadPictureMapper uploadPictureMapper;
    @Autowired
    private NewsTypeMapper newsTypeMapper;
    @Autowired
    private NewsSubTypeMapper newsSubTypeMapper;

    @Override
    public List<News_List> findAcademic() {
        List<News_List> list = uploadPictureMapper.findAcademic();
        List<News_List> list1 = new ArrayList<News_List>();
        for (News_List n : list) {
            if (n.getNl_subType_id() == newsSubTypeMapper.findByName("学术活动").getNs_id()) {
                n.setNl_nl_type_name(
                        newsTypeMapper.findById(n.getNl_type_id()).getNt_name());
                n.setNl_nl_subType_name(newsSubTypeMapper.findById(n.getNl_subType_id()).getNs_name());
                Date time = new Date(n.getNl_date().toString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                n.setRealTime(sdf.format(time));
                list1.add(n);
            }
        }
        return list1;
    }

    @Override
    public List<News_List> findHeadline() {
        List<News_List> list = uploadPictureMapper.findHeadline();
        List<News_List> list2 = new ArrayList<News_List>();
        for (News_List n : list) {
            if (n.getNl_subType_id() == newsSubTypeMapper.findByName("头条新闻").getNs_id()) {
                n.setNl_nl_type_name(
                        newsTypeMapper.findById(n.getNl_type_id()).getNt_name());
                n.setNl_nl_subType_name(newsSubTypeMapper.findById(n.getNl_subType_id()).getNs_name());
                Date time = new Date(n.getNl_date().toString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                n.setRealTime(sdf.format(time));
                list2.add(n);
            }
        }
        return list2;
    }
}

