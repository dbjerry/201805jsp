package kr.or.ddit.etc;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void test() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"brown.png\"";

		/***When***/
		// logic
		String fileName = fileName(contentDisposition);
		
		/***Then***/
		assertEquals("brown.png", fileName);

	}
	
	public String fileName(String str){
		String fileName = "";
		String[] splits = str.split("; ");
		for(String str2 : splits){
			if(str2.indexOf("filename=") >= 0){
				fileName = str2.substring(10, str2.lastIndexOf("\""));
			}
		}
		return fileName;
	}
	
	

}
