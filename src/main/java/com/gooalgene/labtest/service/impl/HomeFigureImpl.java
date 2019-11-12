package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.FigureMapper;
import com.gooalgene.labtest.entity.Home_Figure;
import com.gooalgene.labtest.service.HomeFigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HomeFigureImpl implements HomeFigureService {
    @Autowired
    private FigureMapper figureMapper;


    @Override
    public void insertAcaFigure(Home_Figure home_figure) {
        figureMapper.insertAcaFigure(home_figure);
    }

    @Override
    public void insertNewsFigure(Home_Figure home_figure) {
        figureMapper.insertNewsFigure(home_figure);
    }

    @Override
    public Home_Figure findFigures(Integer hn_id) {

        return figureMapper.findFigures(hn_id);
    }
}
