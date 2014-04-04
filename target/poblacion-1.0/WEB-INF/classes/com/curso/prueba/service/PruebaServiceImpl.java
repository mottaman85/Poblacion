package com.curso.prueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.prueba.dao.PruebaDao;
import com.curso.roles.vo.RolVO;

@Service(value="PruebaService")
public class PruebaServiceImpl implements PruebaService{

	@Autowired
	PruebaDao pruebaDao;

	public List<RolVO> getRoles() {
		return pruebaDao.getRoles();
	}
	
}
