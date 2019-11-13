package com.gooalgene.labtest.service;

import com.gooalgene.labtest.dto.Staff;
import com.gooalgene.labtest.entity.Staff_type;

import java.util.List;

public interface StaffService {

    Staff Sel(int id);

    List<Staff> findAll();

    String Del(int id);

    String Insert(Staff staff);

    String Update(Staff staff);

    List<Staff_type> getAllType();

    String setAllType(List<String> type);

    String deleteType(String name);

    Staff getStaffInfo(int id);

    String updateStaffInfo(Staff staff);

    String addType(String name);

    String updateType(List<String> list);

}
