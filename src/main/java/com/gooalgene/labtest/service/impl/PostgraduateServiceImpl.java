package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.PostgraduateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostgraduateServiceImpl {
    @Autowired
    PostgraduateMapper postgraduateMapper;
}
