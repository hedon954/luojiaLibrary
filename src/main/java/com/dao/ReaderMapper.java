package com.dao;

import com.bean.Reader;
import com.bean.ReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReaderMapper {
    long countByExample(ReaderExample example);

    int deleteByExample(ReaderExample example);

    int deleteByPrimaryKey(Integer readerId);

    int insert(Reader record);

    int insertSelective(Reader record);

    List<Reader> selectByExample(ReaderExample example);

    Reader selectByPrimaryKey(Integer readerId);

    int updateByExampleSelective(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByExample(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);

    //新增两个方法：带上管理员
    List<Reader> selectByExampleWithManager(ReaderExample example);
    Reader selectByPrimaryKeyWithManager(Integer readerId);
}