package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.NewsMapper;
import com.gooalgene.labtest.dao.NewsSubTypeMapper;
import com.gooalgene.labtest.dao.NewsTypeMapper;
import com.gooalgene.labtest.dao.UploadPictureMapper;
import com.gooalgene.labtest.entity.Home_Figure;
import com.gooalgene.labtest.entity.News_List;
import com.gooalgene.labtest.service.UploadPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UploadPictureImpl implements UploadPictureService {
    @Autowired
    UploadPictureMapper uploadPictureMapper;
    /*@Autowired
    private NewsTypeMapper newsTypeMapper;
    @Autowired
    private NewsSubTypeMapper newsSubTypeMapper;*/

    @Override
    public void insertFigure(Home_Figure home_figure) {
        uploadPictureMapper.insertFigure(home_figure);
    }

    @Override
    public List<Home_Figure> findFigures() {
        return uploadPictureMapper.findFigures();
    }
}

