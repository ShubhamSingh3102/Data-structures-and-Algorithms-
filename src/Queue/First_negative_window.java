package Queue;
import java.util.*;
public class First_negative_window {
    public static long[] firstNegative(int[] arr,int k){
        Queue<Integer> q = new LinkedList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){ // adding -ve value indices to queue...
            if(arr[i]<0){ // if negative
                q.add(i); // adding index
            }
        }
        long[] res = new long[n-k+1];
        for(int i=0;i<n-k+1;i++){
            // ye compulsory h check krna....
            if(!q.isEmpty() && q.peek() < i){
                q.remove();
            }

            if(!q.isEmpty() && q.peek() <= i+k-1){
                res[i] = arr[q.peek()];
            }
            else if(q.isEmpty()){
                res[i] = 0;
            }
            else{
                res[i] = 0;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {12,-1,-7,8,-15,30,16,28};
        System.out.println("Enter the size of window : ");
        int k = sc.nextInt();
        long[] res = firstNegative(arr,k);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
    }
}
