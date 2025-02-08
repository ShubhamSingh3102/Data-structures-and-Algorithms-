package LAB7;
    // User-defined exception class
    class NegativeNumberException extends Exception {
        public NegativeNumberException(String message) {
            super(message);
        }
    }

    // Main class with ProcessInput method
    public class NumberProcessor {
        public static void ProcessInput(int number) throws NegativeNumberException {
            if (number < 0) {
                throw new NegativeNumberException("Negative numbers are not allowed: " + number);
            } else {
                System.out.println("Double value of the entered number: " + (number * 2));
            }
        }
        public static void main(String[] args) {
            try {

                int inputNumber = -5; // Example input
                ProcessInput(inputNumber);
            } catch (NegativeNumberException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
    }