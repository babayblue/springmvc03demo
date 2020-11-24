package com.company.entity;

public class QueryMajor {
    private Integer cId;
    private String mName;
    private Integer maxCredit;
    private Integer minCredit;

    public QueryMajor(Integer cId, String mName, Integer maxCredit, Integer minCredit) {
        this.cId = cId;
        this.mName = mName;
        this.maxCredit = maxCredit;
        this.minCredit = minCredit;
    }

    public QueryMajor() {
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getMaxCredit() {
        return maxCredit;
    }

    public void setMaxCredit(Integer maxCredit) {
        this.maxCredit = maxCredit;
    }

    public Integer getMinCredit() {
        return minCredit;
    }

    public void setMinCredit(Integer minCredit) {
        this.minCredit = minCredit;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}

