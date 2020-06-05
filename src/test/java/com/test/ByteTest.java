package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Byte类型的赋值测试
 * @author Hedon Wang
 * @create 2020-06-03 11:58
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ByteTest {

    @Test
    public void byteTest(){
        byte b = (byte)(1);
        System.out.println(b);
    }
}
