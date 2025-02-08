package LAB7;
    public class ArithmeticExceptionHandling {
        public static void main(String[] args) {
            try {
                // Attempting to divide by zero
                int dividend = 10;
                int divisor = 0;
                int result = dividend / divisor;

                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                // Handling the exception
                System.out.println("Exception caught: Cannot divide by zero.");
                System.out.println("Error Message: " + e.getMessage());
            } finally {
                // Finally block executes regardless of exception occurrence
                System.out.println("Execution of finally block: Cleanup if necessary.");
            }
            System.out.println("Program execution continues normally after handling exception.");
        }
    }