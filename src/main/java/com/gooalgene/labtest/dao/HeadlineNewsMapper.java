package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.HeadlineNews;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeadlineNewsMapper {
    List<HeadlineNews> findHeadlineNews();

    void updateHeadlineNews(HeadlineNews headlineNews);

    void insertHeadlineNews(HeadlineNews headlineNews);
}
