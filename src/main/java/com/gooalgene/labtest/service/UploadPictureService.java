package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.News_List;

import java.util.List;

public interface UploadPictureService {
    List<News_List> findHeadline();

    List<News_List> findAcademic();
}
