package Sorting_Algorithm;
import java.util.Scanner;
public class Quick_sort {
    static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int Partition(int[] arr, int low, int high)
    {
    int pivot = arr[low];
    int i = low + 1;
    int j = high;
    int temp;
    do
    {
        while (i<=high && arr[i] <= pivot) // pivot se baara element chahiye
        {
            i++;
        }
        while (j>=low && arr[j] > pivot) // pivot se chota element chahiye
        {
            j--;
        }

        if (i < j)
        {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    } while (i < j);

    //Swapping arr[low] with arr[j]
    temp = arr[low];
    arr[low] = arr[j];
    arr[j] = temp;
    return j;
}
static void QuickSort(int []arr, int low, int high)
{
    int PartitionIndex; // Index of pivot after partition
    if (low < high)
    {
        PartitionIndex = Partition(arr, low, high);
        // printArray(arr,5);
        QuickSort(arr, low, PartitionIndex - 1);  // Quick sort for left subarray
        QuickSort(arr, PartitionIndex + 1, high); // Quick sort for right subarray
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

        QuickSort(arr, 0, n-1);
        System.out.println("The sorted array is:");
        printArray(arr);
    } 
}
