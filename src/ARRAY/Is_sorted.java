package ARRAY;
import java.util.Scanner;
public class Is_sorted {
    static void isSorted(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i + 1]) {
                flag = false;
            }
        }
        if (flag == true) {
            System.out.println("Is sorted");
        }
        else {
            System.out.println("Is not sorted");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        isSorted(arr);
    }
}
