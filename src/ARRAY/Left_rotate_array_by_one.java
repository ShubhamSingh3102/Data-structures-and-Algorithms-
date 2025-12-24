package ARRAY;
import java.util.Scanner;
public class Left_rotate_array_by_one {
    static void printArray(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
//    static void LeftRotate(int[] arr, int k) {
//        int n = arr.length;
//        for(int i = 0; i < k; i++) {
//            int first = arr[0];
//            for(int j = 0; j < n-1; j++) {
//                arr[j] = arr[j+1];
//            }
//            arr[n-1] = first;
//        }
//    }
static void LeftRotate_by_K(int[] arr, int k) {
    int n = arr.length;
    for(int i = 0; i < k; i++) {
        int first = arr[0];
        for(int j = 0; j < n-1; j++) {
            arr[j] = arr[j+1];
        }
        arr[n-1] = first;
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k = sc.nextInt();
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        LeftRotate_by_K(arr, k);
        printArray(arr);
    }
}
