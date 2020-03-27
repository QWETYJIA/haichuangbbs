package com.kaohe.dao;

import java.util.List;

import com.kaohe.beans.Yonghu;

public interface IYonghuDao {

	Yonghu selectYonghuLogin(String name, String password, String gl);

	void insertYonghu(Yonghu yonghu);
	//List<Yonghu> find();
}
