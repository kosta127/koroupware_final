package com.koroupware.search.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.member.dto.EmpDTO;
import com.koroupware.search.domain.Criteria;
import com.koroupware.search.domain.SearchVO;

@Repository
public class SearchDaoImpl implements SearchDao{
	@Inject
	private SqlSession sqlSession;

	private static final String namespace = "com.koroupware.search.mapper.searchMapper";





	@Override
	public int countPaging(SearchVO cri) throws Exception {
		return sqlSession.selectOne(namespace+".countPaging", cri);
	}

	@Override
	public List<EmpDTO> listCriteriaPerson(SearchVO cri) throws Exception {
		return sqlSession.selectList(namespace+".listCriteriaPerson", "%"+cri.getSearch_content()+"%", new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

	@Override
	public List<EmpDTO> listCriteriaDoc(SearchVO cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".listCriteriaDoc", "%"+cri.getSearch_content()+"%", new RowBounds(cri.getPageStart(), cri.getPerPageNum()));
	}

}
