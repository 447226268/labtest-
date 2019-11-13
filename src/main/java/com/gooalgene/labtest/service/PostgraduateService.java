package com.gooalgene.labtest.service;

import com.gooalgene.labtest.dto.Postgraduate;
import com.gooalgene.labtest.entity.Postgradudate_type;
import com.gooalgene.labtest.response.BaseResponse;

import java.util.List;

public interface PostgraduateService {

    BaseResponse<List<Postgraduate>> findAll();

    BaseResponse<Postgraduate> getPostgraduate(int id);

    BaseResponse<String> insertPostgraduate(Postgraduate postgraduate);

    BaseResponse<String> deletePostgraduate(int id);


    BaseResponse<List<Postgradudate_type>> getAllType();

    BaseResponse<String> addType(String name);

    BaseResponse<String> deleteType(Integer id);

}
