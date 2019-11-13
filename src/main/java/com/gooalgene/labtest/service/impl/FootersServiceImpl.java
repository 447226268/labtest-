package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.FootersMapper;
import com.gooalgene.labtest.entity.Homepage_footer;
import com.gooalgene.labtest.service.FootersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootersServiceImpl implements FootersService {
    @Autowired
    private FootersMapper footersMapper;

    @Override
    public List<Homepage_footer> findAll() {
        return footersMapper.findFooters();
    }


    @Override
    public void deleteFooter(Integer hf_id) {
        footersMapper.deleteById(hf_id);
    }

    @Override
    public void insertFooter(Homepage_footer homepage_footer) {
        footersMapper.insertFooter(homepage_footer);
    }
}
