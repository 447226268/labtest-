package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Homepage_footer {
    private Integer hf_id;
    private String hf_first;
    private String hf_second;

    public Homepage_footer(Integer hf_id, String hf_first, String hf_second) {
        this.hf_id = hf_id;
        this.hf_first = hf_first;
        this.hf_second = hf_second;
    }

    public Homepage_footer() {
    }

    @Override
    public String toString() {
        return "Homepage_footer{" +
                "hf_id=" + hf_id +
                ", hf_first='" + hf_first + '\'' +
                ", hf_second='" + hf_second + '\'' +
                '}';
    }
}
