package edu.zhangmeng.onlinedu.bean;

import java.io.Serializable;

public class SysRoleFunction implements Serializable {
    private Integer roleId;

    private Integer functionId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }
}