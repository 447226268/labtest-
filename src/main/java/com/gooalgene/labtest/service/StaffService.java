package com.gooalgene.labtest.service;

import com.gooalgene.labtest.dto.Staff;
import com.gooalgene.labtest.entity.Staff_list;

import java.util.List;

public interface StaffService {

    Staff Sel(int id);

    List<Staff> findAll();

    String Del(int id);

    String Insert(Staff staff);

    void Update(Staff_list staff);

    List<String> getAllType();
}
