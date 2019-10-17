package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.Staff_list;

import java.util.List;

public interface StaffService {

    Staff_list Sel(int id);
    List<Staff_list> findAll();

    String Del(int id);

    String Insert(Staff_list staff);

    void Update(Staff_list staff);
}
