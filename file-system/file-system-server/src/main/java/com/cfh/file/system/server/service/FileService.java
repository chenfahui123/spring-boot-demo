package com.cfh.file.system.server.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.cfh.demo.common.lang.util.JsonUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 15:39
 * @description:
 */
@Slf4j
@Service
public class FileService {

//	@Resource
//	private FileRepository fileRepository;

	@Value("${cos.secretId}")
	private String secretId;

	@Value("${cos.secretKey}")
	private String secretKey;

	@Value("${cos.bucketName}")
	private String bucketName;


//	@Cacheable(value = Key.FILE_SYSTEM_CACHE_KEY_ID, key = "#id", condition = "#id != null ")
//	public FileVO getFileById(long id) {
//		FileInfo fileInfo = fileRepository.getOne(id);
//		FileVO fileVO = new FileVO();
//		fileVO.setId(fileInfo.getId());
//		fileVO.setChecksum(fileInfo.getChecksum());
//		fileVO.setFileName(fileInfo.getFileName());
//		fileVO.setFilePath(fileInfo.getFilePath());
//		return fileVO;
//	}

	public COSClient getCOSClient() {
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		ClientConfig config = new ClientConfig(new Region("ap-chongqing"));
		return new COSClient(cred, config);
	}

	public void upload(File file, String fileName) {
		System.out.println(fileName);
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file);
		PutObjectResult putObjectResult = getCOSClient().putObject(putObjectRequest);
		System.out.println(JsonUtil.toString(putObjectResult));
	}
}
