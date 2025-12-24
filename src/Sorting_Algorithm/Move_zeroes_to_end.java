package Sorting_Algorithm;

import java.util.Scanner;

public class Move_zeroes_to_end {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void moveZeroes(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(arr[j-1] == 0 && arr[j] != 0){
                    swap(arr, j-1, j);
                }
            }
        }
    }

    // Bubble sort algorithm...
    static void moveZeroes1(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < n-i-1; j++) {
                if(arr[j] == 0 && arr[j+1] != 0){
                    swap(arr, j, j+1);
                }
            }
        }
    }
    static void moveZeroes2(int[] arr){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        while(start<=end){
            if(arr[start] == 0){
                swap(arr,start,end);
                end--;
            }
            else{
                start++;
            }
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
        printArray(arr);
//        moveZeroes(arr);
//        moveZeroes1(arr);
        moveZeroes2(arr);
        System.out.println("After moving zeroes");
        printArray(arr);
    }
}
