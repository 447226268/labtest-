package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.Lab_intro;
import com.gooalgene.labtest.response.BaseResponse;

import java.util.List;


public interface LabService {

    BaseResponse<List<Lab_intro>> findAll();

    BaseResponse<Lab_intro> getLabIntro();

    BaseResponse<String> updateLabIntro(Lab_intro lab_intro);

    BaseResponse<String> deleteLabIntro();

}
