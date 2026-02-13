package Codeforce_Practice_Question;
import java.util.*;
public class New_Year_and_Hurry {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of problems: ");
            int n = sc.nextInt();
            System.out.print("Enter the time Limak needs to go to his friend house: ");
            int k = sc.nextInt();
            int timeLeft = 240 - k;
            int count = 0;
            int timeUsed = 0;
            for(int i = 1;i <= n; i++){
                timeUsed += 5*i;
                if(timeUsed <= timeLeft){
                    count++;
                }
                else{
                    break;
                }
            }
            System.out.println(count);
        }
    }
}
