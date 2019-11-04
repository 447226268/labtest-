package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.NewsTypeMapper;
import com.gooalgene.labtest.service.NewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsTypeServiceImpl implements NewsTypeService {
    @Autowired
    NewsTypeMapper newsTypeMapper;

    @Override
    public void insertType(String nt_name) {
        newsTypeMapper.insert(nt_name);
    }
}
