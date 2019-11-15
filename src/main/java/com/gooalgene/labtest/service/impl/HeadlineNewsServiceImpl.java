package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.HeadlineNewsMapper;
import com.gooalgene.labtest.entity.HeadlineNews;
import com.gooalgene.labtest.service.HeadlineNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeadlineNewsServiceImpl implements HeadlineNewsService {
    @Autowired
    private HeadlineNewsMapper headlineNewsMapper;

    @Override
    public List<HeadlineNews> findHeadlineNews() {
        return headlineNewsMapper.findHeadlineNews();
    }

    @Override
    public void insertHeadlineNews(HeadlineNews headlineNews) {
        headlineNewsMapper.insertHeadlineNews(headlineNews);
    }

    @Override
    public void updateHeadlineNews(HeadlineNews headlineNews) {
        headlineNewsMapper.updateHeadlineNews(headlineNews);
    }
}
