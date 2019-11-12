package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.FigureMapper;
import com.gooalgene.labtest.entity.Home_Figure;
import com.gooalgene.labtest.service.HomeFigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HomeFigureImpl implements HomeFigureService {
    @Autowired
    private FigureMapper figureMapper;

    @Override
    public void insertFigure(Home_Figure home_figure) {
        figureMapper.insertFigure(home_figure);
    }

    @Override
    public List<Home_Figure> findFigures() {
        return figureMapper.findFigures();
    }
}
