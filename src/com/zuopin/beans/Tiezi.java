package com.zuopin.beans;

public class Tiezi {
 
	public static final int PAGE_SIZE = 3;
	// 编号
	private int id;
	private String title;	
	private String neirong;	
	private String name;
	
	public Tiezi(String title, String neirong, String name, String time) {
		
		this.title = title;
		this.neirong = neirong;
		this.name = name;
		this.time = time;
	}
	public Tiezi() {
		super();// TODO 自动生成的构造函数存根
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String time;
	
	
}
