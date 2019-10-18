package com.gooalgene.labtest.dao;

import com.gooalgene.labtest.entity.Staff_list;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffMapper {
    //  获取所有staff
    List<Staff_list> findAll();

    //  通过ID寻找staff
    Staff_list Sel(int id);

    //  通过ID删除staff
    void Del(int id);

    //  插入staff
    void Insert(Staff_list staff);

    //  更改staff
    void Update(Staff_list staff);

    //  通过typeid寻找对应的具体职位类型
    String SearchType(int id);

    //  获取所有职位类型
    List<String> getAllType();

    //  通过具体职位类型获取对应typeid
    Integer TypeToId(String st_name);
}



