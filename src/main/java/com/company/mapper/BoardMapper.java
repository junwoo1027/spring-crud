package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;

public interface BoardMapper {

//	@Select("select * from board where bno > 0")
	public List<BoardVo> getList();
	
	public List<BoardVo> getListWithPaging(Criteria cri);
	
	public void insert(BoardVo board);
	
	public BoardVo read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVo board);
	
	public int getTotalCount(Criteria cri);
	
	public void updateReplyCnt(@Param("bno") long bno, @Param("amount") int amount);
	
	public BoardVo getBoardReplyInfo(Long bno);
	
	public void updateGroupOrd(BoardVo board);
	
	public void insertBoardReply(BoardVo board);
}
