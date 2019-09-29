package cn.bdqn.dao;

import cn.bdqn.entity.Rainquality;

import java.util.List;

public interface RainqualityDao {

    /**
     * 查询所有数据
     * @return
     */
    List<Rainquality> selectRainquality();

    /**
     * 修改所有数据
     * @param rainquality
     * @return
     */
    int update(Rainquality rainquality);

    /**
     * 删除数据
     * @param id
     * @return
     */
    int del(Integer id);

    /**
     * 新增数据
     * @return
     */
    int insert(Rainquality rainquality);

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    Rainquality selectById(Integer id);
}
