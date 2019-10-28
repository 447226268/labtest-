package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.NewsSubTypeMapper;
import com.gooalgene.labtest.dao.NewsTypeMapper;
import com.gooalgene.labtest.dao.ResourceMapper;
import com.gooalgene.labtest.entity.News_List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ResourceServiceImpl implements com.gooalgene.labtest.service.ResourceService {
    @Autowired
    ResourceMapper resourceMapper;
    @Autowired
    private NewsTypeMapper newsTypeMapper;
    private NewsSubTypeMapper newsSubTypeMapper;

    @Override
    public List<News_List> findResource(){
        List<News_List> list = resourceMapper.findResource();
        List<News_List> list1 =  new ArrayList<>();
        for(News_List n : list){

            if(n.getNl_type_id() == newsTypeMapper.findByName( "资源").getNt_id()){
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
    public News_List findById(Integer nl_id){ return resourceMapper.findById(nl_id);}

    @Override
    public void insertResource(News_List news_list){
        news_list.setNl_type_id(newsSubTypeMapper.findById(news_list.getNl_subType_id()).getNs_type_id());
        resourceMapper.addResource(news_list);
    }

    @Override
    public void deleteResource(Integer nl_id) {
        resourceMapper.deleteResource(nl_id);
    }

    @Override
    public void updateResource(News_List news_list) {
        news_list.setNl_type_id(newsSubTypeMapper.findById(news_list.getNl_subType_id()).getNs_type_id());
        resourceMapper.updateResource(news_list);
    }
}

