package kr.or.ddit.sum;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculationLogicTest {
	
	/* 1~10까지의 합 */
	@Test
	public void sumBetweenTwoNumbers() {
		CalculationLogic logic = new CalculationLogic();
		
		int start = 10;
		int end = 1;
		
		int sumResult = logic.sumBetweenTwoNumbers(start, end);
		
		assertEquals(55, sumResult);
	}
}

