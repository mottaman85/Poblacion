package com.curso.login.dao;
import java.util.List;

import com.curso.login.vo.LoginVO;



public interface LoginDao {
	public List<LoginVO> getLogin(String user,String pass);
}
