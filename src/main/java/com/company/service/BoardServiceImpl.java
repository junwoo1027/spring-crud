package com.company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.domain.BoardVo;
import com.company.domain.Criteria;
import com.company.domain.ListDto;
import com.company.mapper.BoardMapper;
import com.company.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	private BoardMapper mapper;
	private ReplyMapper replyMapper;
	
	@Override
	public void register(BoardVo board) {
		mapper.insert(board);
	}

	@Override
	public BoardVo get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVo board) {
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVo> getList(Criteria cri) {
		log.info("list: " + cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	@Override
	public ListDto getBoard(Criteria cri, long bno) {
		return new ListDto(mapper.getListWithPaging(cri), replyMapper.getList(bno));
	}
}
