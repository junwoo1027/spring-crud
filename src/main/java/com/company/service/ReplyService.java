package com.company.service;

import java.util.List;

import com.company.domain.Criteria;
import com.company.domain.ReplyPageDto;
import com.company.domain.ReplyVo;

public interface ReplyService {

	public int register(ReplyVo reply);
	
	public ReplyVo get(Long rno);
	
	public int modify(ReplyVo reply);
	
	public int remove(Long rno);
	
	public List<ReplyVo> getList(Long bno);
	
	public ReplyPageDto getListPage(Criteria cri, Long bno);
	
	public List<ReplyVo> getReply(Long bno);
}
