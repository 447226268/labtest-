package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.NewsSubTypeMapper;
import com.gooalgene.labtest.dao.NewsTypeMapper;
import com.gooalgene.labtest.dao.NoticeMapper;
import com.gooalgene.labtest.entity.News_List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements com.gooalgene.labtest.service.NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    private NewsTypeMapper newsTypeMapper;
    @Autowired
    private NewsSubTypeMapper newsSubTypeMapper;
    @Override
    public List<News_List> findNotice() {
        List<News_List> list = noticeMapper.findNotice();
        for (News_List n : list) {
            n.setNl_nl_type_name(
                    newsTypeMapper.findById(n.getNl_type_id()).getNt_name());
            n.setNl_nl_subType_name(newsSubTypeMapper.findById(n.getNl_subType_id()).getNs_name());
        }
        return list;
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
