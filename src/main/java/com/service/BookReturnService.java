package com.service;

import com.bean.BookReturn;
import com.dao.BookReturnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 图书归还服务类
 * @author Hedon Wang
 * @create 2020-06-03 11:41
 */

@Service
public class BookReturnService {

    @Autowired
    BookReturnMapper bookReturnMapper;

    /**
     * 保存图书归还数据
     * @param bookReturn
     */
    public void saveBookReturn(BookReturn bookReturn) {
        bookReturnMapper.insertSelective(bookReturn);
    }
}
