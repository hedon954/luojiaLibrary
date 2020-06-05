package com.controller;

import com.bean.Msg;
import com.bean.Reader;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 读者控制器
 * @author Hedon Wang
 * @create 2020-05-30 14:56
 */

@Controller
public class ReaderController {

    @Autowired
    ReaderService readerService;


    /**
     * 根据读者条形码查询读者是否存在
     * @param readerBarCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkReader/{readerBarCode}",method = RequestMethod.GET)
    public Msg checkUserExists(@PathVariable("readerBarCode")String readerBarCode){
        List<Reader> readers = readerService.checkUserExists(readerBarCode);
        if(readers.size() == 0){
            return Msg.fail().add("checkReader_msg","读者不存在！");
        }else{
            return Msg.success().add("reader",readers);
        }
    }

    /**
     * 更新读者
     * @param reader
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/reader/{readerId}",method = RequestMethod.PUT)
    public Msg updateReader(Reader reader){
        readerService.updateReader(reader);
        return Msg.success();
    }


    /**
     * 根据ID获取读者信息
     * @param idStr
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/reader/{readerId}",method = RequestMethod.GET)
    public Msg getReaderById(@PathVariable("readerId") String idStr){
        int id = Integer.parseInt(idStr);
        Reader reader = readerService.getReaderById(id);
        return Msg.success().add("reader",reader);
    }

    /**
     * 根据ID删除读者
     * @param idStr
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/reader/{readerId}",method = RequestMethod.DELETE)
    public Msg deleteReaderById(@PathVariable("readerId")String idStr){
        Integer id = Integer.parseInt(idStr);
        readerService.deleteReaderById(id);
        return Msg.success();
    }

    /**
     * 新建读者
     * @param reader
     * @return
     */
    @RequestMapping(value = "/reader",method = RequestMethod.POST)
    @ResponseBody
    public Msg createReader(Reader reader){
        readerService.createReader(reader);
        return Msg.success();
    }


    /**
     * 分页查询读者信息
     * @param pn
     * @return
     */
    @RequestMapping(value = "/readers",method = RequestMethod.GET)
    @ResponseBody
    public Msg getReaderWithJson(@RequestParam("pn") Integer pn){
        //从 pn 页开始查，查 10 个
        PageHelper.startPage(pn,10);
        //从数据库读取 Reader
        List<Reader> readerList = readerService.getAllReaders();
        //封装到 pageInfo 中
        PageInfo pageInfo = new PageInfo(readerList,5);
        //返回给前端
        return Msg.success().add("pageInfo",pageInfo);
    }

    /**
     * 分页查询读者信息:带排名
     * @param pn
     * @return
     */
    @RequestMapping(value = "/readersWithRank",method = RequestMethod.GET)
    @ResponseBody
    public Msg getReaderWithRank(@RequestParam("pn") Integer pn){
        //从 pn 页开始查，查 10 个
        PageHelper.startPage(pn,10);
        //从数据库读取 Reader
        List<Reader> readerList = readerService.getAllReadersWithRank();
        //封装到 pageInfo 中
        PageInfo pageInfo = new PageInfo(readerList,5);
        //返回给前端
        return Msg.success().add("pageInfo",pageInfo);
    }
}
