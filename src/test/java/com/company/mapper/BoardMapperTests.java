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
	
	@Test
	public void testInsert() {
		BoardVo board = new BoardVo();
		board.setTitle("새글");
		board.setContent("새 글 내용");
		board.setWriter("newbie");
		board.setFix(1);
		mapper.insert(board);
		
		log.info(board);
	}
	
//	@Test
//	public void testRead() {
//		BoardVo board = mapper.read(22L);
//		
//		log.info(board);
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
	
	@Test
	public void tesPaging() {
		Criteria cri = new Criteria();
		
		cri.setPageNum(1);
		cri.setAmount(10);
		List<BoardVo> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
