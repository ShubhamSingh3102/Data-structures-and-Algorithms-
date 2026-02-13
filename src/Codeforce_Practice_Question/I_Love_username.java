package Codeforce_Practice_Question;
import java.util.*;
public class I_Love_username {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the no of contests he participated: ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int best = arr[0];
            int worst = arr[0];
            int count = 0;

            for(int i=0;i<n;i++){
                if(arr[i] > best){
                    best = arr[i];
                    count++;
                }
                if(arr[i] < worst){
                    worst = arr[i];
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
