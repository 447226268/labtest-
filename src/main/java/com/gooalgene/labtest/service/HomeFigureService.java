package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.Home_Figure;

import java.util.List;

public interface HomeFigureService {
    void insertFigure(Home_Figure home_figure);

    List<Home_Figure> findFigures();
}
