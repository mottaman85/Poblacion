package com.curso.login.service;

import java.util.List;

import com.curso.login.dao.LoginDao;
import com.curso.login.dao.LoginDaoImpl;
import com.curso.login.vo.LoginVO;



public class LoginServiceImpl implements LoginService {
LoginDao dao;

public List<LoginVO> getLogin(String user, String pass) {
	// TODO Auto-generated method stub
	dao = new LoginDaoImpl();
	return dao.getLogin(user, pass);
}
}
