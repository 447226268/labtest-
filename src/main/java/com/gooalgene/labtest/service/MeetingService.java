package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.News_List;

import java.util.List;

public interface MeetingService {
    List<News_List> findMeeting();

    News_List findById(Integer nl_id);

    void insertMeeting(News_List news_list);

    void deleteMeeting(Integer meetingIds);

    void updateMeeting(News_List news_list);
}
