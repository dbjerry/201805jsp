package kr.or.ddit.encrypt.seed;

import static org.junit.Assert.*;

import org.junit.Test;

public class KISA_SEED_CBC_Test {

	@Test
	public void encryptTest() {
		/***Given***/
		String pass = "brownpass";

		/***When***/
		String encrypt = KISA_SEED_CBC.Encrypt(pass);		//	암호화
		String decrypt = KISA_SEED_CBC.Decrypt(encrypt);	//	복호화
		
		/***Then***/
		assertEquals("5207bbf01d00451c23800ae909470f26", encrypt);
		assertEquals("brownpass", decrypt);
		
	}

}

