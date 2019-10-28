package com.company.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ContextConfiguration(classes = {com.company.config.RootConfig.class})
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));
//	}
	
//	@Test
//	public void testInsert() {
//		BoardVo board = new BoardVo();
//		board.setTitle("2글");
//		board.setContent("2 글 내용");
//		board.setWriter("newbie");
//		mapper.insert(board);
//		
//		log.info(board);
//	}
	
//	@Test
//	public void read() {
//		
//		BoardVo board = new BoardVo();
//		board.setBno(9L);
//		board.setTitle("T");
//		board.setContent("C");
//		board.setWriter("W");
//		
//		log.info(board);
//		
//	}
	
	
//	@Test
//	public void testDelete() {
//		log.info("DELETE COUNT: " + mapper.delete(3L));
//	}
	
//	@Test
//	public void testUpdate() {
//		BoardVo board = new BoardVo();
//		
//		board.setBno(3L);
//		board.setTitle("수정 제목");
//		board.setContent("수정된 내용");
//		board.setWriter("user");
//		
//		int count = mapper.update(board);
//		log.info("update count: " + count);
//	}
	
//	@Test
//	public void tesPaging() {
//		Criteria cri = new Criteria();
//		
//		cri.setPageNum(1);
//		cri.setAmount(10);
//		List<BoardVo> list = mapper.getListWithPaging(cri);
//		list.forEach(board -> log.info(board));
//	}
	
	//부모글 그룹번호, 그룹순서, 깊이 조회
//	@Test
//	public void test() {
//		BoardVo board = new BoardVo();
//		
//		mapper.getBoardReplyInfo(9L);
//		
//	}
	
	//답글 순서 변경 테스트
//	@Test
//	public void boardOrd() {
//		BoardVo board = new BoardVo();
//		
//		board.setGroupNo(9);
//		
//		mapper.updateGroupOrd(board);
//		
//		log.info(board);
//	}
	
	//답글 등록 테스트
	@Test
	public void BoadReply() {
		BoardVo board = mapper.getBoardReplyInfo(24L);
		
		board.setTitle("앵");
		board.setContent("reply");
		board.setWriter("jun");
		
		mapper.updateGroupOrd(board);
		mapper.insertBoardReply(board);
		
		log.info(board);
	}
}
