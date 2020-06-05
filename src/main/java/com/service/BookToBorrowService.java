package com.service;

import com.bean.Book;
import com.bean.BookToBorrow;
import com.bean.BookToBorrowExample;
import com.bean.Reader;
import com.dao.BookMapper;
import com.dao.BookToBorrowMapper;
import com.dao.ReaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图书借阅的服务类
 * @author Hedon Wang
 * @create 2020-06-02 23:05
 */

@Service
public class BookToBorrowService {

    @Autowired
    BookToBorrowMapper bookToBorrowMapper;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    ReaderMapper readerMapper;

    /**
     * 借书
     * @param bookToBorrow
     */
    //3-1 创建借阅数据
    public void borrowBook(BookToBorrow bookToBorrow) {
        bookToBorrowMapper.insertSelective(bookToBorrow);
    }

    //3-2 将书籍可借次数-1
    public void reduceBookCanBorrowTimes(Integer bookId) {
        Book book = bookMapper.selectByPrimaryKey(bookId);
        book.setToborrowTimes(book.getToborrowTimes()-1);
        bookMapper.updateByPrimaryKeySelective(book);
    }

    //3-3 将书籍被借次数+1
    //3-4 将书籍的"所在书架"改为"已出借"
    public void AddBookBorrowedTimes(Integer bookId){
        Book book = bookMapper.selectByPrimaryKey(bookId);
        book.setBorrowedTimes(book.getBorrowedTimes()+1);
        book.setBookCaseId(6);
        bookMapper.updateByPrimaryKeySelective(book);
    }

    //3-5 将读者可借书籍数量-1
    //3-6 将读者总借书籍数量+1
    public void reduceReaderCanBorrowCountAndAddReaderBorrowedTimes(Integer readerId) {
        Reader reader = readerMapper.selectByPrimaryKey(readerId);
        reader.setRemainingBookCount(reader.getRemainingBookCount()-1);
        reader.setBorrowedBookCount(reader.getBorrowedBookCount()+1);
        readerMapper.updateByPrimaryKeySelective(reader);
    }


    /**
     * 根据读者ID来读取该读者的借阅信息
     * @param readerId
     * @return
     */
    public List<BookToBorrow> getBorrowedBooksByReaderId(Integer readerId) {
        BookToBorrowExample bookToBorrowExample = new BookToBorrowExample();
        BookToBorrowExample.Criteria criteria = bookToBorrowExample.createCriteria();
        criteria.andReaderIdEqualTo(readerId);
        criteria.andIsReturnedEqualTo((byte)(0));  //只查出未归还的数据
        List<BookToBorrow> bookToBorrowList = bookToBorrowMapper.selectByExampleWithBook(bookToBorrowExample);
        return bookToBorrowList;
    }


    /**
     * 更新图书归还时间
     * @param bookToBorrow
     */
    public void updateBookReturnTime(BookToBorrow bookToBorrow) {
        bookToBorrowMapper.updateByPrimaryKeySelective(bookToBorrow);
    }

    /**
     * 根据ID获取数据
     * @param toBorrowId
     * @return
     */
    public BookToBorrow getBorrowedBooksById(Integer toBorrowId) {
        BookToBorrow bookToBorrow = bookToBorrowMapper.selectByPrimaryKeyWithBook(toBorrowId);
        return bookToBorrow;
    }

    /**
     * 更新图书借阅数据信息
     * @param bookToBorrow
     */
    public void updateBookToBorrow(BookToBorrow bookToBorrow) {
        bookToBorrowMapper.updateByPrimaryKeySelective(bookToBorrow);
    }
}
