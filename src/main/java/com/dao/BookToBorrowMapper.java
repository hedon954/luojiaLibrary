package com.dao;

import com.bean.BookToBorrow;
import com.bean.BookToBorrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookToBorrowMapper {
    long countByExample(BookToBorrowExample example);

    int deleteByExample(BookToBorrowExample example);

    int deleteByPrimaryKey(Integer bookToborrowId);

    int insert(BookToBorrow record);

    int insertSelective(BookToBorrow record);

    List<BookToBorrow> selectByExample(BookToBorrowExample example);

    BookToBorrow selectByPrimaryKey(Integer bookToborrowId);

    //新增2个查询方法：基础+book
    List<BookToBorrow> selectByExampleWithBook(BookToBorrowExample example);

    BookToBorrow selectByPrimaryKeyWithBook(Integer bookToborrowId);

    int updateByExampleSelective(@Param("record") BookToBorrow record, @Param("example") BookToBorrowExample example);

    int updateByExample(@Param("record") BookToBorrow record, @Param("example") BookToBorrowExample example);

    int updateByPrimaryKeySelective(BookToBorrow record);

    int updateByPrimaryKey(BookToBorrow record);
}