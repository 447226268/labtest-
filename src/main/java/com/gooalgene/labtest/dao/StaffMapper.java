package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.Staff_info;
import com.gooalgene.labtest.entity.Staff_list;
import com.gooalgene.labtest.entity.Staff_type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffMapper {

//  staff_list表

    List<Staff_list> findAll();

    Staff_list Sel(int id);

    void Del(int id);

    void Insert(Staff_list staff_list);

    void Update(Staff_list staff_list);

//  staff_type表

    String SearchType(int id);

    List<Staff_type> getAllType();

    List<String> getAllTypeName();

    Integer TypeToId(String st_name);

    void deleteType(String name);

    void addType(Staff_type staff_type);

    Integer countType(String name);
//  staff_info表

    Staff_info getStaffInfo(int uid);

    void insertStaffInfo(Staff_info staff_info);

    void deleteStaffInfo(int uid);

    Integer getNewestId();

    void updateStaffInfo(Staff_info staff_info);
}



