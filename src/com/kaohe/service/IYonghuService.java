package com.kaohe.service;

import java.util.List;

import com.kaohe.beans.Yonghu;
import com.zuopin.beans.Tiezi;

public interface IYonghuService {

	Yonghu checkUser(String name, String password, String gl);
//��db������û�
	void saveYonghu(Yonghu yonghu);
	
	//List<Yonghu> findyh();

  



}
