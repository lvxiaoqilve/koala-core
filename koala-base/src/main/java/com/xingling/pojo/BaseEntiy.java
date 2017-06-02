package com.xingling.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Data
public class BaseEntiy {

    /**
     * 主键 id
     */
    @Id
    @GeneratedValue(generator = "UUID")
    protected Long id;
    /**
     * 创建者id
     */
    @Column(name = "creator")
    protected Long creator;
    /**
     * 修改者id
     */
    @Column(name = "updater")
    protected Long updater;

    /**
     * 创建时间
     */
    @Column(name = "updater")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Timestamp createtime;

    /**
     * 更改时间
     */
    @Column(name = "updater")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Timestamp updatetime;

    /**
     *删除标识
     */
    @Column(name = "del")
    protected int del;
}
