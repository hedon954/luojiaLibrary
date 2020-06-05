package com.test;

import com.utils.CreateData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Hedon Wang
 * @create 2020-05-30 11:08
 */


public class CreateDataTest {


    //1. 测试随机生成姓名
    @Test
    public void testCreateName(){
        for (int i = 0; i < 100; i++) {
            System.out.println(CreateData.createName());
        }
    }

    //2. 测试生成性别
    @Test
    public void testCreateGender(){
        for (int i = 0; i < 100; i++) {
            CreateData.createGender();
        }
    }

    //3. 测试生成生日
    @Test
    public void testCreateBirth(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for (int i = 0; i < 100; i++) {
            try{
                date = simpleDateFormat.parse(CreateData.createBirth());
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(simpleDateFormat.format(date));
        }
    }

}
