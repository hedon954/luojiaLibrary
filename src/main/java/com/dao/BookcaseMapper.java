package com.dao;

import com.bean.Bookcase;
import com.bean.BookcaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookcaseMapper {
    long countByExample(BookcaseExample example);

    int deleteByExample(BookcaseExample example);

    int deleteByPrimaryKey(Integer bookcaseId);

    int insert(Bookcase record);

    int insertSelective(Bookcase record);

    List<Bookcase> selectByExample(BookcaseExample example);

    Bookcase selectByPrimaryKey(Integer bookcaseId);

    int updateByExampleSelective(@Param("record") Bookcase record, @Param("example") BookcaseExample example);

    int updateByExample(@Param("record") Bookcase record, @Param("example") BookcaseExample example);

    int updateByPrimaryKeySelective(Bookcase record);

    int updateByPrimaryKey(Bookcase record);
}