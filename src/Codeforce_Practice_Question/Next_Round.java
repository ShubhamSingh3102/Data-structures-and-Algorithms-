package Codeforce_Practice_Question;
import java.util.*;import java.util.*;
public class Next_Round {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the value of n and k");
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] score = new int[n];
            for(int i=0;i<n;i++){
                score[i] = sc.nextInt();
            }
            int threshold = score[k-1];
            int count = 0;
            for(int i=0;i<n;i++){
                if(score[i] >= threshold && score[i]>0){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
