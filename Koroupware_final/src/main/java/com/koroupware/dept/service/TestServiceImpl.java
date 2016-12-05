package com.koroupware.dept.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.dept.domain.Test;
import com.koroupware.dept.persistence.TestDAO;

@Service
public class TestServiceImpl implements TestService {

	@Inject
	private TestDAO dao;
	
	@Override
	public Test testRead() {
		return dao.testSelect();
	}

}
