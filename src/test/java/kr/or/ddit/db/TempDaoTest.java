package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class TempDaoTest {

	// 테스트 메서드 명명 규칙(회사마다 다름)
	// 운영코드 메서드 이름 + Test
	// getTemp + Test : getTempTest
	@Test
	public void getTempTest() {
		/***Given : 주어진 상황***/
		TempDao tempDao = new TempDao();

		/***When : 어떤 동작 수행(메서드 호출)***/
		Map<String, Object> map = tempDao.getTemp();
		
		// select 'X' as result from dual
		// result : X
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertEquals("X", map.get("result"));
		System.out.println("map : " + map);
		
	}
}

