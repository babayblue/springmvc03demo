package com.company.entity;

import java.util.Date;

public class College {
    private Integer cId;

    private String cName;

    private String cAddress;

    private Date cratetime;

    private String cPic;

    public College(Integer cId, String cName, String cAddress, Date cratetime, String cPic) {
        this.cId = cId;
        this.cName = cName;
        this.cAddress = cAddress;
        this.cratetime = cratetime;
        this.cPic = cPic;
    }

    public College() {
        super();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }

    public Date getCratetime() {
        return cratetime;
    }

    public void setCratetime(Date cratetime) {
        this.cratetime = cratetime;
    }

    public String getcPic() {
        return cPic;
    }

    public void setcPic(String cPic) {
        this.cPic = cPic == null ? null : cPic.trim();
    }
}