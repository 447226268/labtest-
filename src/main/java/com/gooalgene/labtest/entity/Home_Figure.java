package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Home_Figure {
    private Integer hn_id;
    private String hn_graph;
    private Integer hn_state;


    public Home_Figure(Integer hn_id, String hn_graph, Integer hn_type, Integer hn_state) {
        this.hn_id = hn_id;
        this.hn_graph = hn_graph;
        this.hn_state = hn_state;
    }

    public Home_Figure() {
    }

    @Override
    public String toString() {
        return "Home_Figure{" +
                "hn_id=" + hn_id +
                ", hn_graph='" + hn_graph + '\'' +
                ", hn_state=" + hn_state +
                '}';
    }
}
