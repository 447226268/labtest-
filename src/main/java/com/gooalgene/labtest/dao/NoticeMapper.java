package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.News_List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {

    /*新增、编辑和删除操作公告；*/

    List<News_List> findNotice();

    void deleteNotices(String[] noticeIds);

    void addNotice(News_List notice);

    void updateState(@Param("notice.state") int state, @Param("notice.Ids") String[] noticeIds);

    void updateNotice(News_List notice);

}
