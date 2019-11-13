package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.PostgraduateMapper;
import com.gooalgene.labtest.dto.Postgraduate;
import com.gooalgene.labtest.entity.Postgraduate_list;
import com.gooalgene.labtest.entity.Postgradudate_type;
import com.gooalgene.labtest.response.BaseResponse;
import com.gooalgene.labtest.service.PostgraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostgraduateServiceImpl implements PostgraduateService {
    @Autowired
    PostgraduateMapper postgraduateMapper;

    @Override
    public BaseResponse<List<Postgraduate>> findAll() {
        List<Postgraduate_list> list = postgraduateMapper.findAll();
        List<Postgraduate> ret_list = new ArrayList<>();
        for (Postgraduate_list postgraduate_list : list) {
            String postgraduate_type = postgraduateMapper.getType(postgraduate_list.getPl_type_id());
            ret_list.add(new Postgraduate(postgraduate_list, postgraduate_type));
        }
        return new BaseResponse<>(ret_list);
    }

    @Override
    public BaseResponse<Postgraduate> getPostgraduate(int id) {
        Postgraduate_list postgraduate_list = postgraduateMapper.getPostgraduate(id);
        String postgraduate_type = postgraduateMapper.getType(postgraduate_list.getPl_type_id());
        Postgraduate ret = new Postgraduate(postgraduate_list, postgraduate_type);
        return new BaseResponse<>(ret);
    }

    @Override
    public BaseResponse<String> insertPostgraduate(Postgraduate postgraduate) {
        Integer id = postgraduate.getId();
        if (postgraduateMapper.getPostgraduate(id) != null) {
            postgraduateMapper.updatePostgraduate(new Postgraduate_list(postgraduate));
            return new BaseResponse<>("success!");
        } else {
            postgraduateMapper.insertPostgraduate(new Postgraduate_list(postgraduate));
            return new BaseResponse<>("success!");
        }
    }

    @Override
    public BaseResponse<String> deletePostgraduate(int id) {
        postgraduateMapper.deletePostgraduate(id);
        return new BaseResponse<>("success!");
    }

    @Override
    public BaseResponse<List<Postgradudate_type>> getAllType() {
        return new BaseResponse<>(postgraduateMapper.getAlltype());
    }

    @Override
    public BaseResponse<String> addType(String type) {
        List<Postgradudate_type> list = postgraduateMapper.getAlltype();
        int count = 1;
        for (Postgradudate_type post : list) {
            if (post.getPt_name().equals(type)) return new BaseResponse<>("this type is already exist!");
            count++;
        }
        Postgradudate_type postgradudate_type = new Postgradudate_type(count, type);
        postgraduateMapper.addType(postgradudate_type);
        return new BaseResponse<>("success!");
    }

    @Override
    public BaseResponse<String> deleteType(Integer id) {
        List<Postgraduate_list> list = postgraduateMapper.findAll();
        for (Postgraduate_list post : list) {
            if (post.getPl_type_id().equals(id)) return new BaseResponse<>("delete failed!");
        }
        postgraduateMapper.deleteType(id);
        return new BaseResponse<>("success!");
    }
}
