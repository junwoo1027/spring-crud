package com.company.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVo {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	private int fix;
	private int replyCnt;
	private String replyer;
	private String reply;
}
