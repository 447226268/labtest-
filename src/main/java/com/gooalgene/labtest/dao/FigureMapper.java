package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.Home_Figure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FigureMapper {
    void insertFigure(Home_Figure home_figure);

    List<Home_Figure> findFigures();

}
