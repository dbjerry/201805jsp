package kr.or.ddit.locales;

import static org.junit.Assert.*;

import java.util.TimeZone;

import org.junit.Test;

public class TimezoneTest {

	@Test
	public void timezoneTest() {
		/***Given***/
		
		/***When***/
		String[] timezone = TimeZone.getAvailableIDs();
		
		for(String tz : timezone){
			System.out.println("timezone : " + tz);
		}
		
		/***Then***/
		
		
	}

}

