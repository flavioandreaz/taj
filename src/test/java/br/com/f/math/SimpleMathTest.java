package br.com.f.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimplesMath Class")
public class SimpleMathTest {
	
	SimpleMath math;
	Double firstNumber;
	Double secondNumber;
	
	@BeforeAll
	static void setup(){
		System.out.println("Running BeforeAll method!");
	}
	@AfterAll
	static void cleanup(){
		System.out.println("Running AfterAll method!");
	}
	@BeforeEach
	void beforeEachMethod(){
		math = new SimpleMath();
		firstNumber = 6.2D;
		secondNumber = 2D;
		System.out.println("Running BeforeEach method!");
	}
	@AfterEach
	void afterEachMethod(){
		System.out.println("Running AfterEach method!");
	}
	
	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum() {
		System.out.println("Test 6.2 + 2 = 8.2");
		///AAA Arrange, Act, Assert		
		Double expected = 8.2D;
		//When/Act 
		Double actual = math.sum(firstNumber, secondNumber);
		//Then/Assert		
		assertEquals(expected, actual, 
				()-> firstNumber +  "+" + secondNumber + " did not produce " + expected + "!");
	}
	@Test
	@DisplayName("Test 6.2 - 2 = 4.2")
	void testSubtraction() {
		//Given/Arrange 		
		Double expected = 4.2D;
		//When/Act 
		Double actual = math.subtraction(firstNumber, secondNumber);
		//Then/Assert
		assertEquals(expected, actual, 
				()-> firstNumber +  "-" + secondNumber + " did not produce " + expected + "!");
	}
	@Test
	@DisplayName("Test 6.2 * 2 = 12.4")
	void testMultiplication() {
		//Given/Arrange
		Double expected = 12.4D;
		//When/Act 
		Double actual = math.multiplication(firstNumber, secondNumber);
		//Then/Assert
		assertEquals(expected, actual, 
				()-> firstNumber +  "*" + secondNumber + " did not produce " + expected + "!");
	}
	@Test
	@DisplayName("Test 6.2 / 2 = 3.1")
	void testDivision() {
		//Given/Arrange
		Double expected = 3.1D;
		//When/Act 
		Double actual = math.division(firstNumber, secondNumber);	
		//Then/Assert
		assertEquals(expected, actual, 
				()-> firstNumber +  "/" + secondNumber + " did not produce " + expected + "!");
	}
	@Test
	@DisplayName("Test (6.2+2)/2 = 4.1")
	void testMean() {
		//Given/Arrange
		Double expected = 4.1D;
		//When/Act 
		Double actual = math.mean(firstNumber, secondNumber);		
		//Then/Assert
		assertEquals(expected, actual, 
				()-> "(" + firstNumber +  "+" + secondNumber + ")/2 did not produce " + expected + "!");
	}
	@Test
	@DisplayName("Test Square Root of 81  = 9")
	void testSquareRoot() {
		//Given/Arrange 		
		Double number = 81D;		
		Double expected = 9D;
		//When/Act 
		Double actual = math.squareRoot(number);
		//Then/Assert
		assertEquals(expected, actual, 
				()-> "Square Root of " + number +  " did not produce " + expected + "!");
	}
	
	@Test
	@DisplayName("Test Division by Zero")
	void testDivisionByZero() {
		//Given/Arrange
		var expectedMessage = "Impossible to divide by zero!";
		//When/Act && Then/Assert
		ArithmeticException actual  =assertThrows(ArithmeticException.class, ()-> {  
			math.division(firstNumber, 0D);
		}, ()-> "Division by zero should throw an ArithmeticException");		
		
		assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message!");
	}
}
