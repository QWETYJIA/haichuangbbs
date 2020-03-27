package com.kaohe.service;

import java.util.List;

import com.kaohe.beans.Yonghu;
import com.kaohe.dao.IYonghuDao;
import com.kaohe.dao.YonghuDaoImpl;
import com.zuopin.beans.Tiezi;

public class YonghuServiceImpl implements IYonghuService {
     private IYonghuDao dao;
      
	public YonghuServiceImpl() {
		dao =new YonghuDaoImpl();	
	}

	public Yonghu checkUser(String name, String password,String gl) {
		return dao.selectYonghuLogin(name,password,gl);
	}

	public void saveYonghu(Yonghu yonghu) {
		dao.insertYonghu(yonghu);
		
	}



	//public List<Yonghu> findyh() {
		
		// dao.List<Yonghu> find();
	//}

	
}
 