package com.company.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public class ReplyPageDto {

	private int replyCnt;
	private List<ReplyVo> list;
	
	
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public List<ReplyVo> getList() {
		return list;
	}
	public void setList(List<ReplyVo> list) {
		this.list = list;
	}
	
	
}
