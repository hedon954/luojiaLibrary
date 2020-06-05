package com.dao;

import com.bean.Library;
import com.bean.LibraryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LibraryMapper {
    long countByExample(LibraryExample example);

    int deleteByExample(LibraryExample example);

    int deleteByPrimaryKey(String libraryName);

    int insert(Library record);

    int insertSelective(Library record);

    List<Library> selectByExample(LibraryExample example);

    Library selectByPrimaryKey(String libraryName);

    int updateByExampleSelective(@Param("record") Library record, @Param("example") LibraryExample example);

    int updateByExample(@Param("record") Library record, @Param("example") LibraryExample example);

    int updateByPrimaryKeySelective(Library record);

    int updateByPrimaryKey(Library record);
}