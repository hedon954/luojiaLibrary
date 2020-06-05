package com.service;

import com.bean.Book;
import com.bean.BookExample;
import com.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Book 的服务层
 * @author Hedon Wang
 * @create 2020-06-01 00:02
 */

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    /**
     * 获取所有书籍信息
     * @return
     */
    public List<Book> getAllBooks() {
        BookExample example = new BookExample();
        example.setOrderByClause("book_id");
        List<Book> bookList = bookMapper.selectByExampleWithBookCaseAndManagerAndBookType(example);
        return bookList;
    }

    /**
     * 保存图书
     * @param book
     */
    public void saveBook(Book book) {
        bookMapper.insertSelective(book);
    }

    /**
     * 根据ID删除图书信息
     * @param id
     */
    public void deleteBookById(Integer id) {
        bookMapper.deleteByPrimaryKey(id);
    }


    /**
     * 根据ID获取图书信息
     * @param bookId
     * @return
     */
    public Book getBookById(Integer bookId) {
        return bookMapper.selectByPrimaryKeyWithBookCaseAndManagerAndBookType(bookId);
    }

    /**
     * 更新图书
     * @param book
     */
    public void updateBook(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
    }

    /**
     * 根据图书类型查询图书个数
     * @param typeId
     * @return
     */
    public long getBookCountByType(Integer typeId) {
        BookExample example = new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo(typeId);
        long l = bookMapper.countByExample(example);
        return l;
    }

    /**
     * 获取未出借的书籍
     * @return
     */
    public List<Book> getUnBorrowedBooks() {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        //可出借次数大于等于3就说明还没有出借
        criteria.andToborrowTimesGreaterThanOrEqualTo(3);
        List<Book> bookList = bookMapper.selectByExampleWithBookCaseAndManagerAndBookType(bookExample);
        return bookList;
    }

    /**
     * 根据搜索条件查询可出借的书籍
     * @param searchText
     * @return
     */
    public List<Book> searchBookUnBorrowed(String searchText) {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        //可出借次数大于等于3就说明还没有出借
        criteria.andToborrowTimesGreaterThanOrEqualTo(3);
        //加入关键字
        criteria.andBookNameLike("%"+searchText+"%");
        //查询
        List<Book> bookList = bookMapper.selectByExampleWithBookCaseAndManagerAndBookType(bookExample);
        return bookList;
    }

    /**
     * 查询所有图书，并进行排名
     * @return
     */
    public List<Book> getAllBooksWithRank() {
        BookExample bookExample = new BookExample();
        BookExample.Criteria criteria = bookExample.createCriteria();
        bookExample.setOrderByClause("borrowed_times DESC");
        List<Book> bookList = bookMapper.selectByExampleWithBookCaseAndManagerAndBookType(bookExample);
        return bookList;
    }
}
