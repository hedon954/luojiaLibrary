package com.test;

import com.dao.ReaderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期格式转换
 * @author Hedon Wang
 * @create 2020-05-30 15:59
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DateTest {

    @Autowired
    ReaderMapper readerMapper;

    @Test
    public void testDate(){
        System.out.println(readerMapper.selectByPrimaryKeyWithManager(1));
    }

    @Test
    public void testDateFormat(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        System.out.println(simpleDateFormat.format(now));
        Date returnTime = new Date();
        returnTime.setMonth(returnTime.getMonth()+1);
        System.out.println(simpleDateFormat.format(returnTime));

    }

    @Test
    public void testCalendar(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE,30);
        date = calendar.getTime();
        System.out.println(simpleDateFormat.format(date));
    }
}
