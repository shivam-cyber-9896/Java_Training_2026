package com.shivam.monocept;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	MyMath maths=new MyMath();
	//@Test
	/*void test() {
		int result=maths.AddArrays(new int[] {1,2,3});
		System.out.println(""+result);
		int expectedResult=6;
		assertEquals(expectedResult, result);
		}
	@Test
	void test1() {
		int result=maths.AddArrays(new int[] {});
		System.out.println(""+result);
		int expectedResult=0;
		assertEquals(expectedResult, result);
		} */
	
	@Test
		void calculateSumTest_threeMemberArrays() {
			assertEquals(6, maths.AddArrays(new int[] {1,2,3}));
			}
	@Test
	void calculateSumTest_ZeroMemberArrays() {
		assertEquals(0, maths.AddArrays(new int[] {}));
		}

}
