package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.News_List;

import java.util.List;

public interface NoticeService {

    List<News_List> findNotice();

    void addNotice(String[] title, int[] date);

    void deleteNotices(String[] noticeIds);

    void updateNotice(String noticeId, String title, String content, int state);

    void showNotices(String[] noticeIds);

}
