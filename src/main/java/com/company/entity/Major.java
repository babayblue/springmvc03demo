package com.company.entity;

public class Major {
    private Integer mId;

    private String mName;

    private Integer cRedit;

    private Integer lifeyear;

    private String introduction;

    private Integer cId;

    public Major(Integer mId, String mName, Integer cRedit, Integer lifeyear, String introduction, Integer cId) {
        this.mId = mId;
        this.mName = mName;
        this.cRedit = cRedit;
        this.lifeyear = lifeyear;
        this.introduction = introduction;
        this.cId = cId;
    }

    public Major() {
        super();
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName == null ? null : mName.trim();
    }

    public Integer getcRedit() {
        return cRedit;
    }

    public void setcRedit(Integer cRedit) {
        this.cRedit = cRedit;
    }

    public Integer getLifeyear() {
        return lifeyear;
    }

    public void setLifeyear(Integer lifeyear) {
        this.lifeyear = lifeyear;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}