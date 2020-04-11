package com.brichev.models;

import javax.persistence.*;

@Entity
public class BankIssuer{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String url;

    private String targetName;

    public String getTargetName() {
        return targetName;
    }

    public String getUrl() {
        return url;
    }

    public Integer getId() {
        return id;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}