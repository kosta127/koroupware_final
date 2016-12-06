//package com.koroupware.dept.controller;
//
//import javax.inject.Inject;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//public class DeptControllerTest {
//	@Inject
//	private DeptDao dao;
//	
//	@Test
//	public void selectTest() throws Exception{
//		assertNotNull(dao.selectDeptAll());
//		assertNotNull(dao.selectOrgChartEmpDetailModelByEmpNo(1));
//		assertNotNull(dao.selectOrgChartEmpModelByDeptNo(1));
//	}
//}