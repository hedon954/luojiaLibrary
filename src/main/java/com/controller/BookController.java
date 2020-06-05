package com.controller;

import com.bean.Book;
import com.bean.Bookcase;
import com.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Book 的控制层
 * @author Hedon Wang
 * @create 2020-06-01 00:02
 */

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 根据输入信息搜索可借阅的图书
     * @param pn
     * @param searchText
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/searchBookUnBorrowed",method = RequestMethod.GET)
    public Msg searchBookUnBorrowed(@RequestParam(value = "pn",defaultValue = "1")Integer pn,
                                    @RequestParam("searchText")String searchText){
        //1. 开启分页查询
        PageHelper.startPage(pn,10);
        //2. 从数据库拉取信息
        List<Book> bookList = bookService.searchBookUnBorrowed(searchText);
        //3. 封装到 pageInfo 中
        PageInfo pageInfo = new PageInfo(bookList,5);
        //4. 传给前端
        return Msg.success().add("pageInfo",pageInfo);
    }

    /**
     * 查询未出借的书籍
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/bookUnBorrowed",method = RequestMethod.GET)
    public Msg getUnBorrowedBooks(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        //1. 开启分页查询
        PageHelper.startPage(pn,10);
        //2. 从数据库拉取信息
        List<Book> bookList = bookService.getUnBorrowedBooks();
        //3. 封装到 pageInfo 中
        PageInfo pageInfo = new PageInfo(bookList,5);
        //4. 传给前端
        return Msg.success().add("pageInfo",pageInfo);
    }



    /**
     * 根据图书类型查询书籍个数
     * @param typeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getBookCountByType",method = RequestMethod.GET)
    public Msg getBookCountByType(@RequestParam("typeId")Integer typeId){
//        Integer id = Integer.parseInt(typeId);
        long l = bookService.getBookCountByType(typeId);
        return Msg.success().add("count",l);
    }

    /**
     * 更新图书
     * @param book
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.PUT)
    public Msg updateBook(Book book){
        bookService.updateBook(book);
        return Msg.success();
    }

    /**
     * 根据ID获取图书信息
     * @param bookId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.GET)
    public Msg getBookById(@PathVariable("bookId")Integer bookId){
        Book book = bookService.getBookById(bookId);
        return Msg.success().add("book",book);
    }

    /**
     * 根据ID删除图书信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/book/{bookId}",method = RequestMethod.DELETE)
    public Msg deleteBookById(@PathVariable("bookId")Integer id){
        bookService.deleteBookById(id);
        return Msg.success();
    }


    /**
     * 保存图书
     * @param book
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public Msg saveBook(Book book){
        bookService.saveBook(book);
        return Msg.success();
    }


    /**
     * 分页查询所有的书籍信息
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public Msg getAllBooks(@RequestParam("pn")Integer pn){
        //1. 启动分页查询：从pn页开始查，查询10个
        PageHelper.startPage(pn,10);
        //2. 从数据库拉取数据
        List<Book> bookList = bookService.getAllBooks();
        //3. 封装到 PageInfo 中
        PageInfo pageInfo = new PageInfo(bookList,5);
        //4. 送到前端
        return Msg.success().add("pageInfo",pageInfo);
    }

    /**
     * 分页查询所有的书籍信息并进行排名
     * @param pn
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/booksWithRank",method = RequestMethod.GET)
    public Msg getAllBooksWithRank(@RequestParam("pn")Integer pn){
        //1. 启动分页查询：从pn页开始查，查询10个
        PageHelper.startPage(pn,10);
        //2. 从数据库拉取数据
        List<Book> bookList = bookService.getAllBooksWithRank();
        //3. 封装到 PageInfo 中
        PageInfo pageInfo = new PageInfo(bookList,5);
        //4. 送到前端
        return Msg.success().add("pageInfo",pageInfo);
    }
}
