package com.company.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListDto {

	private List<BoardVo> board;
	private List<ReplyVo> reply;
}
