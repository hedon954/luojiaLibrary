package com.bean;

public class Manager {
    private Integer managerId;

    private String managerName;

    private String managerPwd;

    public Manager() {
    }

    public Manager(Integer managerId, String managerName, String managerPwd) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerPwd = managerPwd;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerPwd() {
        return managerPwd;
    }

    public void setManagerPwd(String managerPwd) {
        this.managerPwd = managerPwd == null ? null : managerPwd.trim();
    }
}