package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lab_intro {
    private int li_id;
    private String li_overview;
    private String li_fields;
    private String li_footer_first;
    private String li_footer_second;
    private String li_create_time;


    public void update(Lab_intro lab) {
        if (li_overview == null) li_overview = lab.li_overview;
        if (li_fields == null) li_fields = lab.li_fields;
        if (li_footer_first == null) li_footer_first = lab.li_footer_first;
        if (li_footer_second == null) li_footer_second = lab.li_footer_second;
    }
}
