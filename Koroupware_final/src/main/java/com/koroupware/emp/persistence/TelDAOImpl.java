package com.koroupware.emp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.emp.domain.TelDTO;
import com.koroupware.emp.domain.TelVO;

@Repository
public class TelDAOImpl implements TelDAO {

   @Inject
   private SqlSession sqlSession;
   
   private static final String namespace = "com.koroupware.mappers.TelMapper";
   
   @Override
   public void create(TelVO telVo) throws Exception {
      sqlSession.insert(namespace+".signUpTel", telVo);
   }
   
   @Override
   public List<TelDTO> telList(Integer emp_no) throws Exception {
      return sqlSession.selectList(namespace+".telList", emp_no);
   }

   @Override
   public void addTel(TelDTO telDTO) throws Exception {
      sqlSession.insert(namespace+".addTel", telDTO);
   }

   @Override
   public void deleteTel(Integer tel_no) throws Exception {
      sqlSession.delete(namespace+".deleteTel", tel_no);   
   }



}