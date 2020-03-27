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
		// ��ȡ���ݿ�����
				
		// ����List
		List<Tiezi> list = new ArrayList<Tiezi>();
				
		try {
			// ��ȡPreparedStatement
			Connection conn = jdbcutil.getConnection();
			

		
			String sql = "select * from tiezi where name=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
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
			ps.close();
			// �ر�Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Tiezi> findt(String title){
		// ��ȡ���ݿ�����
				
		// ����List
		List<Tiezi> list = new ArrayList<Tiezi>();
				
		try {
			// ��ȡPreparedStatement
			Connection conn = jdbcutil.getConnection();
			

		
			String sql = "select * from tiezi where title=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, title);
			rs=ps.executeQuery();
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
			ps.close();
			// �ر�Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Tiezi> findn(String name){
		// ��ȡ���ݿ�����
				
		// ����List
		List<Tiezi> list = new ArrayList<Tiezi>();
				
		try {
			// ��ȡPreparedStatement
			Connection conn = jdbcutil.getConnection();
			

		
			String sql = "select * from tiezi where name=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			rs=ps.executeQuery();
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
			ps.close();
			// �ر�Connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Tiezi> findP(int page,String name){
		// ��ȡ���ݿ�����
				Connection conn = jdbcutil.getConnection();
		// ����List
		List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			// ��ȡPreparedStatement
			//Statement stmt = conn.createStatement();
			String sql = "select * from tiezi where name=? order by time desc limit ? ,? ";
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, (page - 1) * Tiezi.PAGE_SIZE);
			// ��SQL����еĵ�2��������ֵ
			ps.setInt(3, Tiezi.PAGE_SIZE);
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
	
	public int findCount(String name){
		// �ܼ�¼��
		int count = 0;
		// ��ȡ���ݿ�����
		Connection conn = jdbcutil.getConnection();
		// ��ѯ�ܼ�¼��SQL���
		
		try {
			// ����Statement
			String sql = "select count(*) from tiezi where name=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
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
	public List<Tiezi> findT(int page,String title){
		// ��ȡ���ݿ�����
				Connection conn = jdbcutil.getConnection();
		// ����List
		List<Tiezi> list = new ArrayList<Tiezi>();
		
		try {
			// ��ȡPreparedStatement
			//Statement stmt = conn.createStatement();
			String sql = "select * from tiezi where title=? order by time desc limit ? ,? ";
			ps =conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, (page - 1) * Tiezi.PAGE_SIZE);
			// ��SQL����еĵ�2��������ֵ
			ps.setInt(3, Tiezi.PAGE_SIZE);
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
	
	public int findCountt(String title){
		// �ܼ�¼��
		int count = 0;
		// ��ȡ���ݿ�����
		Connection conn = jdbcutil.getConnection();
		// ��ѯ�ܼ�¼��SQL���
		
		try {
			// ����Statement
			String sql = "select count(*) from tiezi where title=?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
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
