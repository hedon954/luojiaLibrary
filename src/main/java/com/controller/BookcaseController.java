package com.controller;

import com.bean.Bookcase;
import com.bean.Msg;
import com.service.BookcaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 书架的控制层
 * @author Hedon Wang
 * @create 2020-06-01 17:09
 */

@Controller
public class BookcaseController {

    @Autowired
    BookcaseService bookcaseService;


    /**
     * 查询所有的书架信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getBookCases",method = RequestMethod.GET)
    public Msg getAllBookcases(){
        List<Bookcase> bookcaseList = bookcaseService.getAllBookcases();
        return Msg.success().add("bookcases",bookcaseList);
    }
}
