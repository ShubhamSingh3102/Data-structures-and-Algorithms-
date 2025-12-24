package Codeforce_Practice_Question;
import java.util.*;
public class Happy_Number {
    public static boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sqSum(slow);
            fast = sqSum(sqSum(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private static int sqSum(int n) {
        int s = 0;
        while (n > 0) {
            int dig = n % 10;
            s += dig * dig;
            n /= 10;
        }
        return s;
    }
//    public class Happy_Number {
//        public static boolean isHappy(int n){
//            Set<Integer> seen = new HashSet<>();
//
//            while(n != 1 && !seen.contains(n)){
//                seen.add(n);
//                int sum = 0;
//                while(n > 0){
//                    int digit = n % 10;
//                    sum += digit * digit;
//                    n /= 10;
//                }
//                n = sum;
//            }
//            return n == 1;
//        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        boolean ans = isHappy(n);
        System.out.println(ans);
    }
}
