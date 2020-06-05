package com.controller;

import com.bean.BookType;
import com.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

/**
 * @author Hedon Wang
 * @create 2020-05-31 16:06
 */

@Controller
public class BookTypeController {

    @Autowired
    BookTypeService bookTypeService;

    /**
     * 根据ID删除图书类型
     * @param typeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/bookType/{typeId}",method = RequestMethod.DELETE)
    public Msg deleteBookTypeById(@PathVariable("typeId")Integer typeId){
        bookTypeService.deleteBookTypeById(typeId);
        return Msg.success();
    }

    /**
     * 检查图书类型名是否存在
     * @param typeName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkBookTypeName",method = RequestMethod.POST)
    public Msg checkBookTypeName(@RequestParam("typeName") String typeName){
        boolean b = bookTypeService.checkBookTypeName(typeName);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }


    /**
     * 保存图书类型
     * @param bookType
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/bookType",method = RequestMethod.POST)
    public Msg saveBookType(BookType bookType){
        bookTypeService.saveBookType(bookType);
        return Msg.success();
    }

    /**
     * 分页查询书籍类型
     * @param pn
     * @return
     */
    @RequestMapping(value = "/bookTypes",method = RequestMethod.GET)
    @ResponseBody
    public Msg getBookTypesWithJson(@RequestParam("pn")Integer pn){
        //从 pn 页开始查，查 10 个
        PageHelper.startPage(pn,10);
        //从数据库读取数据
        List<BookType> bookTypes = bookTypeService.getAllBookTypes();
        //封装到 PageInfo 中
        PageInfo pageInfo = new PageInfo(bookTypes,5);
        //传给前端
        return Msg.success().add("pageInfo",pageInfo);
    }

    /**
     * 查询所有书架信息并显示在下拉列表中
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getBookTypes",method = RequestMethod.GET)
    public Msg getBookTypes(){
        List<BookType> allBookTypes = bookTypeService.getAllBookTypes();
        return Msg.success().add("bookTypes",allBookTypes);
    }
}
