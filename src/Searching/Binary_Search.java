package Searching;
import java.util.*;
public class Binary_Search {
//    public static void printArray(int [] arr){
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }
//        System.out.println();
//    }



    // Time complexity of iterative method of binary search is : O(log n)
    // Space complexity of iterative method of binary search is : O(1)
    static boolean BinarySearch(int target,int[] arr){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }


    // Time complexity of recursive method of binary search is : O(log n)
    // Space complexity of recursive method of binary search is : O(log n)
    static boolean RecursiveBS(int target,int low,int high,int[] arr){
        if(low>high){ // base case
            return false;
        }
//        int mid = (low+high)/2;
        int mid = low + (high-low)/2;
        if(arr[mid] == target){
            return true;
        }
        else if(arr[mid] > target){
            return RecursiveBS(target,low,mid-1,arr);
        }
        else{
            return RecursiveBS(target,mid+1,high,arr);
        }
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
        System.out.println("Enter the value of target");
        int target = sc.nextInt();


        System.out.println(BinarySearch(target,arr));

        System.out.println(RecursiveBS(target,0,n-1,arr));
    }
}
