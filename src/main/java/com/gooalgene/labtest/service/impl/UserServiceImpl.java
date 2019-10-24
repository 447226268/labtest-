package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.UserMapper;
import com.gooalgene.labtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

}
