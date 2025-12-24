package Sorting_Algorithm;
import java.util.Scanner;
public class Count_Sort {
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

    // Here stability property is not maintained....

    static void basicCountSort(int[] arr){ // 2 4 2 2
        // Find the largest element present in the array...
        int max = findMax(arr);
        
        // making frequency array or count array to find how many times the number present in the array occured....
        int[] count = new int[max+1];
        for(int i=0;i<arr.length;i++){

            /*
                    0 0 3 0 1
                    0 1 2 3 4
             */
            count[arr[i]]++;
        }
        int k = 0;
        for(int i=0;i<count.length;i++){
            for(int j=0;j<count[i];j++){
                arr[k++] = i;
            }
        }
    }
    static void countSort(int[] arr){
        int n = arr.length;
        int[] output = new int[n];
        // Find the largest element present in the array...
        int max = findMax(arr);
        
        // making frequency array or count array to find how many times the number present in the array occured....
        int[] count = new int[max+1];
        for(int i=0;i<arr.length;i++){ // TC---> n times

            /*
                    0 0 3 0 1
                    0 1 2 3 4
             */
            count[arr[i]]++;
        }
        // make prefix sum array of count array
        for(int i=1;i<count.length;i++){ // TC--> max times
            count[i]+=count[i-1]; 
        }
        // find the index of each element in the original array and put it in the output array....
        // traverse in the original aaray from back to maintain stability...
        for(int i=n-1;i>=0;i--){ // TC---> n times
            int idx = count[arr[i]]-1;
            output[idx] = arr[i];
            count[arr[i]]--;
        }
        // copy all elements of output to arr
        for(int i=0;i<n;i++){ // TC---> n times
            arr[i] = output[i];
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

        // basicCountSort(arr);
        countSort(arr);
        System.out.println("The sorted array is:");
        printArray(arr);
    } 
}
