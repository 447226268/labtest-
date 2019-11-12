package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.Homepage_links;

import java.util.List;

public interface LinksService {
    List<Homepage_links> findAll();

    Homepage_links findById(Integer hl_id);

    void updateLink(Homepage_links homepage_links);

    void deleteLink(Integer hl_id);

    void insertLink(Homepage_links homepage_links);
}
