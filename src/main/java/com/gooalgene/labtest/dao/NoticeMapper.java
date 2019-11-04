package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.News_List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {

    News_List findById(@Param("nl_id") Integer nl_id);

    List<News_List> findNotice();

    void deleteNotices(@Param("nl_id") Integer noticeIds);

    void addNotice(News_List notice);

    void updateNotice(News_List news_list);

}



