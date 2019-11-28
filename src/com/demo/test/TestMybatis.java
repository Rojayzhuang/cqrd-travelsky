package com.demo.test;

import com.demo.database.SessionFactory;
import com.demo.database.data.TDemoFile;
import com.demo.mapper.ITDemoFileMapper;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Rojay
 * @version 1.0.0
 * @createTime 2019年10月17日  14:42:56
 */
public class TestMybatis {

    public static void main(String[] args) {
        SqlSession session = SessionFactory.getSession();
        /*//插入
        TDemoFile tdemoFilefile = new TDemoFile("bg.jpg","abc123456ffee",
                "image/jpeg", 10240, new Timestamp(System.currentTimeMillis()));
        session.insert("fileMapper.insert", tdemoFilefile);
        //提交事务
        session.commit();*/


        //修改
        TDemoFile tdemoFile = session.selectOne("fileMapper.getById",3);
        tdemoFile.setFileName("背景.png");
        session.update("fileMapper.update",tdemoFile);
        session.commit();

        //查询（不使用接口时）
        List<TDemoFile> list = session.selectList("fileMapper.selectAll");
        for (TDemoFile file : list) {
            System.out.println(file.getFileId() + "," + file.getFileName() + "," + file.getFileType() + ","
                    + file.getFileSize() + "," + file.getOperTime());
        }

        //查询，使用接口的方法
        /*try {
            ITDemoFileMapper fileMapper = session.getMapper(ITDemoFileMapper.class);
            List<TDemoFile> list = fileMapper.selectAll();
            for (TDemoFile file : list) {
                System.out.println(file.getFileId() + "," + file.getFileName() + "," + file.getFileType() + ","
                        + file.getFileSize() + "," + file.getOperTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


}
