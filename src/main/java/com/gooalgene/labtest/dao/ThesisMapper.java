package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.Thesis_List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThesisMapper {

    Thesis_List findById(@Param("nl_id") Integer nl_id);

    List<Thesis_List> findThesis();

    void deleteThesis(@Param("nl_id") Integer noticeIds);

    void addThesis(Thesis_List thesis_list);

    void updateState(Thesis_List thesis_list);

    void updateThesis(Thesis_List thesis_list);

}



