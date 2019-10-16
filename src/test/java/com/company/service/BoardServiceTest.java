package com.company.service;

import static org.junit.Assert.assertNotNull;

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
@ContextConfiguration(classes= {com.company.config.RootConfig.class})
@Log4j
public class BoardServiceTest {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
//	@Test
//	public void testExist() {
//		
//		log.info(service);
//		assertNotNull(service);
//	}
	
//	@Test
//	public void testRegister() {
//		BoardVo board = new BoardVo();
//		board.setTitle("제목");
//		board.setContent("content");
//		board.setWriter("writer");
//		
//		service.register(board);
//		
//		log.info("생성된 게시물 번호:" + board.getBno());
//	}
	
//	@Test
//	public void testGet() {
//		log.info(service.get(1L));
//	}
	
//	@Test
//	public void testList() {
//		log.info(service.getList());
//	}
	
//	@Test
//	public void testUpdate() {
//		BoardVo board = service.get(1L);
//		
//		if(board == null) {
//			return;
//		}
//		
//		board.setTitle("제목 수정");
//		log.info("modify result:" + service.modify(board));
//	}
	

//	@Test
//	public void listPageTest() {
//		Criteria cri = new Criteria();
//		cri.setPageNum(2);
//		cri.setAmount(10);
//		
//		List<BoardVo> boards = service.getList(cri);
//		for(BoardVo board : boards) {
//			log.info(board.getBno()+ ":" + board.getTitle());
//		}
//	}
	
//	@Test
//	public void getTotalTest() {
//		Criteria cri = new Criteria();
//		Integer totalCount = service.getTotal(cri);
//		log.info("total: " + totalCount.toString());
//	}
	
//	@Test
//	public void testClass() {
//		log.info(service);
//		log.info(service.getClass().getName());
//	}

//	@Test
//	public void testGet() {
//		log.info(service.get(110L));
//	}
}
