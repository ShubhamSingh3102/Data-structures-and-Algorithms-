package Searching;
import java.util.Arrays;
import java.util.Scanner;
public class Mountain_Peak_Index {
    public static int peakIndexInMountainIndex(int[] arr){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] < arr[mid+1]){ // going upwards
                ans = mid+1;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = peakIndexInMountainIndex(arr);
        System.out.println(result);
    }
}
