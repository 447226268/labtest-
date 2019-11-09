package com.gooalgene.labtest.dao;


import com.gooalgene.labtest.entity.News_List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UploadPictureMapper {
    List<News_List> findHeadline();


    List<News_List> findAcademic();
}
