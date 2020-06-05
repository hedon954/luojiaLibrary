package com.controller;

import com.bean.Book;
import com.bean.BookToBorrow;
import com.bean.BookType;
import com.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BookService;
import com.service.BookToBorrowService;
import com.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 图书借阅的控制类
 * @author Hedon Wang
 * @create 2020-06-02 23:04
 */

@Controller
public class BookToBorrowController {

    @Autowired
    BookToBorrowService bookToBorrowService;

    @Autowired
    BookTypeService bookTypeService;

    @Autowired
    BookService bookService;


    /**
     * 续借图书
     * @param toBorrowId
     * @param bookId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/renewBook",method = RequestMethod.POST)
    public Msg renewBook(@RequestParam("toBorrowId")Integer toBorrowId,
                         @RequestParam("bookId")Integer bookId){
        //1. 将图书应还时间延后一个周期
        BookToBorrow bookToBorrow = bookToBorrowService.getBorrowedBooksById(toBorrowId);
        Date returnTime = getReturnTime(bookId);                      //还书时间为当前时间+该类型图书可借天数
        bookToBorrow.setReturnedDate(returnTime);
        bookToBorrowService.updateBookReturnTime(bookToBorrow);
        //2. 将图书可续借次数 -1
        bookToBorrowService.reduceBookCanBorrowTimes(bookId);

        return Msg.success();
    }

    //计算还书时间
    public Date getReturnTime(Integer bookId){
        Book book = bookService.getBookById(bookId);                            //获取图书实体，从而得到该图书的图书类型ID
        BookType bookType = bookTypeService.getBookTypeById(book.getTypeId());  //通过图书类型ID获取图书相应类型的可借天数
        Date returnTime = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(returnTime);
        calendar.add(calendar.DATE,bookType.getToborrowDays());
        returnTime = calendar.getTime();
        return returnTime;
    }

    /**
     * 查阅某个读者的借阅信息
     * @param pn
     * @param readerId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/readerBorrowedBooks",method = RequestMethod.GET)
    public Msg getBorrowedBooksByReaderId(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                                          @RequestParam(value = "readerId")Integer readerId){
        //1.开启分页查询
        PageHelper.startPage(pn,10);
        //2. 从数据库拉取数据
        List<BookToBorrow> bookToBorrowList = bookToBorrowService.getBorrowedBooksByReaderId(readerId);
        //3. 封装到 PageInfo 中
        PageInfo pageInfo = new PageInfo(bookToBorrowList,5);
        //4. 传给前端
        return Msg.success().add("pageInfo",pageInfo);
    }


    /**
     * 借阅图书
     * @param readerId
     * @param bookId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/borrowBook",method = RequestMethod.POST)
    public Msg borrowBook(@RequestParam("readerId")Integer readerId,
                          @RequestParam("bookId")Integer bookId){
        //3-1 创建借阅数据
        BookToBorrow bookToBorrow = new BookToBorrow();
        bookToBorrow.setReaderId(readerId);                                     //readerId
        bookToBorrow.setBookId(bookId);                                         //bookId
        bookToBorrow.setBorrowedDate(new Date());                               //借书时间

        Date returnTime = getReturnTime(bookId);                                //还书时间为当前时间+该类型图书可借天数
        bookToBorrow.setReturnedDate(returnTime);                               //还书时间
        bookToBorrowService.borrowBook(bookToBorrow);

        //3-2 将书籍可借次数-1
        bookToBorrowService.reduceBookCanBorrowTimes(bookId);
        //3-3 将书籍被借次数+1
        //3-4 将书籍的"所在书架"改为"已出借"
        bookToBorrowService.AddBookBorrowedTimes(bookId);

        //3-5 将读者可借书籍数量-1
        //3-6 将读者总借书籍数量+1
        bookToBorrowService.reduceReaderCanBorrowCountAndAddReaderBorrowedTimes(readerId);

        return Msg.success();
    }
}
