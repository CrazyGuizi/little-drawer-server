package com.lidegui.littledrawer.service;

import com.lidegui.littledrawer.bean.File;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 10:53 2019/4/16
 */
public interface FileService {

    public File addFile(File file);

    public int deleteFile(int fileId);

    public File updateFile(File file);

    public File updateFileMediaId(File file);

    public File getFileById(int fileId);

    public File getFileByMediaId(int mediaId);

    public String getPathByMediaId(int mediaId);

    public List<File> getAllFiles();
}
