package com.gooalgene.labtest.dao;


import com.gooalgene.labtest.entity.News_List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceMapper {

    News_List findById(@Param("nl_id") Integer nl_id);
    List<News_List> findResource();

    void deleteResource(@Param("nl_id") Integer resourceIds);

    void addResource(News_List notice);

    void updateState(News_List news_list);

    void updateResource(News_List news_list);
}
