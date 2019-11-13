package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.Homepage_footer;

import java.util.List;

public interface FootersService {
    List<Homepage_footer> findAll();

    void deleteFooter(Integer hf_id);

    void insertFooter(Homepage_footer homepage_footer);
}
