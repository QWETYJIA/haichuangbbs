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
	// ��ȡ���ݿ�����
			Connection conn = jdbcutil.getConnection();
	// ����List
	List<Yonghu> list = new ArrayList<Yonghu>();
	
	try {
		// ��ȡPreparedStatement
		Statement stmt = conn.createStatement();
		String sql = "select * from yonghu ";
		ResultSet rs = stmt.executeQuery(sql);
		// �������ƶ������ж��Ƿ���Ч
		while(rs.next()){
			// ʵ����Tiezi
			Yonghu yh = new Yonghu();
			// ��id���Ը�ֵ
			yh.setId(rs.getInt("id"));
			// ��name���Ը�ֵ
			yh.setName(rs.getString("name"));
			// ��num���Ը�ֵ
			yh.setPassword(rs.getString("password"));
			yh.setGl(rs.getString("gl"));
			// ��Product��ӵ�List������
			list.add(yh);
		}
		// �ر�ResultSet
		rs.close();
		// �ر�PreparedStatement
		stmt.close();
		// �ر�Connection
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}}
