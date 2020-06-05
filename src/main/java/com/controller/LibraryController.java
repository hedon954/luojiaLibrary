package com.controller;

import com.bean.Library;
import com.bean.Msg;
import com.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Library 的控制类
 * @author Hedon Wang
 * @create 2020-05-29 10:22
 */
@Controller
public class LibraryController {

    @Autowired
    LibraryService libraryService;


    /**
     * 修改图书馆信息
     * @param library
     * @param request
     * @return
     */
    @RequestMapping(value = "/library/{libraryName}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateLibraryInfo(Library library, HttpServletRequest request){
        System.out.println("请求体中的 libraryInfo："+request.getParameter("libraryInfo"));
        System.out.println("更新的图书馆信息："+library);
        libraryService.updateLibrary(library);
        return Msg.success();
    }


    /**
     * 获取图书馆的信息
     * @param libraryName
     * @return
     */
    @RequestMapping(value = "/library",method = RequestMethod.GET)
    @ResponseBody
    public Msg getLibraryById(@RequestParam("libraryName") String libraryName){
        Library library = libraryService.getLibraryById(libraryName);
        return Msg.success().add("lib",library);
    }
}
