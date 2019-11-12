package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.Home_Figure;

public interface HomeFigureService {
    void insertAcaFigure(Home_Figure home_figure);

    void insertNewsFigure(Home_Figure home_figure);

    Home_Figure findFigures(Integer hn_id);
}
