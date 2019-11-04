package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.News_List;

import java.util.List;

public interface NewsService {
    List<News_List> findNews();

    News_List findById(Integer nl_id);

    void insertNews(News_List news_list);

    void deleteNews(Integer noticeIds);

    void updateNews(News_List news_list);
}
