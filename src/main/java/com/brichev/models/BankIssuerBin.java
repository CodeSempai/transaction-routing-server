package com.brichev.models;

import javax.persistence.*;


@Entity
public class BankIssuerBin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String bin;

    @ManyToOne
    @JoinColumn(name = "bankIssuerId", referencedColumnName = "id")
    private BankIssuer bankIssuer;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public BankIssuer getBankIssuer() {
        return bankIssuer;
    }

    public void setBankIssuer(BankIssuer bankIssuer) {
        this.bankIssuer = bankIssuer;
    }


}
