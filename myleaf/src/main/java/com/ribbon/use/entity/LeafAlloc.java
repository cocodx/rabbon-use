package com.ribbon.use.entity;

import java.util.Date;

public class LeafAlloc {

    /**
     * 表名称
     */
    private String key;

    /**最大id**/
    private Long maxId;

    /**步长**/
    private Integer step;

    /**标记**/
    private String description;

    /**更新时间**/
    private String updateTime;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
