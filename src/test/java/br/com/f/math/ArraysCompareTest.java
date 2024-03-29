package br.com.f.math;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@DisplayName("Test Arrays Operations")
public class ArraysCompareTest {
	@Test
	@DisplayName("Test Sort")
	void test() {
		//Given/Arrange
		int[] numbers = { 25, 8, 21, 32, 3 };
		int[] expectedArray = { 3, 8, 21, 25, 32 };
		//When/Act 
		Arrays.sort(numbers);
		//Then/Assert
		assertArrayEquals(numbers, expectedArray);
	}
	
	@Test
	@Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
	@DisplayName("Test Sort Timeout")
	void testSortPerformance() {
		//Given/Arrange
		int[] numbers = { 25, 8, 21, 32, 3 };
		//When/Act
		for (int i =0; i< 1000000000;i++) {
			numbers[0] = i;
			Arrays.sort(numbers);
		}
		//Then/Assert
	}
	
}
