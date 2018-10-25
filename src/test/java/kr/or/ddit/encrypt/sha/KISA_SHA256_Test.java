package kr.or.ddit.encrypt.sha;

import static org.junit.Assert.*;

import org.junit.Test;

public class KISA_SHA256_Test {

	/**
	 * Method : encryptTest
	 * 작성자 : 김지태
	 * 변경이력 :
	 * Method 설명 : sha256 encrypt test
	 */
	@Test
	public void encryptTest() {
		/***Given***/
		String pass = "brownpass";
		String pass1 = "minions";
		String pass2 = "xxxxpass";
		String sally = "sallypass";
		String cony = "conypass";
		String moon = "moonpass";
		String james = "jamespass";

		/***When***/
		String encrypt = KISA_SHA256.encrypt(pass);
		String encrypt1 = KISA_SHA256.encrypt(pass1);
		String encrypt2 = KISA_SHA256.encrypt(pass2);
		String sally_encrypt = KISA_SHA256.encrypt(sally);
		String cony_encrypt = KISA_SHA256.encrypt(cony);
		String moon_encrypt = KISA_SHA256.encrypt(moon);
		String james_encrypt = KISA_SHA256.encrypt(james);
		
		System.out.println("encrypt	  : " + encrypt);
		System.out.println("encrypt1  : " + encrypt1);
		System.out.println("encrypt2  : " + encrypt2);
		System.out.println("sally  : " + sally_encrypt);
		System.out.println("cony  : " + cony_encrypt);
		System.out.println("moon  : " + moon_encrypt);
		System.out.println("james  : " + james_encrypt);
		
		/***Then***/
		assertEquals("f01471c38113db263f9a532d8b6c054af31bf653aeea92d1c284cdd022b9", encrypt);

	}

}

