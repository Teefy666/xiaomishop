package com.example.entity;
public class Users {
    private Integer uid;
    private String uname;
    private String upass;
    private String udepartment;
    private String realname;
    private String uimage;
    private Integer roleid;
    public Users() {
        super();
    }
    public Users(Integer uid,String uname,String upass,String udepartment,String realname,String uimage,Integer roleid) {
        super();
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.udepartment = udepartment;
        this.realname = realname;
        this.uimage = uimage;
        this.roleid = roleid;
    }
    public Integer getUid() {
        return this.uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return this.uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return this.upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getUdepartment() {
        return this.udepartment;
    }

    public void setUdepartment(String udepartment) {
        this.udepartment = udepartment;
    }

    public String getRealname() {
        return this.realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getUimage() {
        return uimage;
    }

    public void setUimage(String uimage) {
        this.uimage = uimage;
    }

    public Integer getRoleid() {
        return this.roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

}
