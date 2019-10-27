package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.entity.Thesis_List;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/thesis")
public class ThesisController {
    @Autowired
    private ThesisService thesisService;

    @GetMapping("/deleteById/{id}")
    public BaseResponse<String> DeleteThesis1(@RequestParam("id") int id) {
        BaseResponse<String> response = new BaseResponse<>();
        thesisService.deleteThesis(id);
        response.setResult("删除成功");
        return response;
    }

    @GetMapping("/deleteById")
    public BaseResponse<String> DeleteThesis(@RequestParam("id") int id) {
        BaseResponse<String> response = new BaseResponse<>();
        thesisService.deleteThesis(id);
        response.setResult("删除成功");
        return response;
    }

    @GetMapping("/findById")
    public BaseResponse<Thesis_List> GetThesis(@RequestParam("id") int id) {
        BaseResponse<Thesis_List> response = new BaseResponse<>();
        Thesis_List n = thesisService.findById(id);
        response.setResult(n);
        return response;
    }

    @GetMapping("/findById/{id}")
    public BaseResponse<Thesis_List> GetThesis2(@RequestParam("id") int id) {
        BaseResponse<Thesis_List> response = new BaseResponse<>();
        Thesis_List n = thesisService.findById(id);
        response.setResult(n);
        return response;
    }

    @GetMapping("/findAll")
    public BaseResponse<List<Thesis_List>> findAll() {
        BaseResponse<List<Thesis_List>> response = new BaseResponse<>();
        List<Thesis_List> list = thesisService.findThesis();
        response.setResult(list);
        return response;
    }

    @PostMapping("/updateThesis")
    public BaseResponse<String> update(@RequestBody Thesis_List thesis) {
        BaseResponse<String> response = new BaseResponse<>();
        thesisService.updateThesis(thesis);
        response.setResult("更新成功");
        return response;
    }

    @PostMapping("/insertThesis")
    public BaseResponse<String> Insert(@RequestBody Thesis_List thesis) {
        BaseResponse<String> response = new BaseResponse<>();
        System.out.println(thesis);
        thesisService.insertThesis(thesis);
        response.setResult("插入成功");
        return response;
    }


}
