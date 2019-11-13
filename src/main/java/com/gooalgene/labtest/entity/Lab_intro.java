package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Lab_intro {
    private int li_id;
    private String li_overview_title;
    private String li_overview;
    private String li_fields_title;
    private String li_fields;
    private String li_create_time;


    public void update(Lab_intro lab) {
        if (li_overview_title == null) li_overview_title = lab.li_overview_title;
        if (li_overview == null) li_overview = lab.li_overview;
        if (li_fields_title == null) li_fields_title = lab.li_fields_title;
        if (li_fields == null) li_fields = lab.li_fields;
    }
}
