package com.controller;

import com.bean.Manager;
import com.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Manager 的控制层
 * @author Hedon Wang
 * @create 2020-05-26 11:56
 */

@Controller
public class ManagerController {

    @Autowired
    ManagerService managerService;

    /**
     * 根据id删除管理员
     * @param id
     * @return
     */
    @RequestMapping(value = "/manager/{managerId}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteManagerById(@PathVariable("managerId")String id){
        int intId = Integer.parseInt(id);
        managerService.deleteManagerById(intId);
        return Msg.success();
    }


    /**
     * 分页查询管理员信息
     * @param pn
     * @return
     */
    @RequestMapping(value = "/managers",method = RequestMethod.GET)
    @ResponseBody
    public Msg getManagerWithJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn){
        //从 pn 页才是查，每页 10 个
        PageHelper.startPage(pn,10);
        //从数据库读取 Managers
        List<Manager> managerList = managerService.getAllManagers();
        PageInfo pageInfo = new PageInfo(managerList,5);
        return Msg.success().add("pageInfo",pageInfo);
    }



    /**
     * 注册Manager
     * @param manager
     * @return
     */
    @RequestMapping(value = "/manager",method = RequestMethod.POST)
    @ResponseBody
    public Msg createManager(Manager manager){
        managerService.createManager(manager);
        return Msg.success();
    }

    /**
     * 修改用户密码
     * @param managerName
     * @param newPwd2rd
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changeManagerPwd",method = RequestMethod.POST)
    public Msg changeManagerPwd(@RequestParam(value = "managerName")String managerName,
                                @RequestParam(value = "newPwd2rd")String newPwd2rd){
        Manager manager = new Manager();
        manager.setManagerName(managerName);
        manager.setManagerPwd(newPwd2rd);
        boolean b = managerService.changeManagerPwd(manager);
        if(!b){
            return Msg.success();
        }else{
            return Msg.fail().add("changePwd_msg","更改密码错误");
        }
    }



    /**
     * 检查密码是否错误
     * @param managerPwd
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkManagerPwd",method = RequestMethod.GET)
    public Msg checkManagerPwd(@RequestParam(value = "managerName") String managerName,
                               @RequestParam(value = "managerPwd") String managerPwd,
                               HttpSession session){
        boolean b = managerService.checkManagerPwd(managerName,managerPwd);
        if(b){  //验证通过
            //将用户信息放入session
            session.setAttribute("loginName",managerName);
            return Msg.success();
        }else{
            return Msg.fail().add("va_pwd_msg","密码错误，请重新输入！");
        }
    }



    /**
     * 检查用户名是否存在
     * @param managerName
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkManagerNameExists",method = RequestMethod.POST)
    public Msg checkManagerNameExists(@RequestParam("managerName") String managerName){
        //1. 检查用户名是否存在
        boolean b = managerService.checkManagerNameExists(managerName);
        if(b){
            return Msg.success().add("va_register_name_msg","用户名已存在！请更换用户名！");
        }else{
            return Msg.fail().add("va_login_name_msg","用户名不存在！请注册！").add("va_register_name_msg","用户名可用！");
        }
    }

}
