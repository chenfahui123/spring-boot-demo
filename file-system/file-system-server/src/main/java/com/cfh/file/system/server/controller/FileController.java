package com.cfh.file.system.server.controller;

import com.cfh.demo.common.lang.bo.RespBase;
import com.cfh.file.system.server.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 16:29
 * @description:
 */
@RequestMapping("/file")
@RestController
public class FileController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public RespBase<Void> upload(MultipartFile file) {
		if(file != null) {
			System.out.println("----------------------");
			String fileName = file.getOriginalFilename();
			File tempFile = null;
			try {
				tempFile = File.createTempFile(fileName, "");
				fileService.upload(tempFile, fileName);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(null != tempFile)
				tempFile.delete();
			}
		}
		System.out.println("+++++++++++++++++++++");
		return new RespBase<>(0);
	}
}
