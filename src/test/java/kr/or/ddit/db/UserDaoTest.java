package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

	private UserDaoInf userDao;
	
	@Before
	public void setup(){
		userDao = new UserDao();
	}
	
	@Test
	public void getUserAllTest() {
		/***Given***/
		
		/***When***/
		List<UserVo> testList = userDao.selectUserAll();
		System.out.println(testList);
		
		/***Then : 실제 데이터 count 5와 가져온 사이즈가 같은지 비교***/
		assertEquals(105, testList.size());
	}

	@Test
	public void selectUserTest() {
		/***Given***/
		
		/***When***/
		UserVo userTest = userDao.selectUser("brown");
		System.out.println(userTest);
		
		/***Then***/
		assertNotNull(userTest);
		assertEquals("브라운", userTest.getName());
		assertEquals("brown", userTest.getUserId());
	}
	
	@Test
	public void selectUserByVoTest() {
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId("sally");
		
		/***When***/
		UserVo userByVo = userDao.selectUser(userVo);
		System.out.println(userByVo);
		
		/***Then***/
		assertNotNull(userByVo);
		assertEquals("샐리", userByVo.getName());
		assertEquals("sally", userByVo.getUserId());
		
	}
	
	@Test
	public void selectUserPageListTest() {
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);

		/***When***/
		List<UserVo> pageList = userDao.selectUserPageList(pageVo);

		/***Then***/
		assertEquals(10, pageList.size());
		
	}
	
	/**
	 * Method : getUserCntTest
	 * 작성자 : 김지태
	 * 변경이력 :
	 * Method 설명 : 사용자 전체 건수 조회 테스트
	 */
	@Test
	public void getUserCntTest() {
		/***Given***/

		/***When***/
		int totalUserCnt = userDao.getUserCnt();
		
		/***Then***/
		assertEquals(105, totalUserCnt);
		
	}
	
}

