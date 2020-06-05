package com.service;

import com.bean.Library;
import com.dao.LibraryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Library 的服务类
 * @author Hedon Wang
 * @create 2020-05-29 10:23
 */

@Service
public class LibraryService {

    @Autowired
    LibraryMapper libraryMapper;

    /**
     * 获取图书馆信息
     * @param libraryName
     * @return
     */
    public Library getLibraryById(String libraryName) {
        Library library = libraryMapper.selectByPrimaryKey(libraryName);
        return library;
    }

    /**
     * 更新图书馆信息
     * @param library
     */
    public void updateLibrary(Library library) {
        libraryMapper.updateByPrimaryKeySelective(library);
    }
}
