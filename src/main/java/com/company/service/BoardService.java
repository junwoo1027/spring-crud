package com.company.service;

import java.util.List;

import com.company.domain.BoardAttachVo;
import com.company.domain.BoardVo;
import com.company.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVo board);
	
	public BoardVo get(Long bno);
	
	public boolean modify(BoardVo board);
	
	public boolean remove(Long bno);
	
	public List<BoardVo> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
	public BoardVo getBoardReplyInfo(Long bno);
	
	public void updateGroupOrd(BoardVo board);
	
	public void insertBoardReply(BoardVo board);
	
	public List<BoardAttachVo> getAttachList(Long bno);
	
}
