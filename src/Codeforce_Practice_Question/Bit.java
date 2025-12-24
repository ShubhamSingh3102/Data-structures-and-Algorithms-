package Codeforce_Practice_Question;
import java.util.*;import java.util.*;
public class Bit {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the value of n: ");
            int n = sc.nextInt();
            int X = 0;
            for(int i=0;i<n;i++){
                String operator = sc.next();
                if(operator.equals("X++") || operator.equals("++X")){
                    X++;
                }
                else if(operator.equals("X--") || operator.equals("--X")){
                    X--;
                }
            }
            System.out.println(X);
        }
    }
}
