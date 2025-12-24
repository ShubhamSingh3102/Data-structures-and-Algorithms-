package Sorting_Algorithm;

public class Sort_zeroes_ones_twos_using_3pointers {
    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    static void sort012Arr(int[] arr){
        int n = arr.length;
        int low = 0, mid = 0, high = n-1;

        // explore the unknown regions....
        while(mid<=high){ // linear time complexity and constant space complexity....
            if(arr[mid] == 0){
                swap(arr, mid, low);
                mid++;
                low++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr, mid, high);
                high--;
            }
        }
    }
    public static void main(String[] args) {
        // int[] arr = {0,2,1,2,0,0};
        int[] arr = {2,2,0,0,1,1,2,0,1,0};
        sort012Arr(arr);
        System.out.println("The sorted array is:");
        printArray(arr);
    }
}
