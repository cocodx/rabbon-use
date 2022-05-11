package com.ribbon.use.model;

import java.util.concurrent.atomic.AtomicLong;

public class StepModel {

    private AtomicLong minId;
    private AtomicLong maxId;
    private Integer step;

    public AtomicLong getMinId() {
        return minId;
    }

    public void setMinId(AtomicLong minId) {
        this.minId = minId;
    }

    public AtomicLong getMaxId() {
        return maxId;
    }

    public void setMaxId(AtomicLong maxId) {
        this.maxId = maxId;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }
}
