package assignment2;

/*
* Title Assessment: Assignment2
* Student Name: Andres Camilo Porras Becerra
* Due Date: 26 Nov
* Description: Engine Calculator to add, substract, multiply and divide integers
* Professor Name: Islam Gomaa
* Course CST8284 Section 331
*/
/**
 * Class calculatorEngine for add, subtract, multiply, divide integers
 */
class CalculatorEngine {
	/**
	 * Method for add integers
	 * @param num1 first number to add
	 * @param num2 second number to add
	 * @return num1+num2 the add of the numbers
	 */
    int add(int num1, int num2) {
        return num1 + num2;
    }
    
    /**
	 * Method for subtract integers
	 * @param num1 first number to subtract
	 * @param num2 second number to subtract
	 * @return num1+num2 the subtract of the numbers
	 */
    int subtract(int num1, int num2) {
        return num1 - num2;
    }
    
    /**
	 * Method for multiply integers
	 * @param num1 first number to multiply
	 * @param num2 second number to multiply
	 * @return num1+num2 the multiply of the numbers
	 */
    int multiply(int num1, int num2) {
        return num1 * num2;
    }
    /**
	 * Method for divide integers
	 * @param num1 first number to divide
	 * @param num2 second number to divide
	 * @return num1+num2 the divide of the numbers
	 */
    int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Can not divide by zero! Result is invalid, returning zero.");
        }
        return num1 / num2;
    }
}