package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Staff_list {
    private Integer sl_id;
    private String sl_name;
    private Integer sl_type_id;

    @Override
    public String toString() {
        return sl_id.toString() + "号是" + sl_name;
    }
}
