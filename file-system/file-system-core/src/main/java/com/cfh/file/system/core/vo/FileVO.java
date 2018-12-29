package com.cfh.file.system.core.vo;

import lombok.Data;

/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 15:50
 * @description:
 */
@Data
public class FileInfo {
	private long id;

	private String fileName;

	private String filePath;

	private String checksum;
}
