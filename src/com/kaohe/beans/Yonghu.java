package com.kaohe.beans;

import java.io.Serializable;

public class Yonghu implements Serializable {


      private Integer id;    //主键 业务无关主键
	  private String name;
	  private String username;
	  private String password;
	  
	  private String gl;
	  
      public String getUsername() {
		return username;
	}

	
	
      public void setUsername(String username) {
		this.username = username;
	}



	
      
	public String getGl() {
		return gl;
	}

	public void setGl(String gl) {
		this.gl = gl;
	}

	public Yonghu() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public Yonghu(String name) {
		super();
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Yonghu [id=" + id + ", name=" + name + ", password=" + password + "]";
	}}
      
      