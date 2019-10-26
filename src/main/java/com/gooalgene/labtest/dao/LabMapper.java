package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.Lab_intro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabMapper {

    List<Lab_intro> findAll();

    Lab_intro getLabIntro();

    void updateLabIntro(Lab_intro lab_intro);

    void deleteLabIntro();

}
