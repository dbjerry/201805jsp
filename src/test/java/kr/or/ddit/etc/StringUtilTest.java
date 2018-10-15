package kr.or.ddit.etc;

import static org.junit.Assert.assertEquals;
import kr.or.ddit.util.StringUtil;

import org.hamcrest.core.SubstringMatcher;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void test() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"brown.png\"";

		/***When***/
		// logic
		String fileName = StringUtil.getFileName(contentDisposition);
		
		/***Then***/
		assertEquals("brown.png", fileName);

	}
	
	// 쿠키 문자열 파싱 테스트
	@Test
	public void getCookieTest() {
		/***Given***/
		String cookieString = "remember=Y; userId=brown; etc=test";

		/***When***/
		String cookieValue = StringUtil.getCookie(cookieString, "remember");
		String cookieValue2 = StringUtil.getCookie(cookieString, "userId");
		String cookieValue3 = StringUtil.getCookie(cookieString, "etc");
		
		/***Then***/
		assertEquals("Y", cookieValue);
		assertEquals("brown", cookieValue2);
		assertEquals("test", cookieValue3);

	}
	
}

