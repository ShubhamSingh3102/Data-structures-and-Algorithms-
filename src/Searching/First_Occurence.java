package Searching;
import java.util.*;
public class First_Occurence {
    static int FirstOccurence(int[] arr,int x){
        int low = 0;
        int high = arr.length-1;
        int firstOcc = -1;
        while(low < high){
            int mid = low + (high-low)/2;
            if(x == arr[mid]){
                firstOcc = mid;
                high = mid-1; // left me search krna hai ki kahi usse phele bhi wo number exists krta hai kya...
            }
            else if(x < arr[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return firstOcc;
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
        System.out.println("Enter the value of x");
        int x = sc.nextInt();
        int result = FirstOccurence(arr,x);
        System.out.println("First Occurence of " +x+ " is " +result);
    }
}
