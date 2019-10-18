package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.Staff_info;
import com.gooalgene.labtest.entity.Staff_list;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffMapper {

    //  Staff_list表
    List<Staff_list> findAll();

    Staff_list Sel(int id);

    void Del(int id);

    void Insert(Staff_list staff);

    void Update(Staff_list staff);

    //  Staff_type表
    String SearchType(int id);

    List<String> getAllType();

    Integer TypeToId(String st_name);

    //  Staff_info表
    Staff_info getStaffInfo(int uid);

    void insertStaffInfo(Staff_info staff);

    void deleteStaffInfo(int uid);
}



