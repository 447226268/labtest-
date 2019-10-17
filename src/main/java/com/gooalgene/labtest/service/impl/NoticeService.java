package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.entity.News_List;

import java.util.List;

public class NoticeService implements com.gooalgene.labtest.service.NoticeService {
    @Override
    public List<News_List> findNotice() {
        return null;
    }

    @Override
    public void addNotice(String[] title, int[] date) {

    }

    @Override
    public void deleteNotices(String[] noticeIds) {

    }

    @Override
    public void updateNotice(String noticeId, String title, String content, int state) {

    }

    @Override
    public void showNotices(String[] noticeIds) {

    }
}
