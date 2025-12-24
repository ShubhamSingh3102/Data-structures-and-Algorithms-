package Codeforce_Practice_Question;
import java.util.*;
public class Vanya_and_Fence {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of friends: ");
            int a = sc.nextInt();
            System.out.print("Enter the height of the fence: ");
            int f = sc.nextInt();
            int width = 0;
            for(int i=0;i<a;i++){ // height of the friends...
                int height = sc.nextInt();
                if(height > f){
                    width += 2;
                }
                else{
                    width += 1;
                }
            }
            System.out.println(width);
        }
    }
}
