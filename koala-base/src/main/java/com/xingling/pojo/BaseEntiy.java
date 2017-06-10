package com.xingling.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
public class BaseEntiy {


	/**
	 * 主键 id
	 */
	@Id
	@GeneratedValue(generator = "UUID")
	private String id;
	/**
	 * 创建者id
	 */
	@Column(name = "creator")
	private Long creator;
	/**
	 * 修改者id
	 */
	@Column(name = "updater")
	private Long updater;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	/**
	 * 更改时间
	 */
	@Column(name = "update_time")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	/**
	 *删除标识
	 */
	@Column(name = "del")
	private Integer del;
}
