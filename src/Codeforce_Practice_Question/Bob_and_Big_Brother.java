package Codeforce_Practice_Question;
import java.util.*;
public class Bob_and_Big_Brother {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the weights of bob and his brother");
            int a = sc.nextInt();
            int b = sc.nextInt();

            int countYrs = 0;
            while(a <= b){
                a=a*3;
                b=b*2;
                countYrs++;
            }
            System.out.println(countYrs);
        }
    }
}
