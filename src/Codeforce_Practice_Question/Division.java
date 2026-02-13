package Codeforce_Practice_Question;
import java.util.*;
public class Division {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the test cases: ");
            int n = sc.nextInt();
            int p;
            for(int i=0;i<n;i++){
                p = sc.nextInt();

                if (p >= 1900) System.out.println("Division 1");
                else if (p >= 1600) System.out.println("Division 2");
                else if (p >= 1400) System.out.println("Division 3");
                else System.out.println("Division 4");
            }
        }
    }
}
