package com.controller;

import com.bean.*;
import com.service.BookReturnService;
import com.service.BookService;
import com.service.BookToBorrowService;
import com.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 图书归还控制类
 * @author Hedon Wang
 * @create 2020-06-03 11:40
 */
@Controller
public class BookReturnController {

    @Autowired
    BookReturnService bookReturnService;

    @Autowired
    BookService bookService;

    @Autowired
    BookToBorrowService bookToBorrowService;

    @Autowired
    ReaderService readerService;

    /**
     * 归还图书
     * @param toBorrowId
     * @param bookId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/returnBook",method = RequestMethod.POST)
    public Msg returnBook(@RequestParam("toBorrowId")Integer toBorrowId,
                          @RequestParam("bookId")Integer bookId){

        Book book = bookService.getBookById(bookId);                                        //获取图书信息
        BookToBorrow bookToBorrow = bookToBorrowService.getBorrowedBooksById(toBorrowId);  //获取图书借阅信息
        Integer readerId = bookToBorrow.getReaderId();
        //1. 新建归还数据
        BookReturn bookReturn = new BookReturn();
        bookReturn.setBookId(bookId);                                       //图书ID
        bookReturn.setBookName(book.getBookName());                         //图书名称
        bookReturn.setToborrowDate(bookToBorrow.getBorrowedDate());         //借书时间
        bookReturn.setToreturnDate(bookToBorrow.getReturnedDate());         //应还时间
        bookReturn.setRetrunDate(new Date());                               //实际归还时间
        bookReturn.setBorrowerId(readerId);                                 //借阅者ID
        bookReturnService.saveBookReturn(bookReturn);

        //2. 将图书可续借次数更改为3
        book.setToborrowTimes(3);
        //3. 将图书所在书架更改为"未上架"
        book.setBookCaseId(1);
        bookService.updateBook(book);       //更新图书

        //4. 将读者可借书数+1
        Reader reader = readerService.getReaderById(readerId);
        reader.setRemainingBookCount(reader.getRemainingBookCount()+1);
        readerService.updateReader(reader); //更新读者


        //5. 将图书是否归还更改为1
        byte d = (byte)(1);
        bookToBorrow.setIsReturned(d);
        bookToBorrowService.updateBookToBorrow(bookToBorrow);

        return Msg.success();
    }
}
