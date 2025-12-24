package ARRAY;
import java.util.Scanner;
public class Largest_element {
    static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int Largest_element(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the size of the array : ");
            int n = sc.nextInt();
            int[] arr = new int[n];
            System.out.println("Enter elements of array: ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            printArray(arr);
            int ans = Largest_element(arr);
            System.out.println("The largest element is : "+ans);
    }
}
