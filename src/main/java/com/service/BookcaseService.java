package com.service;

import com.bean.Bookcase;
import com.dao.BookcaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 书架的服务层
 * @author Hedon Wang
 * @create 2020-06-01 17:09
 */

@Service
public class BookcaseService {

    @Autowired
    BookcaseMapper bookcaseMapper;

    /**
     * 查询所有的书架信息
     * @return
     */
    public List<Bookcase> getAllBookcases() {
        List<Bookcase> bookcaseList = bookcaseMapper.selectByExample(null);
        return bookcaseList;
    }
}
