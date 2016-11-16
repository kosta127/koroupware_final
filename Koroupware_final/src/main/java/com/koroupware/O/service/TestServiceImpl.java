package com.koroupware.O.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.koroupware.O.domain.Test;
import com.koroupware.O.persistence.TestDAO;

@Service
public class TestServiceImpl implements TestService {

	@Inject
	private TestDAO dao;
	
	@Override
	public Test testRead() {
		return dao.testSelect();
	}

}
