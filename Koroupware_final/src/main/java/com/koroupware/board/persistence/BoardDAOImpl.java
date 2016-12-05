package com.koroupware.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.koroupware.board.domain.BoardFileVO;
import com.koroupware.board.domain.BoardVO;
import com.koroupware.board.domain.Criteria;
import com.koroupware.board.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.koroupware.board.mappers.BoardMapper";
	
	@Override
	public void boardInsert(BoardVO vo) {
		Integer value = sqlSession.selectOne(namespace+".maxNumber");
		
		if(value == null){
			vo.setBoard_no(1);
		}else{
			vo.setBoard_no(value+1);
		}
		
		sqlSession.insert(namespace+".insertBoard", vo);
	}

	@Override
	public List<BoardVO> boardList(int category_no) throws Exception {
		
		return sqlSession.selectList(namespace+".listBoard", category_no);
	}

	@Override
	public void boardUpdate(BoardVO vo) throws Exception {
		sqlSession.update(namespace+".updateBoard", vo);
		
	}

	@Override
	public void boardDelete(int board_no) throws Exception {
		sqlSession.delete(namespace+".deleteBoard", board_no);
		
	}

	@Override
	public BoardVO boardSelect(int board_no) throws Exception {
		return sqlSession.selectOne(namespace+".detailBoard", board_no);
	}

	@Override
	public List<BoardVO> listCriteria(SearchCriteria cri) throws Exception {
		return sqlSession.selectList(namespace+".listBoard", cri, new RowBounds(cri.getPageStart(), cri.getPerPageNum()));//listAll, 넘어가는데이터값, 페이지
	}

	@Override
	public int countPaging(SearchCriteria cri) throws Exception {
		return sqlSession.selectOne(namespace+".countPaging", cri);
	}

	@Override
	public void updateViewCnt(int board_no) throws Exception {
		sqlSession.update(namespace+".updateViewCnt", board_no);
		
	}

	@Override
	public void fileInsert(BoardFileVO fileVO) throws Exception {
		sqlSession.insert(namespace+".fileInsert", fileVO);
		
	}

	@Override
	public int getBoardNo() throws Exception {
		return sqlSession.selectOne(namespace+".maxNumber");
	}

	@Override
	public List<String> getAttach(int board_no) throws Exception {
		System.out.println("dao"+board_no);
		return sqlSession.selectList(namespace+".getAttach", board_no);
	}

	@Override
	public void deleteAttach(int board_no) throws Exception {
		sqlSession.delete(namespace+",deleteAttach", board_no);
		
	}

	@Override
	public void updateRecCnt(int board_no) throws Exception {
		sqlSession.update(namespace+".updateRecCnt", board_no);
	}

}
