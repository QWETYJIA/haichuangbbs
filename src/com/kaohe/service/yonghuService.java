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
	}

	public void delete(int id) {
		Connection conn = jdbcutil.getConnection();
		try {
			// ���ѧ����Ϣ��SQL���
			String sql = "delete from yonghu where id = ?";
			// ��ȡPreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// ͨ��ѭ���������
				// ��SQL����еĵ�1��������ֵ
				ps.setInt(1, id);
			
			// ִ��������
			ps.executeUpdate();
			// �ر�PreparedStatement
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				// �ر�Connection
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


	public List<Yonghu> findGl(String gl){
		// ��ȡ���ݿ�����
				
		// ����List
		List<Yonghu> list = new ArrayList<Yonghu>();
				
		try {
			// ��ȡPreparedStatement
			Connection conn = jdbcutil.getConnection();
			

		
			String sql = "select * from yonghu where gl=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, gl);
			rs=ps.executeQuery();
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
			ps.close();
			// �ر�Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public  Yonghu findid(int id){
		// ��ȡ���ݿ�����
		
				Connection conn = jdbcutil.getConnection();
		// ����List
		//List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			
			String sql="select* from yonghu where id=?";
			ps =conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				Yonghu yh = new Yonghu();
				// ��id���Ը�ֵ
				yh.setId(rs.getInt("id"));
				// ��name���Ը�ֵ
				yh.setName(rs.getString("name"));
				// ��num���Ը�ֵ
				yh.setPassword(rs.getString("password"));
				yh.setGl(rs.getString("gl"));
				// ��Product��ӵ�List������
			
				return yh;

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
		return null;
			}

	public void xiugaiyonghu(String gl, int id) {
		Connection conn = jdbcutil.getConnection();
		try {
			String sql = "update yonghu set gl=? where id = ?";
			// ��ȡPreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// ͨ��ѭ���������
				// ��SQL����еĵ�1��������ֵ
				ps.setString(1, gl);
				ps.setInt(2, id);				
			
			// ִ��������
			ps.executeUpdate();
			// �ر�PreparedStatement
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				// �ر�Connection
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
