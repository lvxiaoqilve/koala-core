package com.xingling.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BaseEntiy {

    /**
     * 主键 id
     */
    protected Long id;
    /**
     * 创建者id
     */
    protected Long creator;
    /**
     * 修改者id
     */
    protected Long updater;
    /**
     * 创建时间
     */
    protected Timestamp createtime;
    /**
     * 更改时间
     */
    protected Timestamp updatetime;
    /**
     *删除标识
     */
    protected int del;
}
