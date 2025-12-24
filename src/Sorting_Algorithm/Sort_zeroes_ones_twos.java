package Sorting_Algorithm;
public class Sort_zeroes_ones_twos {
    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    static void sort012Arr(int[] arr){
        int count_0 = 0,count_1=0,count_2=0;
        for(int j:arr){ // traversing the array....
            if(j==0){
                count_0++;
            }else if(j==1){
                count_1++;
            }else{
                count_2++;
            }
        }
        int k=0;
        while(count_0 > 0){
            arr[k++] = 0;
            count_0--;
        }
        while(count_1 > 0){
            arr[k++] = 1;
            count_1--;
        }
        while(count_2 > 0){
            arr[k++] = 2;
            count_2--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,2,1,2,0,0};
        sort012Arr(arr);
        System.out.println("The sorted array is:");
        printArray(arr);
    }
}
