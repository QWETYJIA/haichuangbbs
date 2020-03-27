package com.kaohe.dao;

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

public class YonghuDaoImpl implements IYonghuDao {
  //lianjieshujuku
	private Connection conn;
	private Statement stmt;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public Yonghu selectYonghuLogin(String name, String password,String gl) {
		
		Yonghu yonghu=null;
		try {
			Connection conn = jdbcutil.getConnection();
			String sql="select* from yonghu where username=? and password=? and gl=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, gl);
			rs=ps.executeQuery();
			if(rs.next()) {
				yonghu =new Yonghu();
				yonghu.setId(rs.getInt("id"));
				yonghu.setUsername(rs.getString("username"));
				yonghu.setName(rs.getString("name"));
				
				yonghu.setPassword(rs.getString("password"));
				
				
			}
			
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


	public void insertYonghu(Yonghu yonghu) {
		
		
		
		try {
			Connection conn = jdbcutil.getConnection();
			String sql ="insert into yonghu(name,password,gl,username)values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, yonghu.getName());
			ps.setString(2, yonghu.getPassword());
			ps.setString(3, yonghu.getGl());
			ps.setString(4,yonghu.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
						//conn.close();
				ps.close();
			//	rs.close();
			//	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	}

	}


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
}}
