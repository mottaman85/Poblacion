package com.curso.login.service;

import java.util.List;

import com.curso.login.vo.LoginVO;

public interface LoginService {
	public List<LoginVO> getLogin(String user, String pass);

}
