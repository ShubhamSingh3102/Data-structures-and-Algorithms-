package Codeforce_Practice_Question;
import java.util.*;
public class Anton_and_Danik {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the numbers of games played: ");
            int n = sc.nextInt();
            System.out.print("Enter the string: ");
            String str = sc.next();
            int len = str.length();
            int countA=0;
            int countD=0;
            for(int i = 0;i < len;i++){
                if(str.charAt(i) == 'A'){
                    countA++;
                }
                else{
                    if(str.charAt(i) == 'D'){
                        countD++;
                    }
                }
            }
            if(countA > countD){
                System.out.println("Anton");
            }
            else if(countA < countD){
                System.out.println("Danik");
            }
            else {
                System.out.println("Friendship");
            }
        }
    }
}
