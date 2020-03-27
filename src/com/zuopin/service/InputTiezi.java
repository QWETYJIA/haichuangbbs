package com.zuopin.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zuopin.beans.Tiezi;
import com.zuopin.dao.jdbcutil;

public class InputTiezi {
 

	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	public List<Tiezi> find(){
		// 获取数据库连接
				Connection conn = jdbcutil.getConnection();
		// 创建List
		List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			// 获取PreparedStatement
			Statement stmt = conn.createStatement();
			String sql = "select * from tiezi ";
			ResultSet rs = stmt.executeQuery(sql);
			// 光标向后移动，并判断是否有效
			while(rs.next()){
				// 实例化Tiezi
				Tiezi tz = new Tiezi();
				// 对id属性赋值
				tz.setId(rs.getInt("id"));
				// 对name属性赋值
				tz.setName(rs.getString("name"));
				// 对num属性赋值
				tz.setNeirong(rs.getString("neirong"));
				tz.setTitle(rs.getString("title"));
				tz.setTime(rs.getString("time"));
				// 将Product添加到List集合中
				list.add(tz);
			}
			// 关闭ResultSet
			rs.close();
			// 关闭PreparedStatement
			stmt.close();
			// 关闭Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insertTiezi(Tiezi tiezi) {
		int row=0;
		conn =jdbcutil.getConnection();
		
		try {
			
			String sql ="insert into tiezi(title,neirong,name,time)values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, tiezi.getTitle());
			ps.setString(2, tiezi.getNeirong());
			ps.setString(3,tiezi.getName());
			ps.setString(4, tiezi.getTime());
			
			row = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}
		return row;

	}
	
	
	public void delete(int id){
		// 数据库连接
		Connection conn = jdbcutil.getConnection();
		try {
			// 添加学生信息的SQL语句
			String sql = "delete from tiezi where id = ?";
			// 获取PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// 通过循环添加批处
				// 对SQL语句中的第1个参数赋值
				ps.setInt(1, id);
			
			// 执行批处理
			ps.executeUpdate();
			// 关闭PreparedStatement
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				// 关闭Connection
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public  void xiugaitiezi(Tiezi tiezi,int id) {
		// 数据库连接
		Connection conn = jdbcutil.getConnection();
		try {
			String sql = "update tiezi set title=?,neirong=?,time=? where id = ?";
			// 获取PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// 通过循环添加批处
				// 对SQL语句中的第1个参数赋值
				ps.setString(1, tiezi.getTitle());
				ps.setString(2, tiezi.getNeirong());
				ps.setString(3, tiezi.getTime());
				ps.setInt(4, id);				
			
			// 执行批处理
			ps.executeUpdate();
			// 关闭PreparedStatement
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				// 关闭Connection
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

			}
	
	public  Tiezi findid(int id){
		// 获取数据库连接
		
				Connection conn = jdbcutil.getConnection();
		// 创建List
		//List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			
			String sql="select* from tiezi where id=?";
			ps =conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				Tiezi tz =new Tiezi();
				// 对id属性赋值
				tz.setId(rs.getInt("id"));
				// 对name属性赋值
				tz.setName(rs.getString("name"));
				// 对num属性赋值
				tz.setNeirong(rs.getString("neirong"));
				tz.setTitle(rs.getString("title"));
				tz.setTime(rs.getString("time"));	
				return tz;

			}
			// 关闭ResultSet
			rs.close();
			// 关闭PreparedStatement
			stmt.close();
			// 关闭Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
			}

	public List<Tiezi> findP(int page){
		// 获取数据库连接
				Connection conn = jdbcutil.getConnection();
		// 创建List
		List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			// 获取PreparedStatement
			//Statement stmt = conn.createStatement();
			String sql = "select * from tiezi order by id desc limit ? ,? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * Tiezi.PAGE_SIZE);
			// 对SQL语句中的第2个参数赋值
			ps.setInt(2, Tiezi.PAGE_SIZE);
			// 光标向后移动，并判断是否有效
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				// 实例化Tiezi
				Tiezi tz = new Tiezi();
				// 对id属性赋值
				tz.setId(rs.getInt("id"));
				// 对name属性赋值
				tz.setName(rs.getString("name"));
				// 对num属性赋值
				tz.setNeirong(rs.getString("neirong"));
				tz.setTitle(rs.getString("title"));
				tz.setTime(rs.getString("time"));
				// 将Product添加到List集合中
				list.add(tz);
			}
			// 关闭ResultSet
			rs.close();
			// 关闭PreparedStatement
			ps.close();
			// 关闭Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int findCount(){
		// 总记录数
		int count = 0;
		// 获取数据库连接
		Connection conn = jdbcutil.getConnection();
		// 查询总记录数SQL语句
		String sql = "select count(*) from tiezi";
		try {
			// 创建Statement
			Statement stmt = conn.createStatement();
			// 查询并获取ResultSet
			ResultSet rs = stmt.executeQuery(sql);
			// 光标向后移动，并判断是否有效
			if(rs.next()){
				// 对总记录数赋值
				count = rs.getInt(1);
			}
			// 关闭ResultSet
			rs.close();
			// 关闭Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 返回总记录数
		return count;
	}
	

}


