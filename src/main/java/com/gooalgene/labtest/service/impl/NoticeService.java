package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.NoticeMapper;
import com.gooalgene.labtest.entity.News_List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService implements com.gooalgene.labtest.service.NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Override
    public List<News_List> findNotice() {
        return noticeMapper.findNotice();
    }

    @Override
    public void addNotice(String[] title, int[] date) {
        /*News_List notice = new News_List();
        notice.setNl_id();
        notice.setNl_title(title);
        notice.setNl_content(content);
        notice.setN*/



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
