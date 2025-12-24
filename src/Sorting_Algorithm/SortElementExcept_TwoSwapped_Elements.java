package Sorting_Algorithm;
public class SortElementExcept_TwoSwapped_Elements {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void sortArr(int[] arr){
        int n = arr.length;
        int x =-1, y=-1;

        // corner case , edge case
        if(n <= 1){
            return;
        }
        // process all adjacent elements...
        for(int i=1;i<n;i++){ // Time complexity---> linear---> O(n)
            if(arr[i-1] > arr[i]){
                if(x==-1){ // 1st conflict
                    x = i-1;
                    y = i;
                }
                else{ // 2nd conflict
                    y = i;
                }
            }
        }
        // swap x and y in arr
        int temp=arr[x];
        arr[x]=arr[y];
        arr[y]=temp;
    }
    public static void main(String[] args) {
        int[] arr = {10,5,6,7,8,9,3};
        sortArr(arr);
        System.out.println("The sorted array is:");
        printArray(arr);
    }
}