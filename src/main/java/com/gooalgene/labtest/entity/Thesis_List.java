package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Thesis_List {
    private Integer tl_id;
    private String tl_title;
    private String tl_journal;
    private String tl_content;
    private String tl_writer;
    private String tl_year;
    private Date tl_date;
    private Integer tl_state;
    private String tl_url;
    private String tl_realtime;

    public Thesis_List(Integer tl_id, String tl_title, String tl_journal, String tl_content, String tl_writer, String tl_year, Date tl_date, Integer tl_state, String tl_url, String tl_realtime) {
        this.tl_id = tl_id;
        this.tl_title = tl_title;
        this.tl_journal = tl_journal;
        this.tl_content = tl_content;
        this.tl_writer = tl_writer;
        this.tl_year = tl_year;
        this.tl_date = tl_date;
        this.tl_state = tl_state;
        this.tl_url = tl_url;
        this.tl_realtime = tl_realtime;
    }

    public Thesis_List() {
    }

    @Override
    public String toString() {
        return "Thesis_List{" +
                "tl_id=" + tl_id +
                ", tl_title='" + tl_title + '\'' +
                ", tl_journal='" + tl_journal + '\'' +
                ", tl_content='" + tl_content + '\'' +
                ", tl_writer='" + tl_writer + '\'' +
                ", tl_year='" + tl_year + '\'' +
                ", tl_date=" + tl_date +
                ", tl_state=" + tl_state +
                ", tl_url='" + tl_url + '\'' +
                ", tl_realtime='" + tl_realtime + '\'' +
                '}';
    }
}
