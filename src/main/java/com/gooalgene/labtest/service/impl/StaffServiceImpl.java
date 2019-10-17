package com.gooalgene.labtest.service.impl;

import com.gooalgene.labtest.dao.StaffMapper;
import com.gooalgene.labtest.dto.Staff;
import com.gooalgene.labtest.entity.Staff_list;
import com.gooalgene.labtest.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

    public Staff Sel(int id) {
        Staff_list staff_list = staffMapper.Sel(id);
        Staff ret = new Staff(staff_list, staffMapper.SearchType(staff_list.getSl_id()));
        return ret;
    }

    public List<Staff> findAll() {
        List<Staff_list> list = staffMapper.findAll();
        List<Staff> ret = new ArrayList<>();
        for (Staff_list staff_list : list) {
            Staff staff = new Staff(staff_list, staffMapper.SearchType(staff_list.getSl_id()));
            ret.add(staff);
        }
        return ret;
    }

    public String Del(int id) {
        staffMapper.Del(id);
        return "success!";
    }

    public String Insert(Staff staff) {
        if (staff.getId() != null) {
            staff.setId(null);
        }
        Staff_list staff_list = new Staff_list(staff, staffMapper.TypeToId(staff.getType()));
        staffMapper.Insert(staff_list);
        return "success!";
    }

    public void Update(Staff_list staff) {
        staffMapper.Update(staff);
        return;
    }

    public List<String> getAllType() {
        return staffMapper.getAllType();
    }

    public Integer TypeToId(String typename) {
        return staffMapper.TypeToId(typename);
    }
}
