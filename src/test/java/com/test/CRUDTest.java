package com.test;

import com.bean.Manager;
import com.bean.Reader;
import com.dao.ManagerMapper;
import com.dao.ReaderMapper;
import com.utils.CreateData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Hedon Wang
 * @create 2020-05-29 19:32
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CRUDTest {


    @Autowired
    SqlSessionTemplate sqlSessionTemplate;


    /**
     * 批量生产Manager
     */
    @Test
    public void testCreateManger(){
        ManagerMapper managerMapper =  sqlSessionTemplate.getMapper(ManagerMapper.class);
        for (int i = 0; i < 1000; i++) {
            String name = UUID.randomUUID().toString().substring(0,6);
            managerMapper.insertSelective(new Manager(null,name,name));
        }
    }

    /**
     * 批量生产Reader
     */
    @Test
    public void testCreateReader(){
        ReaderMapper readerMapper = sqlSessionTemplate.getMapper(ReaderMapper.class);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 100; i++) {
            //1. 随机生成名字
            String name = CreateData.createName();
            //2. 随机生成性别
            String gender = CreateData.createGender();
            //3. 随机生成条形码
            String barCode = CreateData.createBarCode();
            //4. 随机生成职业
            String job = CreateData.createJob();
            //5. 随机生成生日
            String birth = CreateData.createBirth();
            Date birthday = null;
            try{
                birthday = simpleDateFormat.parse(birth);
            }catch (Exception e){
                e.printStackTrace();
            }
            //6. 随机生成证件类型
            String documentType = CreateData.createDocumentType(job);
            //7. 随机生成证件号码
            String documentNumber = CreateData.createDocumentNumber(documentType);
            //8. 随机生成邮箱
            String email = CreateData.createEmail(barCode);
            //9. 随机生成登记日期
            String registerDate = simpleDateFormat.format(new Date());
            Date regDate = null;
            try{
                regDate = simpleDateFormat.parse(registerDate);
            }catch (Exception e){
                e.printStackTrace();
            }
            //10. 随机生成操作者ID
            int opId = CreateData.createOperatorId();
            readerMapper.insertSelective(new Reader(null,name,gender,barCode,job,birthday,documentType,documentNumber,email,regDate,null,null,opId));
        }
    }
}
