package LAB6;
    abstract class Student {
        int rollNo;
        long regNo;

        // Method to take input
        void getInput(int rollNo, long regNo) {
            this.rollNo = rollNo;
            this.regNo = regNo;
        }

        // Abstract method
        abstract void course();
    }

    class Kiitian extends Student {

        void course() {
            System.out.println("Course - B.Tech. (Computer Science & Engg)");
        }

        // Method to display details
        void displayDetails() {
            System.out.println("Rollno - " + rollNo);
            System.out.println("Registration no - " + regNo);
            course();
        }
    }

    // Driver class
    public class Question1 {
    public static void main(String[] args) {
        Kiitian student = new Kiitian();
        student.getInput(23051198, 12345678900L);
        student.getInput(23051219, 12345678901L);
        student.displayDetails();
    }
}