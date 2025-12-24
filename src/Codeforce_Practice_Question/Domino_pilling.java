package Codeforce_Practice_Question;
import java.util.*;
public class Domino_pilling {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the value of m and n");
            int m = sc.nextInt();
            int n = sc.nextInt();
            int maxNumOfDomino = (m*n)/2;
            System.out.println(maxNumOfDomino);
        }
    }
}
