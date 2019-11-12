package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class HeadlineNews {
    private Integer hh_id;
    private String hh_title;
    private Date hh_date;
    private String hh_graph;

    public HeadlineNews(Integer hh_id, String hh_title, Date hh_date, String hh_graph) {
        this.hh_id = hh_id;
        this.hh_title = hh_title;
        this.hh_date = hh_date;
        this.hh_graph = hh_graph;
    }

    public HeadlineNews() {
    }

    @Override
    public String toString() {
        return "HeadLineNews{" +
                "hh_id=" + hh_id +
                ", hh_title='" + hh_title + '\'' +
                ", hh_date=" + hh_date +
                ", hh_graph='" + hh_graph + '\'' +
                '}';
    }
}
