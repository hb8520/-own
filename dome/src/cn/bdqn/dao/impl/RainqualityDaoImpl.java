package cn.bdqn.dao.impl;

import cn.bdqn.dao.BaseDao;
import cn.bdqn.dao.RainqualityDao;
import cn.bdqn.entity.Rainquality;

import java.util.ArrayList;
import java.util.List;

public class RainqualityDaoImpl extends BaseDao implements RainqualityDao {
    /**
     * 查询所有数据
     * @return
     */
    @Override
    public List<Rainquality> selectRainquality() {
        String sql="SELECT `id`,`districtName`,`monitorTime`,`rain`,`monitoringStation`,`monitoringAddress` FROM `rainquality`";
        Object[] params= null ;
        List<Rainquality> list=null;
        try {
            rs = this.executeQuery(sql);
            if(rs!=null) {
                list=new ArrayList<Rainquality>();
                while(rs.next()) {
                    Rainquality rain=new Rainquality();
                    rain.setId(rs.getInt("id"));
                    rain.setDistrictName(rs.getString("districtName"));
                    rain.setMonitorTime(rs.getString("monitorTime"));
                    rain.setRain(rs.getInt("rain"));
                    rain.setMonitoringStation(rs.getString("monitoringStation"));
                    rain.setMonitoringAddress(rs.getString("monitoringAddress"));
                    list.add(rain);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return list;
    }

    /**
     * 修改信息
     * @param rainquality
     * @return
     */
    @Override
    public int update(Rainquality rainquality) {
        String sql="update rainquality set districtName=?,monitorTime=?,rain=?,monitoringStation=?,monitoringAddress=? where id=?";
        Object[] params= {rainquality.getDistrictName(),rainquality.getMonitorTime(),rainquality.getRain(),rainquality.getMonitoringStation(),rainquality.getMonitoringAddress(),rainquality.getId()} ;
        int result=-1;
        try {
            result = this.executeUpdate(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return result;
    }

    /**
     * 删除信息
     * @param id
     * @return
     */
    @Override
    public int del(Integer id) {
        String sql="delete from rainquality where id=?";
        Object[] params= {id} ;
        int result=-1;
        try {
            result = this.executeUpdate(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return result;
    }

    /**
     * 新增信息
     * @param rainquality
     * @return
     */
    @Override
    public int insert(Rainquality rainquality) {
        String sql="insert into rainquality(id,districtName,monitorTime,rain,monitoringStation,monitoringAddress)values(default,?,?,?,?,?)";
        Object[] params= {rainquality.getDistrictName(),rainquality.getMonitorTime(),rainquality.getRain(),rainquality.getMonitoringStation(),rainquality.getMonitoringAddress()} ;
        int result=-1;
        try {
            result = this.executeUpdate(sql,params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return result;
    }

    /**
     * 根据id获取数据
     * @param id
     * @return
     */
    @Override
    public Rainquality selectById(Integer id) {
        String sql="select id,districtName,monitorTime,rain,monitoringStation,monitoringAddress from rainquality where id=?";
        Object[] params= {id} ;
        Rainquality rain=null;
        try {
            rs = this.executeQuery(sql,params);
            if(rs!=null) {
                if(rs.next()) {
                    rain=new Rainquality();
                    rain.setId(rs.getInt("id"));
                    rain.setDistrictName(rs.getString("districtName"));
                    rain.setMonitorTime(rs.getString("monitorTime"));
                    rain.setRain(rs.getInt("rain"));
                    rain.setMonitoringStation(rs.getString("monitoringStation"));
                    rain.setMonitoringAddress(rs.getString("monitoringAddress"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.closeAll();
        }
        return rain;
    }
}
