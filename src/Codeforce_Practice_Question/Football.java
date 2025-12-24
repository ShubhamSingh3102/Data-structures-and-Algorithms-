package Codeforce_Practice_Question;
import java.util.*;
public class Football {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the input: ");
            String str = sc.next();
            int len = str.length();
            int count = 1;
            for(int i=1;i<len;i++){
                if(str.charAt(i) == str.charAt(i-1)){
                    count++;
                }
                else{
                    count = 1;
                }
                if(count >= 7){
                    System.out.println("YES");
                    return;
                }
            }
            System.out.println("NO");
        }
    }
}
