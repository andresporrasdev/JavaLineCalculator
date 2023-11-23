/*
* Title Assessment: Assignment2
* Student Name: Andres Camilo Porras Becerra
* Due Date: 26 Nov
* Description: Simple line calculator for test catch exceptions in Java
* Professor Name: Islam Gomaa
* Course CST8284 Section 331
*/
/**
 * Package for line calculator for test catch exceptions in Java
 */
package assignment2;
import java.util.Scanner;

/**
 * Class CalculatorInput for get the input of the user and throw errors accordingly
 */
public class CalculatorInput {
	/**
	 * Main method of CalculatorInput
	 * @param args No additional arguments required
	 */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        //Creation of a new instance of CalculatorEngine for do maths operations
        CalculatorEngine calculatorEngine = new CalculatorEngine();

        System.out.println("Welcome to the Assignment 2 CST8284 calculator.");
        System.out.println("Written by Andres Porras, #041056717\n\n");
        System.out.println("Equations are in the form num1 operator num2 =");
        System.out.println("Where num1 and num2 must be integers,");
        System.out.println("operator is one of +, -, / or *\n");
        System.out.println("Enter 0 = to quit.\n\n");
        
        // While true will continue asking for equations
        while (true) {
        	//Block code for catch exceptions
            try {
            	Scanner input;
            	int num1, num2;
            	String sign, equals, buffer;
                System.out.print("Enter your equation: ");
                buffer = keyboard.nextLine();

                if (buffer.equals("0 =")) {
                    System.out.println("Program exiting");
                    System.out.println("Caught \'0 =\' with if statements");
                    break;
                }

                if (buffer.trim().isEmpty()) {
                    throw new IllegalArgumentException("Error: Equation incomplete. First number is missing.");
                }

                input = new Scanner(buffer);
                if (!input.hasNextInt()) {
                    throw new java.util.InputMismatchException("First number is not an integer.");
                }

                num1 = input.nextInt();
                if (!input.hasNext()) {
                    throw new IllegalArgumentException("Equation incomplete. Operator is missing.");
                }

                sign = input.next();
                if (!sign.matches("[-+*/]")) {
                    throw new IllegalArgumentException("Invalid operator. Valid operators are +, -, /, and *");
                }

                if (!input.hasNextInt()) {
                    throw new java.util.InputMismatchException("Second number is missing.");
                }

                num2 = input.nextInt();
                if (!input.hasNext()) {
                    throw new IllegalArgumentException("Equation incomplete. Equation must end with =");
                }

                equals = input.next();

                if (!equals.equals("=")) {
                    throw new IllegalArgumentException("Equation incomplete. Equation must end with =");
                }

                int result = 0;
                
                //Depends on sign will chose the correct math operation in CalculatorEngine class
                switch (sign) {
                    case "+":
                        result = calculatorEngine.add(num1, num2);
                        break;
                    case "-":
                        result = calculatorEngine.subtract(num1, num2);
                        break;
                    case "*":
                        result = calculatorEngine.multiply(num1, num2);
                        break;
                    case "/":
                        result = calculatorEngine.divide(num1, num2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator. Valid operators are +, -, /, and *");
                }
                //Display the result from CalculatorEngine operation
                System.out.println("That answer is: " + result);

            } catch (java.util.InputMismatchException e) {
            	//Catch the error if user doesn't write a second operator
                System.out.println("Error caught with InputMismatchException");
                System.err.println("Error: " + e.getMessage());
                keyboard.nextLine(); // Clear the input buffer
            } catch (java.util.NoSuchElementException e) {
            	//Catch the error if user writes 
            	System.out.println("Error caught with NoSuchElementException");
                System.err.println("Error: " + e.getMessage());
                keyboard.nextLine(); // Clear the input buffer
            } catch (IllegalArgumentException e) {
            	//Catch the error if user writes 
            	System.out.println("Error caught with IllegalArgumentException");
                System.err.println("Error: " + e.getMessage());
                keyboard.nextLine(); // Clear the input buffer
            } catch (java.lang.ArithmeticException e) {
            	//Catch the error if user writes 
            	System.out.println("Error caught with ArithmeticException");
                System.err.println("Error: " + e.getMessage());
                keyboard.nextLine(); // Clear the input buffer
            }
        }

        keyboard.close();
    }
}


