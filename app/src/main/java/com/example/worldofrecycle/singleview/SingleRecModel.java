package com.example.worldofrecycle.singleview;

import java.io.Serializable;

public class SingleRecModel implements Serializable {

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public SingleRecModel() {
    }

    public SingleRecModel(boolean isChecked, String name) {
        this.isChecked = isChecked;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isChecked = false;
    private String name;
}
