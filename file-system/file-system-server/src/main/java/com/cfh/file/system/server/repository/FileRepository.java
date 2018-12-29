package com.cfh.file.system.server.repository;

import com.cfh.file.system.server.bo.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: chenfahui
 * @date: Created in 2018/12/29 15:39
 * @description:
 */
public interface FileRepository extends JpaRepository<FileInfo, Long> {
}
