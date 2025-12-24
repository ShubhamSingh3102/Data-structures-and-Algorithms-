package Codeforce_Practice_Question;
import java.util.*;
public class Nearly_Lucky_Number {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number: ");
            long n = sc.nextLong();
            int count = 0;
            long dig;
            while(n > 0){
                dig = n % 10;
                if (dig == 4 || dig == 7) {
                    count++;
                }
                n = n / 10;
            }
            if(count == 4 || count == 7){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
