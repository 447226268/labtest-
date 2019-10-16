package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.StaffMapper;
import com.gooalgene.labtest.entity.Staff_list;
import com.gooalgene.labtest.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    public Staff_list Sel(int id) {
        return staffMapper.Sel(id);
    }

    public String findAll() {
        return staffMapper.findAll().toString();
    }
}
