package kr.or.ddit.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {
	
	// jUnit 실행주기
	// @BeforeClass	어노테이션이 적용된 메소드 실행(최초 1회), 단 static 메서드로 선언
	// @Before		어노테이션이 적용된 메서드 실행(테스트 메서드 실행 전 실행)
	// @Test		
	// @After		어노테이션이 적용된 메서드 실행(테스트 메서드 실행 후 실행)
	// @AfterClass	어노테이션이 적용된 메서드 실행(최초 1회), 단 static 메서드로 선언
	
	// beforeClass --> 
	// before --> selectUserAll --> after
	// before --> selectUser(String) --> after
	// before --> selectUser(UserVo) --> after
	// --> afterClass
	
	private UserServiceInf userService;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass");
	}

	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}

	@Before
	public void before(){
		System.out.println("before");
		userService = new UserService();
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	
	
	@Test
	public void selectUserAllTest() {
		/***Given***/

		/***When***/
		List<UserVo> testList = userService.selectUserAll();
		System.out.println(testList);
		
		/***Then : 실제 데이터 count 5와 가져온 사이즈가 같은지 비교***/
		assertEquals(5, testList.size());

	}
	
	@Test
	public void selectUserTest() {
		/***Given***/
		
		/***When***/
		UserVo userTest = userService.selectUser("brown");
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
		UserVo userByVo = userService.selectUser(userVo);
		System.out.println(userByVo);
		
		/***Then***/
		assertNotNull(userByVo);
		assertEquals("샐리", userByVo.getName());
		assertEquals("sally", userByVo.getUserId());
		
	}
	
}

