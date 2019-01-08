package com.zb.dto;

/**
 * Created by bzheng on 2019/1/6.
 * 商家表
 */
public class BusinessDto extends BaseDto{

    /**
     * 商家名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
