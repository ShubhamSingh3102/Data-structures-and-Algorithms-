package Sorting_Algorithm;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

public class Bucket_Sort {
    static void printArray(float[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    static void bucketSort(float[] arr){
        int n = arr.length;
        // making buckets ---> 2-D type of structure....
        // array list ka array banana hai....
        ArrayList<Float>[] buckets = new ArrayList[n];

        // Create empty buckets...
        for(int i =0;i<n;i++){
            buckets[i] = new ArrayList<Float>();
        }

        // Add elements into our buckets....
        for(int i=0;i<n;i++){
            int bucketIndex = (int) arr[i]*n;
            buckets[bucketIndex].add(arr[i]);
        }

        // Sorting each bucket individually.....
        for(int i = 0; i < buckets.length; i++){
            Collections.sort(buckets[i]);
        }

        // Merge all buckets to get final sorted array...
        int index = 0;
        for(int i=0;i<buckets.length;i++){
            ArrayList<Float> currBucket = buckets[i];
            for(int j=0;j<currBucket.size();j++){
                arr[index++] = currBucket.get(j);
            }
        }
    }
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the size of the array");
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // System.out.println("Enter the elements of the array");
        // for (int i = 0; i < n; i++) {
        //     arr[i] = sc.nextInt();
        // }
        float[] arr = {0.5f,0.4f,0.3f,0.2f,0.1f};
        System.out.println("Original array is:");
        printArray(arr);

        bucketSort(arr);
        System.out.println("The sorted array is:");
        printArray(arr);
    } 
}
