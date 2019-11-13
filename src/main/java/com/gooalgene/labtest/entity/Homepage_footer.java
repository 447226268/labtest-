package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Homepage_footer {
    private Integer hf_id;
    private String hf_text;



    public Homepage_footer() {
    }

    public Homepage_footer(Integer hf_id, String hf_text) {
        this.hf_id = hf_id;
        this.hf_text = hf_text;
    }

    @Override
    public String toString() {
        return "Homepage_footer{" +
                "hf_id=" + hf_id +
                ", hf_text='" + hf_text + '\'' +
                '}';
    }
}
