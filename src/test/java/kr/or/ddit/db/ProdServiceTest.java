package kr.or.ddit.db;

import static org.junit.Assert.*;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;

import org.junit.Before;
import org.junit.Test;

public class ProdServiceTest {

	private ProdServiceInf service;
	
	@Before
	public void before(){
		service = new ProdService();
	}
	
	@Test
	public void selectProdDetailTest() {
		/***Given***/

		/***When***/
		ProdVo prodTest = service.selectProdDetail("P102000005");

		/***Then***/
		assertEquals("삼성 칼라 TV 53인치", prodTest.getProd_name());


	}

}

