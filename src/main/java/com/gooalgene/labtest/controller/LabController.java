package com.gooalgene.labtest.controller;

import com.gooalgene.labtest.entity.Lab_intro;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.impl.LabServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lab")
public class LabController {
    @Autowired
    private LabServiceImpl labService;

    @GetMapping("/getAllLabIntro")
    public BaseResponse<List<Lab_intro>> getAllLabIntro() {
        return labService.findAll();
    }

    @GetMapping("/getLabIntro")
    public BaseResponse<Lab_intro> getLabIntro() {
        return labService.getLabIntro();
    }

    @PostMapping("/updateLabIntro")
    public BaseResponse<String> updateLabIntro(@RequestBody Lab_intro lab_intro) {
        return labService.updateLabIntro(lab_intro);
    }

    @DeleteMapping("/deleteLabIntro")
    public BaseResponse<String> deleteLabIntro() {
        return labService.deleteLabIntro();
    }
}
