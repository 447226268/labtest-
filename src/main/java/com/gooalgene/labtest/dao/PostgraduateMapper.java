package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.Postgraduate_list;
import com.gooalgene.labtest.entity.Postgradudate_type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostgraduateMapper {
    //    postgradute_list表
    List<Postgraduate_list> findAll();

    Postgraduate_list getPostgraduate(int id);

    void insertPostgraduate(Postgraduate_list postgraduate_list);

    void updatePostgraduate(Postgraduate_list postgraduate_list);

    void deletePostgraduate(int id);

    //    postgraduate_type表
    List<Postgradudate_type> getAlltype();

    void addType(Postgradudate_type postgradudate_type);

    String getType(int id);

    void deleteType(int id);

    Integer typeToId(String name);

}
