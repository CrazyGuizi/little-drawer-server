package com.lidegui.littledrawer.service.impl;

import com.lidegui.littledrawer.bean.File;
import com.lidegui.littledrawer.dao.FileDao;
import com.lidegui.littledrawer.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: lidegui
 * @Date:Created in 10:59 2019/4/16
 */

@Service("FileService")
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao mFileDao;

    @Override
    public File addFile(File file) {
        if (mFileDao.insert(file) > 0) {
            return mFileDao.findById(file.getId());
        }
        return null;
    }

    @Override
    public int deleteFile(int fileId) {
        return mFileDao.deleteById(fileId);
    }

    @Override
    public File updateFile(File file) {
        if (mFileDao.updateFile(file) > 0) {
            return mFileDao.findById(file.getId());
        }
        return null;
    }

    @Override
    public File updateFileMediaId(File file) {
        if (mFileDao.updateFileMediaId(file) > 0) {
            return mFileDao.findById(file.getId());
        }
        return null;
    }

    @Override
    public File getFileById(int fileId) {
        return mFileDao.findById(fileId);
    }

    @Override
    public File getFileByMediaId(int mediaId) {
        return mFileDao.findFileByMediaId(mediaId);
    }

    @Override
    public String getPathByMediaId(int mediaId) {
        return mFileDao.findPathByMediaId(mediaId);
    }

    @Override
    public List<File> getAllFiles() {
        return mFileDao.findAll();
    }
}
