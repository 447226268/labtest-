package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class News_List {
    private Integer nl_id;
    private String nl_title;
    private String nl_content;
    private String nl_graph;
    private Integer nl_type_id;
    private String nl_nl_type_name;
    private Integer nl_subType_id;
    private String nl_nl_subType_name;
    private Integer nl_state;
    private String nl_url;

    public News_List(Integer nl_id, String nl_title, String nl_content, String nl_graph, Integer nl_type_id, String nl_nl_type_name, Integer nl_subType_id, String nl_nl_subType_name, Integer nl_state, String nl_url) {
        this.nl_id = nl_id;
        this.nl_title = nl_title;
        this.nl_content = nl_content;
        this.nl_graph = nl_graph;
        this.nl_type_id = nl_type_id;
        this.nl_nl_type_name = nl_nl_type_name;
        this.nl_subType_id = nl_subType_id;
        this.nl_nl_subType_name = nl_nl_subType_name;
        this.nl_state = nl_state;
        this.nl_url = nl_url;
    }

    public News_List() {
    }

    public News_List(Integer nl_id, String nl_title, String nl_content, String nl_graph, Integer nl_type_id, Integer nl_subType_id, Integer nl_state, String nl_url) {
        this.nl_id = nl_id;
        this.nl_title = nl_title;
        this.nl_content = nl_content;
        this.nl_graph = nl_graph;
        this.nl_type_id = nl_type_id;
        this.nl_subType_id = nl_subType_id;
        this.nl_state = nl_state;
        this.nl_url = nl_url;
    }

    @Override
    public String toString() {
        return "News_List{" +
                "nl_id=" + nl_id +
                ", nl_title='" + nl_title + '\'' +
                ", nl_content='" + nl_content + '\'' +
                ", nl_graph='" + nl_graph + '\'' +
                ", nl_type_id=" + nl_type_id +
                ", nl_nl_type_name='" + nl_nl_type_name + '\'' +
                ", nl_subType_id=" + nl_subType_id +
                ", nl_nl_subType_name='" + nl_nl_subType_name + '\'' +
                ", nl_state=" + nl_state +
                ", nl_url='" + nl_url + '\'' +
                '}';
    }
}
