package com.gooalgene.labtest.dao;


import com.gooalgene.labtest.entity.Home_Figure;
import com.gooalgene.labtest.entity.News_List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UploadPictureMapper {
    void insertFigure(Home_Figure home_figure);

    List<Home_Figure> findFigures();

}