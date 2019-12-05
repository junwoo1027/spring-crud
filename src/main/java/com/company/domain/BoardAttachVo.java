package com.company.domain;

import lombok.Data;

@Data
public class BoardAttachVo {

	private String uuid;
	private String uploadPath;
	private String fileName;
	private boolean image;
	
	private Long bno;
}
