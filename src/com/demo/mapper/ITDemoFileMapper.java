package com.demo.mapper;

import com.demo.database.data.TDemoFile;

import java.util.List;

/**
 * 数据库访问映射接口
 * @author Rojay
 * @version 1.0.0
 * @createTime 2019年10月17日  16:48:37
 */
public interface ITDemoFileMapper {
    /**
     * 查询所有数据
     * @return
     * @throws Exception
     */
    public List<TDemoFile> selectAll() throws Exception;

    /**
     * 根据id获得文件数据
     * @param id
     * @return
     * @throws Exception
     */
    public TDemoFile getById(Integer id) throws Exception;

    /**
     * 添加文件数据
     * @param tdemoFile
     * @throws Exception
     */
    public void insert(TDemoFile tdemoFile) throws Exception;

    /**
     * 修改文件数据
     * @param tdemoFile
     * @throws Exception
     */
    public void update(TDemoFile tdemoFile) throws Exception;

    /**
     * 删除文件数据（支持批量删除）
     * @param ids
     * @throws Exception
     */
    public void delete(String ids) throws Exception;

    /**
     * 删除文件数据（动态SQL，支持批量删除）
     * @param ids
     * @throws Exception
     */
    public void deleteBatch(String[] ids) throws Exception;

}
