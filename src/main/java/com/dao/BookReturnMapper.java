package com.dao;

import com.bean.BookReturn;
import com.bean.BookReturnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookReturnMapper {
    long countByExample(BookReturnExample example);

    int deleteByExample(BookReturnExample example);

    int deleteByPrimaryKey(Integer bookReturnId);

    int insert(BookReturn record);

    int insertSelective(BookReturn record);

    List<BookReturn> selectByExample(BookReturnExample example);

    BookReturn selectByPrimaryKey(Integer bookReturnId);

    int updateByExampleSelective(@Param("record") BookReturn record, @Param("example") BookReturnExample example);

    int updateByExample(@Param("record") BookReturn record, @Param("example") BookReturnExample example);

    int updateByPrimaryKeySelective(BookReturn record);

    int updateByPrimaryKey(BookReturn record);
}