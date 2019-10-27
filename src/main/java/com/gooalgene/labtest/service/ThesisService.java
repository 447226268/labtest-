package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.Thesis_List;

import java.util.List;

public interface ThesisService {
    List<Thesis_List> findThesis();

    Thesis_List findById(Integer nl_id);

    void insertThesis(Thesis_List thesis_list);

    void deleteThesis(Integer thesisIds);

    void updateThesis(Thesis_List thesis_list);
}
