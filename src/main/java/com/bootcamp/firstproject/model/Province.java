package com.bootcamp.firstproject.model;

public class Province {
    private Long provId;
    private String provName;

    public Province() {
    }
    
    public Province(Long provId, String provName) {
        this.provId = provId;
        this.provName = provName;
    }
    public Long getProvId() {
        return provId;
    }
    public void setProvId(Long provId) {
        this.provId = provId;
    }
    public String getProvName() {
        return provName;
    }
    public void setProvName(String provName) {
        this.provName = provName;
    }

    
}
