package com.brichev.models;


public class WebForm {
    private Integer id;
    private String bin;
    private String url;
    private String targetName;


    public WebForm() {
    }

    public WebForm(BankIssuerBin bankIssuerBin) {
        this.id = bankIssuerBin.getId();
        this.bin = bankIssuerBin.getBin();
        this.url = bankIssuerBin.getBankIssuer().getUrl();
        this.targetName = bankIssuerBin.getBankIssuer().getTargetName();
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
