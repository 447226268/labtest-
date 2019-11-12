package com.gooalgene.labtest.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Homepage_links {
    private Integer hl_id;
    private String hl_text;
    private String hl_url;

    public Homepage_links(Integer hl_id, String hl_text, String hl_url) {
        this.hl_id = hl_id;
        this.hl_text = hl_text;
        this.hl_url = hl_url;
    }

    public Homepage_links() {
    }

    @Override
    public String toString() {
        return "Homepage_links{" +
                "hl_id=" + hl_id +
                ", hl_text='" + hl_text + '\'' +
                ", hl_url='" + hl_url + '\'' +
                '}';
    }
}
