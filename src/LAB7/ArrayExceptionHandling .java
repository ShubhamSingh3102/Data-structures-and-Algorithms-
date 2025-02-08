package LAB7;
    class ArrayExceptionHandling  {
        public static void main(String[] args) {
            try {
                // Creating an array of size 5
                int[] numbers = {1, 2, 3, 4, 5};

                // Attempting to access an out-of-bounds index
                System.out.println("Accessing element at index 10: " + numbers[10]);
            } catch (ArrayIndexOutOfBoundsException e) {
                // Handling the exception
                System.out.println("Exception caught: Attempted to access an invalid array index...");
                System.out.println("Error Message: " + e.getMessage());
            }

            System.out.println("Program execution continues normally after handling exception...");
        }
    }
    