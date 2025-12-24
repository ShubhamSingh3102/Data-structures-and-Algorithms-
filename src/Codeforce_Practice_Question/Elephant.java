package Codeforce_Practice_Question;
import java.util.*;
public class Elephant {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            int count = 0;
            for(int i=5;i>=1;i--){
                while (x>0){
                    x = x - i;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
