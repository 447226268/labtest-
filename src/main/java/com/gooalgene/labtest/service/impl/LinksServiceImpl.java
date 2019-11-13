package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.LinksMapper;
import com.gooalgene.labtest.entity.Homepage_links;
import com.gooalgene.labtest.service.LinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinksServiceImpl implements LinksService {
    @Autowired
    private LinksMapper linksMapper;

    @Override
    public List<Homepage_links> findAll() {
        return linksMapper.findLinks();
    }

    @Override
    public void deleteLink(Integer hl_id) {
        linksMapper.deleteById(hl_id);
    }

    @Override
    public void insertLink(Homepage_links homepage_links) {
        linksMapper.insertLink(homepage_links);
    }
}
