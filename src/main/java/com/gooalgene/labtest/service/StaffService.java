package com.gooalgene.labtest.service;

import com.gooalgene.labtest.entity.Staff_list;

public interface StaffService {
    Staff_list Sel(int id);

    String findAll();
}
