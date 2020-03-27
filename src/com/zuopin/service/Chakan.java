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

public class Chakan {
    

	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	public List<Tiezi> find(String name){
		// 获取数据库连接
				
		// 创建List
		List<Tiezi> list = new ArrayList<Tiezi>();
				
		try {
			// 获取PreparedStatement
			Connection conn = jdbcutil.getConnection();
			

		
			String sql = "select * from tiezi where name=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
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
			ps.close();
			// 关闭Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Tiezi> findt(String title){
		// 获取数据库连接
				
		// 创建List
		List<Tiezi> list = new ArrayList<Tiezi>();
				
		try {
			// 获取PreparedStatement
			Connection conn = jdbcutil.getConnection();
			

		
			String sql = "select * from tiezi where title=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, title);
			rs=ps.executeQuery();
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
			ps.close();
			// 关闭Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Tiezi> findn(String name){
		// 获取数据库连接
				
		// 创建List
		List<Tiezi> list = new ArrayList<Tiezi>();
				
		try {
			// 获取PreparedStatement
			Connection conn = jdbcutil.getConnection();
			

		
			String sql = "select * from tiezi where name=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
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
			ps.close();
			// 关闭Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Tiezi> findP(int page,String name){
		// 获取数据库连接
				Connection conn = jdbcutil.getConnection();
		// 创建List
		List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			// 获取PreparedStatement
			//Statement stmt = conn.createStatement();
			String sql = "select * from tiezi where name=? order by time desc limit ? ,? ";
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, (page - 1) * Tiezi.PAGE_SIZE);
			// 对SQL语句中的第2个参数赋值
			ps.setInt(3, Tiezi.PAGE_SIZE);
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
	
	public int findCount(String name){
		// 总记录数
		int count = 0;
		// 获取数据库连接
		Connection conn = jdbcutil.getConnection();
		// 查询总记录数SQL语句
		
		try {
			// 创建Statement
			String sql = "select count(*) from tiezi where name=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
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
	public List<Tiezi> findT(int page,String title){
		// 获取数据库连接
				Connection conn = jdbcutil.getConnection();
		// 创建List
		List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			// 获取PreparedStatement
			//Statement stmt = conn.createStatement();
			String sql = "select * from tiezi where title=? order by time desc limit ? ,? ";
			ps =conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, (page - 1) * Tiezi.PAGE_SIZE);
			// 对SQL语句中的第2个参数赋值
			ps.setInt(3, Tiezi.PAGE_SIZE);
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
	
	public int findCountt(String title){
		// 总记录数
		int count = 0;
		// 获取数据库连接
		Connection conn = jdbcutil.getConnection();
		// 查询总记录数SQL语句
		
		try {
			// 创建Statement
			String sql = "select count(*) from tiezi where title=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
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
