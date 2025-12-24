package Searching;
import java.util.Scanner;
public class Duplicate_Target_In_RotatedSortedArray{

    // searching in duplicate element....
    static int search(int[] arr,int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target == arr[mid]) {
                return mid;
            }
            else if(arr[low] == arr[mid] && arr[high] == arr[mid]){
                // ignore the duplicate element...
                high--;
                low++;
            }
            else if(arr[mid] <= arr[high]){// mid to high is sorted....and if mid and end is equal to pivot does not lie in between means mid to end is sorted......
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            else{ // low to mid is sorted....
                if(target >= arr[low] && target < arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
        }
        return -1;
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
        System.out.println("Enter the target");
        int target = sc.nextInt();
        int result = search(arr,target);
        System.out.println("Element found at index " +result);
    }
}
