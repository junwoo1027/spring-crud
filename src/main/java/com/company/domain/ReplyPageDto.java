package com.company.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplyPageDto {

	private int replyCnt;
	private List<ReplyVo> list;
}
