package ARRAY;
import java.util.Scanner;
public class Second_Largest_Element {
    static int Second_Largest_Element(int[] arr) {
        int n = arr.length;
        int largest = -1;
        int secondLargest = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
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
        int secondLargest = Second_Largest_Element(arr);
        System.out.println("The second largest element is : " + secondLargest);
    }
}
