package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hedon Wang
 * @create 2020-05-26 17:15
 */

@Controller
public class PageJumpController {

    @RequestMapping(path = "/bookPush")
    public String toBookReturn(){
        return "bookPush";
    }

    @RequestMapping(path = "/bookRenewAndReturn")
    public String toBookRenew(){
        return "bookRenewAndReturn";
    }

    @RequestMapping(path = "/bookBorrow")
    public String toBookBorrow(){
        return "bookBorrow";
    }

    @RequestMapping("/bookType")
    public String toBookType(){
        return "bookType";
    }


    @RequestMapping("/bookInfo")
    public String toBookInfo(){
        return "bookInfo";
    }


    @RequestMapping(path = "/adminSettings")
    public String toAdminSettings(){
        return "adminSettings";
    }

    @RequestMapping(path = "/readerService")
    public String toReaderService(){
        return "readerService";
    }

    @RequestMapping(path = "/readerRank")
    public String toReaderRank(){
        return "readerRank";
    }

    @RequestMapping(path = "/bookRank")
    public String toBookRank(){
        return "bookRank";
    }

    @RequestMapping(path = "/homepage")
    public String toHomePage(){
        return "homepage";
    }

    @RequestMapping(path = "/changePwd")
    public String toChangePwdPage(){
        return "changePwd";
    }

    @RequestMapping(path = "/error")
    public String toErrorPage(){
        return "/WEB-INF/error.jsp";
    }

    @RequestMapping(value = "/login")
    public String toIndexPage(){
        return "redirect:index.jsp";
    }
}
