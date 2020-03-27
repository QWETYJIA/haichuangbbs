package com.kaohe.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kaohe.beans.Yonghu;
import com.zuopin.beans.Tiezi;
import com.zuopin.dao.jdbcutil;

public class yonghuService {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	public List<Yonghu> find(){
		// 获取数据库连接
				Connection conn = jdbcutil.getConnection();
		// 创建List
		List<Yonghu> list = new ArrayList<Yonghu>();
		
		try {
			// 获取PreparedStatement
			Statement stmt = conn.createStatement();
			String sql = "select * from yonghu ";
			ResultSet rs = stmt.executeQuery(sql);
			// 光标向后移动，并判断是否有效
			while(rs.next()){
				// 实例化Tiezi
				Yonghu yh = new Yonghu();
				// 对id属性赋值
				yh.setId(rs.getInt("id"));
				// 对name属性赋值
				yh.setName(rs.getString("name"));
				// 对num属性赋值
				yh.setPassword(rs.getString("password"));
				yh.setGl(rs.getString("gl"));
				// 将Product添加到List集合中
				list.add(yh);
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

	public void delete(int id) {
		Connection conn = jdbcutil.getConnection();
		try {
			// 添加学生信息的SQL语句
			String sql = "delete from yonghu where id = ?";
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


	public List<Yonghu> findGl(String gl){
		// 获取数据库连接
				
		// 创建List
		List<Yonghu> list = new ArrayList<Yonghu>();
				
		try {
			// 获取PreparedStatement
			Connection conn = jdbcutil.getConnection();
			

		
			String sql = "select * from yonghu where gl=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, gl);
			rs=ps.executeQuery();
			// 光标向后移动，并判断是否有效
			while(rs.next()){
				// 实例化Tiezi
               Yonghu yh = new Yonghu();
				// 对id属性赋值
				yh.setId(rs.getInt("id"));
				// 对name属性赋值
				yh.setName(rs.getString("name"));
				// 对num属性赋值
				yh.setPassword(rs.getString("password"));
				yh.setGl(rs.getString("gl"));
				// 将Product添加到List集合中
				list.add(yh);
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
	
	public  Yonghu findid(int id){
		// 获取数据库连接
		
				Connection conn = jdbcutil.getConnection();
		// 创建List
		//List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			
			String sql="select* from yonghu where id=?";
			ps =conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				Yonghu yh = new Yonghu();
				// 对id属性赋值
				yh.setId(rs.getInt("id"));
				// 对name属性赋值
				yh.setName(rs.getString("name"));
				// 对num属性赋值
				yh.setPassword(rs.getString("password"));
				yh.setGl(rs.getString("gl"));
				// 将Product添加到List集合中
			
				return yh;

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

	public void xiugaiyonghu(String gl, int id) {
		Connection conn = jdbcutil.getConnection();
		try {
			String sql = "update yonghu set gl=? where id = ?";
			// 获取PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// 通过循环添加批处
				// 对SQL语句中的第1个参数赋值
				ps.setString(1, gl);
				ps.setInt(2, id);				
			
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
	
	
public Yonghu checkUsername(String username) {
		
		Yonghu yonghu=null;
		try {
			Connection conn = jdbcutil.getConnection();
			String sql="select* from yonghu where username=? ";
			ps =conn.prepareStatement(sql);
			ps.setString(1, username);
			
			rs=ps.executeQuery();
			if(rs.next()) {
				yonghu =new Yonghu();
				yonghu.setId(rs.getInt("id"));
				yonghu.setUsername(rs.getString("username"));
				yonghu.setName(rs.getString("name"));
				yonghu.setPassword(rs.getString("password"));	}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				//stmt.close();
				rs.close();
				ps.close();
				
				//conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return yonghu;
	}


}
