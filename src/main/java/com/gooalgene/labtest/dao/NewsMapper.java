package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.News_List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {

    News_List findById(@Param("nl_id") Integer nl_id);


    List<News_List> findNews();

    void deleteNews(@Param("nl_id") Integer noticeIds);

    void addNews(News_List news_list);

    void updateNews(News_List news_list);

}



