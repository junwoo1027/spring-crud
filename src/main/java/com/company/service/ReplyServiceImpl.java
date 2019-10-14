package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.domain.Criteria;
import com.company.domain.ReplyPageDto;
import com.company.domain.ReplyVo;
import com.company.mapper.BoardMapper;
import com.company.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Transactional
	@Override
	public int register(ReplyVo reply) {
		log.info("register: " + reply);
		
		boardMapper.updateReplyCnt(reply.getBno(), 1);
		return mapper.insert(reply);
	}

	@Override
	public ReplyVo get(Long rno) {
		log.info("get: " + rno);
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVo reply) {
		log.info("modify: " + reply );
		return mapper.update(reply);
	}

	@Transactional
	@Override
	public int remove(Long rno) {
		log.info("remove: " + rno);
		
		ReplyVo reply = mapper.read(rno);
		
		boardMapper.updateReplyCnt(reply.getBno(), -1);
		return mapper.delete(rno);
	}

//	@Override
//	public List<ReplyVo> getList(Criteria cri, Long bno) {
//		log.info("get Reply List of a Board " + bno);
//		return mapper.getListWithPaging(cri, bno);
//	}

	
	@Override
	public List<ReplyVo> getList(Long bno) {
		log.info("get Reply List of a Board " + bno);
		return mapper.getList(bno);
	}
	
	@Override
	public ReplyPageDto getListPage(Criteria cri, Long bno) {
		return new ReplyPageDto(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
	}

	@Override
	public List<ReplyVo> getReply(Long bno) {
		return mapper.getList(bno);
	}	
}
