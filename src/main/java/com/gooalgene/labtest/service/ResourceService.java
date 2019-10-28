package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.News_List;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceService {


    List<News_List> findResource();
    News_List findById(Integer nl_id);



    void insertResource(News_List news_list);

    void deleteResource(Integer resourceIds);
    /*void updateState(News_List news_list);*/

    void updateResource(News_List news_list);
}
