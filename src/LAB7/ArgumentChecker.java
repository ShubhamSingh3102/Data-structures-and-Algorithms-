package LAB7;
// User-defined exception for checking command-line arguments
class CheckArgument extends Exception {
    public CheckArgument(String message) {
        super(message);
    }
}

// Main class to validate arguments and calculate sum of squares
public class ArgumentChecker {
    public static void main(String[] args) {
        try {
            // Checking if the number of arguments is less than 4
            if (args.length < 4) {
                throw new CheckArgument("Insufficient arguments. Please provide at least 4 numbers.");
            }

            int sumOfSquares = 0;
            for (int i = 0; i < 4; i++) {
                try {
                    int num = Integer.parseInt(args[i]);
                    sumOfSquares += num * num;
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Invalid input: '" + args[i] + "' is not a valid integer.");
                }
            }

            System.out.println("Sum of squares of the first four numbers: " + sumOfSquares);
        } catch (CheckArgument e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println("Usage: Provide at least 4 integer arguments.");
        } catch (NumberFormatException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
