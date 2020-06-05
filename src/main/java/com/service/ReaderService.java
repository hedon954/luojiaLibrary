package com.service;

import com.bean.Msg;
import com.bean.Reader;
import com.bean.ReaderExample;
import com.dao.ReaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * 读者服务器
 * @author Hedon Wang
 * @create 2020-05-30 14:57
 */

@Service
public class ReaderService {

    @Autowired
    ReaderMapper readerMapper;




    /**
     * 读取所有的Reader
     * @return
     */
    public List<Reader> getAllReaders() {
        ReaderExample readerExample = new ReaderExample();
        readerExample.setOrderByClause("reader_id");
        List<Reader> readers = readerMapper.selectByExampleWithManager(readerExample);
        return readers;

    }

    /**
     * 新建读者
     * @param reader
     */
    public void createReader(Reader reader) {
        readerMapper.insertSelective(reader);
    }

    /**
     * 根据ID删除读者
     * @param id
     */
    public void deleteReaderById(Integer id) {
        readerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据ID获取读者信息
     * @param id
     * @return
     */
    public Reader getReaderById(int id) {
        Reader reader = readerMapper.selectByPrimaryKeyWithManager(id);
        return reader;
    }

    /**
     * 更新读者
     * @param reader
     */
    public void updateReader(Reader reader) {
        readerMapper.updateByPrimaryKeySelective(reader);
    }

    /**
     * 根据读者条形码查询读者是否存在
     * @param readerBarCode
     * @return
     */
    public List<Reader> checkUserExists(String readerBarCode) {
        ReaderExample readerExample = new ReaderExample();
        ReaderExample.Criteria criteria = readerExample.createCriteria();
        criteria.andReaderBarcodeEqualTo(readerBarCode);
        List<Reader> readers = readerMapper.selectByExampleWithManager(readerExample);
        return readers;
    }


    /**
     * 查询所有读者：带排名
     * @return
     */
    public List<Reader> getAllReadersWithRank() {
        ReaderExample readerExample = new ReaderExample();
        readerExample.setOrderByClause("borrowed_book_count DESC,reader_id");
        List<Reader> readers = readerMapper.selectByExampleWithManager(readerExample);
        return readers;
    }
}
