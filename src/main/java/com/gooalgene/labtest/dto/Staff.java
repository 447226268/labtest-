package com.gooalgene.labtest.dto;


import com.gooalgene.labtest.entity.Staff_list;
import com.gooalgene.labtest.entity.Staff_type;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Staff {
    private Integer id;
    private String name;
    private String type;

    public Staff() {

    }

    public Staff(Staff_list staff_list) {
        id = staff_list.getSl_id();
        name = staff_list.getSl_name();
        type = "未知";
    }

    public Staff(Staff_list staff_list, String type) {
        id = staff_list.getSl_id();
        name = staff_list.getSl_name();
        this.type = type;
    }

    public Staff(Staff_list staff_list, Staff_type staff_type) {
        id = staff_list.getSl_id();
        name = staff_list.getSl_name();
        type = staff_type.getSt_name();
    }
}
