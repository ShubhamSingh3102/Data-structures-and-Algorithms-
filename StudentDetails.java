import java.io.*;
import java.util.*;

public class StudentDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "student_details.txt";

        try (FileWriter writer = new FileWriter(fileName, true)) {
            System.out.print("Enter Student Roll No: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Subject: ");
            String subject = scanner.nextLine();

            System.out.print("Enter Marks: ");
            int marks = scanner.nextInt();

            String studentData = rollNo + ", " + name + ", " + subject + ", " + marks + "\n";
            writer.write(studentData);
            System.out.println("Student details saved successfully!\n");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Reading from file:");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
