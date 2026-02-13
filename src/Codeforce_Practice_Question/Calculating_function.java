package Codeforce_Practice_Question;
import java.util.*;
public class Calculating_function {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number: ");
//            int n = sc.nextInt();
//            int sum = 0;
//            for(int i=1;i<=n;i++){
//                if(i%2 != 0){
//                    sum += -i;
//                }
//                else{
//                    sum += i;
//                }
//            }
//            System.out.println(sum);
//        }
//    }
            long n = sc.nextLong();

            if (n % 2 == 0)
                System.out.println(n / 2);
            else
                System.out.println(-(n + 1) / 2);
        }
    }
}
