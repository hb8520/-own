package cn.bdqn.service;

import cn.bdqn.entity.Rainquality;

import java.util.List;

public interface RainqualityService {
    /**
     * 查询所有数据
     * @return
     */
    List<Rainquality> findRainquality();

    /**
     * 修改所有数据
     * @param rainquality
     * @return
     */
    boolean getUpdate(Rainquality rainquality);

    /**
     * 删除数据
     * @param id
     * @return
     */
    boolean removen(Integer id);

    /**
     * 新增数据
     * @return
     */
    boolean add(Rainquality rainquality);

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    Rainquality getById(Integer id);
}
