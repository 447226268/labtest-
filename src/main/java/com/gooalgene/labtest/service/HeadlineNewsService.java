package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.HeadlineNews;

import java.util.List;

public interface HeadlineNewsService {
    List<HeadlineNews> findHeadlineNews();

    void insertHeadlineNews(HeadlineNews headlineNews);
    void updateHeadlineNews(HeadlineNews headlineNews);
}
