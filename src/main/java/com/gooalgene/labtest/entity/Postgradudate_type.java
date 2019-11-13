package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Postgradudate_type {
    private Integer pt_id;
    private String pt_name;

    public Postgradudate_type() {
    }

    public Postgradudate_type(Integer id, String name) {
        pt_id = id;
        pt_name = name;
    }
}
