package com.company.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;
import com.company.domain.ReplyVo;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {com.company.config.RootConfig.class})
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
////	@Test
////	public void testMapper() {
////		log.info(mapper);
////	}
////	
//	@Test
//	public void testRead() {
//		
//		Long rno = 3L;
//		ReplyVo reply = mapper.read(rno);
//		
//		log.info(reply);
//	}
//	
////	@Test
////	public void testDelete() {
////		Long rno = 1L;
////		
////		mapper.delete(rno);
////	}
//
//	@Test
//	public void testUpdate() {
//		Long rno =2L;
//		ReplyVo reply = mapper.read(rno);
//		
//		reply.setReply("update reply");
//		
//		int count=mapper.update(reply);
//		
//		log.info("update count: " + count);
//	}
//	
//
//	@Test
//	public void testCreate() {
////		IntStream.rangeClosed(1, 10).forEach(i->{
//			
//			ReplyVo reply = new ReplyVo();
//			
//			reply.setBno(109L);
//			reply.setReply("테스트");
//			reply.setReplyer("dd");
//			
//			mapper.insert(reply);
//	}
	
//	@Test
//	public void testPaging() {
//		Criteria cri = new Criteria();
//		
//		cri.setPageNum(2);
//		cri.setAmount(10);
//		
//		List<ReplyVo> replies = mapper.getListWithPaging(cri, 19L);
//		
//		replies.forEach(reply -> log.info(reply));
//	}
	
	@Test
	public void testList() {
		mapper.getList(19L);
	}
}
