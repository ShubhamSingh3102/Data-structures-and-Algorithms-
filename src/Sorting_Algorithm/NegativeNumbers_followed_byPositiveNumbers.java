package Sorting_Algorithm;

public class NegativeNumbers_followed_byPositiveNumbers {
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
//    static void nn_followedby_pn(int[] arr){
//        int count = 0;
//        int count1 = 0;
//        int n = arr.length;
//        int l=0;
//        int r=arr.length-1;
//        while(l<r){
//            while(arr[l]<0){
//                l++;
//                count++;
//            }
//            while(arr[r]>=0){
//                r--;
//                count1++;
//            }
//            if(l<r){
//                int temp = arr[l];
//                arr[l] = arr[r];
//                arr[r] = temp;
//                l++;
//                r--;
//            }
//        }
//    }

    static void maximum(int[] arr){
        int n = arr.length;
        int count = 0;
        int count1 = 0;
        int l = 0;
        int r = n-1;
        while(l<=r){
            if(arr[l]>0){
                // positive
                count++;
            }
            else{
                count1++;
            }
        }
        if(count>count1){
            int max = count;
            System.out.println("Maximum is "+max);
        }
        else{
            int max = count1;
            System.out.println("Maximum is "+max);
        }
    }
    public static void main(String[] args) {
        int[] arr={19,-20,7,-4,-13,0,11,-5,3};
//        nn_followedby_pn(arr);
        maximum(arr);
        System.out.println("Output is");
        printArray(arr);
    }
}
