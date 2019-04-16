package com.lidegui.littledrawer.dao;

import com.lidegui.littledrawer.bean.File;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 9:35 2019/4/16
 */
public interface FileDao {

    public int insert(File file);
    public int deleteById(int fileId);
    public int updateFile(File file);
    public int updateFileMediaId(File file);
    public File findById(int fileId);
    public File findFileByMediaId(int mediaId);
    public String findPathByMediaId(int mediaId);
    public List<File> findAll();

}
