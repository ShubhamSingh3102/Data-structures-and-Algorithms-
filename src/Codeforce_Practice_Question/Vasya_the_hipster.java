package Codeforce_Practice_Question;
import java.util.*;
public class Vasya_the_hipster {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the no of socks: ");
            int n = sc.nextInt();
            int m = sc.nextInt();
            int min = Math.min(n, m);
            int count = 0;
            while (n > 0 || m > 0) {
                n -= min;
                m -= min;

                while(n > 1 || m > 1){
                    if (n > 1) {
                        n -= 2;
                        count++;
                    } else if (m > 1) {
                        m -= 2;
                        count++;
                    }else{
                        break;
                    }
                }
            }
            System.out.println(min + " " + count);
        }
    }
}
