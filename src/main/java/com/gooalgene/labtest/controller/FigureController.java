package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.entity.Home_Figure;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.HomeFigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/figure")
public class FigureController {
    @Autowired
    private HomeFigureService homeFigureService;

    @GetMapping("/insertFigure")
    public BaseResponse<String> insertAcaFigure(@RequestParam("list") List<Home_Figure> home_figure) {
        BaseResponse<String> response = new BaseResponse<>();
//        homeFigureService.insertFigure(home_figure.get(0));
//        homeFigureService.insertFigure(home_figure.get(1));
        for (int i = 0; i < home_figure.size(); i++) {
            homeFigureService.insertFigure(home_figure.get(i));
        }
        response.setResult("插入成功");
        return response;
    }
    @GetMapping("/getFigure")
    public BaseResponse<List<Home_Figure>> getNewsFigure() {
        BaseResponse<List<Home_Figure>> response = new BaseResponse<>();
        response.setResult(homeFigureService.findFigures());
        return response;
    }

}
