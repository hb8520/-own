package cn.bdqn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/rainq?useUnicode=true&characterEncoding=utf-8";
	private static String user = "root";
	private static String password = "199702";
	
	protected Connection conn=null;
	protected PreparedStatement pstmt=null;
	protected ResultSet rs=null;
	
	/**
	 * 获得连接对象
	 */
	public void getConnection() {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭资源
	 */
	public void closeAll() {
		try {
			if(null!=rs) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(null!=pstmt) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(null!=conn) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 增删改
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql,Object[] params) {
		getConnection();
		int result=-1;
		try {
			pstmt=conn.prepareStatement(sql);
			//为占位符赋值
			if(params!=null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			//调用方法
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll();
		}
		return result;
	}
	
	/**
	 * 查询
	 * @param sql
	 * @param params
	 * @return
	 */
	public ResultSet executeQuery(String sql,Object... params) {
		getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			//为占位符赋值
			if(params!=null) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			//调用方法
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
