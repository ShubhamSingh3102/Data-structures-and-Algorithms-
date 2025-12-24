package Searching;
import java.util.Scanner;
public class Peak_Element {
    public static int peakElement(int[] arr){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(( mid == 0 || arr[mid] > arr[mid-1]) && ( mid == n-1 || arr[mid] > arr[mid+1])){
                return mid;
            }
            else if(arr[mid+1] > arr[mid]){ // mid is on uphill....
                start = mid+1;
            }
            else{ // mid is on downhill......
                end = mid-1;
            }
        }
        return -1;
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
        int result = peakElement(arr);
        System.out.println(result);
    }
}
