package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.Home_Figure;
import com.gooalgene.labtest.entity.News_List;

import java.util.List;

public interface UploadPictureService {

        void insertFigure(Home_Figure home_figure);

        List<Home_Figure> findFigures();

}
