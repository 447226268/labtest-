package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.entity.Home_Figure;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.HomeFigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/figure")
public class FigureController {
    @Autowired
    private HomeFigureService homeFigureService;

    @GetMapping("/insertAcaFigure")
    public BaseResponse<String> insertAcaFigure(@RequestParam Home_Figure home_figure) {
        BaseResponse<String> response = new BaseResponse<>();
        homeFigureService.insertAcaFigure(home_figure);
        response.setResult("插入成功");
        return response;
    }

    @GetMapping("/insertNewsFigure")
    public BaseResponse<String> insertNewsFigure(@RequestParam Home_Figure home_figure) {
        BaseResponse<String> response = new BaseResponse<>();
        homeFigureService.insertAcaFigure(home_figure);
        response.setResult("插入成功");
        return response;
    }

    @GetMapping("/getFigure")
    public BaseResponse<Home_Figure> getNewsFigure(@RequestParam("hn_id") int id) {
        BaseResponse<Home_Figure> response = new BaseResponse<>();
        response.setResult(homeFigureService.findFigures(id));
        return response;
    }

}
