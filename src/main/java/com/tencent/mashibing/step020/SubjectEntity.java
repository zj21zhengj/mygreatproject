package com.tencent.mashibing.step020;

public class SubjectEntity {

    @Column(name="ID")
    private int id;

    @Column(name="SUB_NAME")
    private String subName;

    @Column(name="SUB_CODE")
    private String subCode;

    @Column(name="TYPE")
    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
