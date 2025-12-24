package Searching;
import java.util.*;
public class Minimum_element_in_RotatedSorted_Array {
    static int Minimum_element(int[] arr){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] > arr[n-1]){
                // 1st sorted part me rahega mid....
                low = mid+1;
            }
            else if(arr[mid] <= arr[n-1]){
                // 2nd sorted part me hu....
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        System.out.println("Enter the value of elements");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int result = Minimum_element(arr);
        System.out.println("Index of Minimum element in rotated sorted is " +result);
    }
}
