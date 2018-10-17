package kr.or.ddit.db;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class ProdDaoTest {

	private ProdDaoInf prodDao;
	
	@Before
	public void setup(){
		prodDao = new ProdDao();
	}
	
	@Test
	public void getProdCntTest() {
		/***Given***/

		/***When***/
		int totalProdCnt = prodDao.getProdCnt();

		/***Then***/
		assertEquals(74, totalProdCnt);

	}

	@Test
	public void selectProdPageListTest() {
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);

		/***When***/
		List<ProdVo> pageList = prodDao.selectProdPageList(pageVo);
		
		/***Then***/
		assertEquals(10, pageList.size());

	}
	
}

