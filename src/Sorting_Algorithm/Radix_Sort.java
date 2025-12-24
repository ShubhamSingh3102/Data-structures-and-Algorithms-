package Sorting_Algorithm;

import java.util.Scanner;

public class Radix_Sort {
    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // finding maximum element present in the array....
    static int findMax(int[] arr){
        int mx = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > mx){
                mx = arr[i];
            }
        }
        return mx;
    }
    static void countSort(int[] arr,int place){
        int n = arr.length;
        int[] output = new int[n];
        
        // making frequency array or count array to find how many times the number present in the array occured....
        int[] count = new int[10];
        for(int i=0;i<arr.length;i++){ // arr[i] = 105, we have to do freq[5]++ if place = 1
            count[(arr[i]/place)%10]++;
        }
        // make prefix sum array of count array
        for(int i=1;i<count.length;i++){ // TC--> max times
            count[i]+=count[i-1]; 
        }
        // find the index of each element in the original array and put it in the output array....
        // traverse in the original aaray from back to maintain stability...

        for(int i=n-1;i>=0;i--){ // TC---> n times
            int idx = count[(arr[i]/place)%10]-1;
            output[idx] = arr[i];
            count[(arr[i]/place)%10]--;
        }

        // copy all elements of output to arr
        for(int i=0;i<n;i++){ // TC---> n times
            arr[i] = output[i];
        }
    }
    static void radixSort(int[] arr){
        int max = findMax(arr); // get maximum element
        // apply counting sort to sort elements based on place value....
        for(int place = 1; max/place > 0 ; place *= 10){
            countSort(arr,place);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Original array is:");
        printArray(arr);

        radixSort(arr);
        System.out.println("The sorted array is:");
        printArray(arr);
    } 
}
