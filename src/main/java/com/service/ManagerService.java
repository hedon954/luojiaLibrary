package com.service;

import com.bean.Manager;
import com.bean.ManagerExample;
import com.dao.ManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hedon Wang
 * @create 2020-05-26 11:58
 */

@Service
public class ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 检查用户名是否存在
     * @param managerName
     * @return
     */
    public boolean checkManagerNameExists(String managerName) {
        ManagerExample managerExample = new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        criteria.andManagerNameEqualTo(managerName);
        long l = managerMapper.countByExample(managerExample);
        System.out.println(l);
        return l==1;
    }

    /**
     * 检查用户密码是否正确
     * @param managerName
     * @param managerPwd
     * @return
     */
    public boolean checkManagerPwd(String managerName,String managerPwd) {
        ManagerExample managerExample = new ManagerExample();
        ManagerExample.Criteria criteria = managerExample.createCriteria();
        criteria.andManagerNameEqualTo(managerName);
        criteria.andManagerPwdEqualTo(managerPwd);
        long l = managerMapper.countByExample(managerExample);
        return l==1;
    }


    /**
     * 修改用户密码
     * @param manager
     */
    public boolean changeManagerPwd(Manager manager) {
        int i = managerMapper.updatePwd(manager);
        return i == 0;
    }

    /**
     * 新增manager
     * @param manager
     */
    public void createManager(Manager manager) {
        managerMapper.insertSelective(manager);
    }


    /**
     * 读取所有的Manager
     * @return
     */
    public List<Manager> getAllManagers() {
        ManagerExample managerExample = new ManagerExample();
        managerExample.setOrderByClause("manager_id");
        List<Manager> managers = managerMapper.selectByExample(managerExample);
        return managers;
    }

    /**
     * 根据id删除manager
     * @param id
     */
    public void deleteManagerById(Integer id) {
        managerMapper.deleteByPrimaryKey(id);
    }
}
