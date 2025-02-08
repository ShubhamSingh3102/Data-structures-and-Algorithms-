package LAB7;
import java.util.Scanner;
    // User-defined exception for invalid hours
    class HrsException extends Exception {
        public HrsException(String message) {
            super(message);
        }
    }
    // User-defined exception for invalid minutes
    class MinException extends Exception {
        public MinException(String message) {
            super(message);
        }
    }
    // User-defined exception for invalid seconds
    class SecException extends Exception {
        public SecException(String message) {
            super(message);
        }
    }
// Time class to handle user input and validate time values
    class Time {
        private int hours, minutes, seconds;

        public void setTime(int h, int m, int s) throws HrsException, MinException, SecException {
            if (h < 0 || h > 24) {
                throw new HrsException("Invalid Hours: " + h + " (Must be between 0 and 24)");
            }
            if (m < 0 || m > 60) {
                throw new MinException("Invalid Minutes: " + m + " (Must be between 0 and 60)");
            }
            if (s < 0 || s > 60) {
                throw new SecException("Invalid Seconds: " + s + " (Must be between 0 and 60)");
            }

            this.hours = h;
            this.minutes = m;
            this.seconds = s;
        }

        public void displayTime() {
            System.out.println("Time: " + hours + ":" + minutes + ":" + seconds);
        }
    }
    // Main class to test the exception handling
    public class TimeValidation {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Time time = new Time();

            try {
                System.out.print("Enter hours: ");
                int h = scanner.nextInt();
                System.out.print("Enter minutes: ");
                int m = scanner.nextInt();
                System.out.print("Enter seconds: ");
                int s = scanner.nextInt();

                time.setTime(h, m, s);
                time.displayTime();
            } catch (HrsException | MinException | SecException e) {
                System.out.println("Exception caught: " + e.getMessage());
            } finally {
                scanner.close();
            }
        }
    }