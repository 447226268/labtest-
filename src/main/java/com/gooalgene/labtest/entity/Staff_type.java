package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Staff_type {
    private Integer st_id;
    private String st_name;

    public Staff_type() {

    }

    public Staff_type(Integer id, String name) {
        st_id = id;
        st_name = name;
    }
}
