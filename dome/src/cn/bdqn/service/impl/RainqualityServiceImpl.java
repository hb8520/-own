package cn.bdqn.service.impl;

import cn.bdqn.dao.RainqualityDao;
import cn.bdqn.dao.impl.RainqualityDaoImpl;
import cn.bdqn.entity.Rainquality;
import cn.bdqn.service.RainqualityService;

import java.util.List;

public class RainqualityServiceImpl implements RainqualityService {
    private RainqualityDao rainqualityDao=new RainqualityDaoImpl();

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<Rainquality> findRainquality() {
        return rainqualityDao.selectRainquality();
    }

    /**
     * 修改数据
     * @param rainquality
     * @return
     */
    @Override
    public boolean getUpdate(Rainquality rainquality) {
        int result = rainqualityDao.update(rainquality);
        if (result>0){
            return true;
        }
        return false;
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    @Override
    public boolean removen(Integer id) {
        int result = rainqualityDao.del(id);
        if (result>0){
            return true;
        }
        return false;
    }

    /**
     * 新增数据
     * @param rainquality
     * @return
     */
    @Override
    public boolean add(Rainquality rainquality) {
        int result = rainqualityDao.insert(rainquality);
        if (result>0){
            return true;
        }
        return false;
    }

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    @Override
    public Rainquality getById(Integer id) {

        return rainqualityDao.selectById(id);
    }
}
