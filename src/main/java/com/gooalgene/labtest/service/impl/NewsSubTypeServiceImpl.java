package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.NewsSubTypeMapper;
import com.gooalgene.labtest.entity.News_SubType;
import com.gooalgene.labtest.service.NewsSubTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsSubTypeServiceImpl implements NewsSubTypeService {
    @Autowired
    NewsSubTypeMapper newsSubTypeMapper;

    @Override
    public void insertType(News_SubType news_subType) {
        newsSubTypeMapper.insertSubType(news_subType);
    }
}
