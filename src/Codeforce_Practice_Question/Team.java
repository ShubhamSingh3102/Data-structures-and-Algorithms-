package Codeforce_Practice_Question;
import java.util.*;
public class Team {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number");
            int n = sc.nextInt();

            int count = 0;
            System.out.println("Enter the possibility");
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();

                if((a+b+c) >= 2){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
