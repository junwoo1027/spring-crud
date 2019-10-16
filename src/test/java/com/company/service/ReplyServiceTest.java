package com.company.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {com.company.config.RootConfig.class})
@Log4j
public class ReplyServiceTest {

	@Setter(onMethod_ = @Autowired)
	private ReplyService service;
	
	@Test
	public void testList() {
		log.info(service.getList(2L));
	}
	
}
