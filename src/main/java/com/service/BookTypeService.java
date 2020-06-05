package com.service;

import com.bean.BookType;
import com.bean.BookTypeExample;
import com.dao.BookTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hedon Wang
 * @create 2020-05-31 16:07
 */

@Service
public class BookTypeService {

    @Autowired
    BookTypeMapper bookTypeMapper;


    /**
     * 查询所有的书籍类型数据
     * @return
     */
    public List<BookType> getAllBookTypes() {
        BookTypeExample bookTypeExample = new BookTypeExample();
        bookTypeExample.setOrderByClause("type_id");
        List<BookType> bookTypes = bookTypeMapper.selectByExample(bookTypeExample);
        return bookTypes;
    }

    /**
     * 保存图书类型信息
     * @param bookType
     */
    public void saveBookType(BookType bookType) {
        bookTypeMapper.insertSelective(bookType);
    }

    /**
     * 检查图书类型名称是否存在
     * @param typeName
     * @return
     */
    public boolean checkBookTypeName(String typeName) {
        BookTypeExample bookTypeExample = new BookTypeExample();
        BookTypeExample.Criteria criteria = bookTypeExample.createCriteria();
        criteria.andTypeNameLike(typeName);
        long l = bookTypeMapper.countByExample(bookTypeExample);
        return l == 0;

    }

    /**
     * 根据ID删除订单
     * @param typeId
     */
    public void deleteBookTypeById(Integer typeId) {
        bookTypeMapper.deleteByPrimaryKey(typeId);
    }

    /**
     * 根据ID获取图书类型
     * @param typeId
     * @return
     */
    public BookType getBookTypeById(Integer typeId) {
        BookType bookType = bookTypeMapper.selectByPrimaryKey(typeId);
        return bookType;
    }
}
