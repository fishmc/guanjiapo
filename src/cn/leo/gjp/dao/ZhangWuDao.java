package cn.leo.gjp.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.leo.gjp.domain.ZhangWu;
import cn.leo.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	public List<ZhangWu> selectAll(){
		
		try {
			String sql = "SELECT * FROM gjp_zhangwu";
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("≤È—Ø ß∞‹");
			throw new RuntimeException(e);
		}
	}
	
	public List<ZhangWu> select(String beginDate,String endDate){
		
		try {
			String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
			Object[] params = {beginDate,endDate};
			return qr.query(sql, params, new BeanListHandler<ZhangWu>(ZhangWu.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("≤È—Ø ß∞‹");
			throw new RuntimeException(e);
		}
	}
	
	
	public void add(ZhangWu zhangwu){
		
		try {
			String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES(?,?,?,?,?)";
			Object[] params = {zhangwu.getFlname(),zhangwu.getMoney(),zhangwu.getZhangwu(),zhangwu.getCreatetime(),zhangwu.getDescription()};
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ÃÌº” ß∞‹");
			throw new RuntimeException(e);
		}
	}
	
	public void edit(ZhangWu zhangwu) {
		
		try {
			String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? where zwid =?";
			Object[] params = {zhangwu.getFlname(),zhangwu.getMoney(),zhangwu.getZhangwu(),zhangwu.getCreatetime(),zhangwu.getDescription(),zhangwu.getZwid()};
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("±‡º≠ ß∞‹");
			throw new RuntimeException(e);
		}
	}
	
	public void del(int zwid) {
		
		
		try {
			String sql_del = "DELETE FROM gjp_zhangwu where zwid =?";
			String sql_query = "SELECT * FROM gjp_zhangwu where zwid =?";
			List<ZhangWu> list =  qr.query(sql_query, new BeanListHandler<ZhangWu>(ZhangWu.class),zwid);
			
			if(list.size()!=0){
				qr.update(sql_del, zwid);
			}else{
				System.out.println("∏√id≤ª¥Ê‘⁄");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("…æ≥˝ ß∞‹");
			throw new RuntimeException(e);
		}
		
	}
	

}
