package com.gooalgene.labtest.dao;


import com.gooalgene.labtest.entity.News_SubType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsSubTypeMapper {
    List<News_SubType> findAll();

    News_SubType findById(@Param("ns_id") Integer ns_id);
}
