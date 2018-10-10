package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.Test;

public class UserDaoTest {

	@Test
	public void getUserAllTest() {
		/***Given***/
		UserDao userDao = new UserDao();
		

		/***When***/
		List<UserVo> testList = userDao.selectUserAll();
		System.out.println(testList);
		
		/***Then : 실제 데이터 count 5와 가져온 사이즈가 같은지 비교***/
		assertEquals(5, testList.size());
	}

	@Test
	public void selectUserTest() {
		/***Given***/
		UserDao userDao = new UserDao();
		
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
		UserDao userDao = new UserDao();
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
	
}

