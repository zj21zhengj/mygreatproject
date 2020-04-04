package com.tencent.mashibing.step040;

public class SubjectEntity {

    @Column(name="ID")
    private Integer id;

    @Column(name="SUB_NAME")
    private String subName;

    @Column(name="SUB_CODE")
    private String subCode;

    @Column(name="TYPE")
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
