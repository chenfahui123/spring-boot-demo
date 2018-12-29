package com.cfh.file.system.server.bo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 15:05
 * @description:
 */
@Data
@Entity
@Table(name = "file_info")
public class FileInfo {

	@Id
	private long id;

	@Column
	private String fileName;

	@Column
	private String filePath;

	@Column
	private String checksum;

	@Column
	private long createTime;

	@Column
	private int accessId;

}
