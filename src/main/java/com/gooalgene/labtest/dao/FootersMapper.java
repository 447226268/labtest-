package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.Homepage_footer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootersMapper {
    void deleteById(Integer hf_id);

    void insertFooter(Homepage_footer homepage_footer);

    List<Homepage_footer> findFooters();

}
