package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.StaffMapper;
import com.gooalgene.labtest.entity.Staff_list;
import com.gooalgene.labtest.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    public Staff_list Sel(int id) {
        return staffMapper.Sel(id);
    }

    public List<Staff_list> findAll() {
        return staffMapper.findAll();
    }

    public String Del(int id) {
        String ret = staffMapper.Del(id);
        return ret;
    }

    public String Insert(Staff_list staff) {
        staffMapper.Insert(staff);
        return "0";
    }

    public void Update(Staff_list staff) {
        staffMapper.Update(staff);
        return;
    }
}
