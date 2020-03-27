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
		// ��ȡ���ݿ�����
				Connection conn = jdbcutil.getConnection();
		// ����List
		List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			// ��ȡPreparedStatement
			Statement stmt = conn.createStatement();
			String sql = "select * from tiezi ";
			ResultSet rs = stmt.executeQuery(sql);
			// �������ƶ������ж��Ƿ���Ч
			while(rs.next()){
				// ʵ����Tiezi
				Tiezi tz = new Tiezi();
				// ��id���Ը�ֵ
				tz.setId(rs.getInt("id"));
				// ��name���Ը�ֵ
				tz.setName(rs.getString("name"));
				// ��num���Ը�ֵ
				tz.setNeirong(rs.getString("neirong"));
				tz.setTitle(rs.getString("title"));
				tz.setTime(rs.getString("time"));
				// ��Product��ӵ�List������
				list.add(tz);
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
		// ���ݿ�����
		Connection conn = jdbcutil.getConnection();
		try {
			// ���ѧ����Ϣ��SQL���
			String sql = "delete from tiezi where id = ?";
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
	
	
	
	public  void xiugaitiezi(Tiezi tiezi,int id) {
		// ���ݿ�����
		Connection conn = jdbcutil.getConnection();
		try {
			String sql = "update tiezi set title=?,neirong=?,time=? where id = ?";
			// ��ȡPreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			// ͨ��ѭ���������
				// ��SQL����еĵ�1��������ֵ
				ps.setString(1, tiezi.getTitle());
				ps.setString(2, tiezi.getNeirong());
				ps.setString(3, tiezi.getTime());
				ps.setInt(4, id);				
			
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
	
	public  Tiezi findid(int id){
		// ��ȡ���ݿ�����
		
				Connection conn = jdbcutil.getConnection();
		// ����List
		//List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			
			String sql="select* from tiezi where id=?";
			ps =conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				Tiezi tz =new Tiezi();
				// ��id���Ը�ֵ
				tz.setId(rs.getInt("id"));
				// ��name���Ը�ֵ
				tz.setName(rs.getString("name"));
				// ��num���Ը�ֵ
				tz.setNeirong(rs.getString("neirong"));
				tz.setTitle(rs.getString("title"));
				tz.setTime(rs.getString("time"));	
				return tz;

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

	public List<Tiezi> findP(int page){
		// ��ȡ���ݿ�����
				Connection conn = jdbcutil.getConnection();
		// ����List
		List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			// ��ȡPreparedStatement
			//Statement stmt = conn.createStatement();
			String sql = "select * from tiezi order by id desc limit ? ,? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, (page - 1) * Tiezi.PAGE_SIZE);
			// ��SQL����еĵ�2��������ֵ
			ps.setInt(2, Tiezi.PAGE_SIZE);
			// �������ƶ������ж��Ƿ���Ч
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				// ʵ����Tiezi
				Tiezi tz = new Tiezi();
				// ��id���Ը�ֵ
				tz.setId(rs.getInt("id"));
				// ��name���Ը�ֵ
				tz.setName(rs.getString("name"));
				// ��num���Ը�ֵ
				tz.setNeirong(rs.getString("neirong"));
				tz.setTitle(rs.getString("title"));
				tz.setTime(rs.getString("time"));
				// ��Product��ӵ�List������
				list.add(tz);
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
	
	public int findCount(){
		// �ܼ�¼��
		int count = 0;
		// ��ȡ���ݿ�����
		Connection conn = jdbcutil.getConnection();
		// ��ѯ�ܼ�¼��SQL���
		String sql = "select count(*) from tiezi";
		try {
			// ����Statement
			Statement stmt = conn.createStatement();
			// ��ѯ����ȡResultSet
			ResultSet rs = stmt.executeQuery(sql);
			// �������ƶ������ж��Ƿ���Ч
			if(rs.next()){
				// ���ܼ�¼����ֵ
				count = rs.getInt(1);
			}
			// �ر�ResultSet
			rs.close();
			// �ر�Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// �����ܼ�¼��
		return count;
	}
	

}


