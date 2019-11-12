package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.Home_Figure;
import org.springframework.stereotype.Repository;

@Repository
public interface FigureMapper {
    void insertNewsFigure(Home_Figure home_figure);

    void insertAcaFigure(Home_Figure home_figure);

    Home_Figure findFigures(Integer hn_id);

}
