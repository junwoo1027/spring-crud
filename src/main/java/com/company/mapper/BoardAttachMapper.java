package com.company.mapper;

import java.util.List;

import com.company.domain.BoardAttachVo;

public interface BoardAttachMapper {

	public void insert(BoardAttachVo boardAttach);
	
	public void delete(String uuid);
	
	public List<BoardAttachVo> findByBno(Long bno);
	
	public void deleteAll(Long bno);
	
	public List<BoardAttachVo> getOldFiles();

}
