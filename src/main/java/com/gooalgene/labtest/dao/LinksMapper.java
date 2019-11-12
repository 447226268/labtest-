package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.Homepage_links;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinksMapper {
    void deleteById(Integer hl_id);

    void insertLink(Homepage_links homepage_links);

    void updateLink(Homepage_links homepage_links);

    List<Homepage_links> findLinks();

    Homepage_links findById(Integer hl_id);
}
