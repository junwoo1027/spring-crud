package com.company.domain;

import java.util.Date;

import lombok.Data;


public class BoardVo {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	private int fix;
	private int replyCnt;
	private int groupNo;
	private int groupOrd;
	private int depth;
	
	public Long getBno() {
		return bno;
	}
	public void setBno(Long bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public int getFix() {
		return fix;
	}
	public void setFix(int fix) {
		this.fix = fix;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getgroupOrd() {
		return groupOrd;
	}
	public void setGroupOrd(int groupOrd) {
		this.groupOrd = groupOrd;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		return "BoardVo [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", updateDate=" + updateDate + ", fix=" + fix + ", replyCnt=" + replyCnt + ", groupNo="
				+ groupNo + ", groupOrd=" + groupOrd + ", depth=" + depth + "]";
	}
}
