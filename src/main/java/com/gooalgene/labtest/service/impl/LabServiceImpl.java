package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.LabMapper;
import com.gooalgene.labtest.entity.Lab_intro;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabServiceImpl implements LabService {
    @Autowired
    private LabMapper labMapper;

    @Override
    public BaseResponse<List<Lab_intro>> findAll() {
        return new BaseResponse<>(labMapper.findAll());
    }

    @Override
    public BaseResponse<Lab_intro> getLabIntro() {
        return new BaseResponse<>(labMapper.getLabIntro());
    }

    @Override
    public BaseResponse<String> updateLabIntro(Lab_intro lab_intro) {
        Lab_intro old = labMapper.getLabIntro();
        lab_intro.update(old);
        labMapper.updateLabIntro(lab_intro);
        return new BaseResponse<>("success!");
    }

    @Override
    public BaseResponse<String> deleteLabIntro() {
        labMapper.deleteLabIntro();
        return new BaseResponse<>("success!");
    }
}
