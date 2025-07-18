package com.codegym.controlauction.model;

public class ProductType {
    private Integer cid;
    private String name;

    public ProductType() {}

    public ProductType(Integer cid, String name) {
        this.cid = cid;
        this.name = name;
    }

    public Integer getCid() { return cid; }
    public void setCid(Integer cid) { this.cid = cid; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
