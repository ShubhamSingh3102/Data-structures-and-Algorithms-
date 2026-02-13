package Stacks;
import java.util.*;
public class Baseball_Game {
    public static int calPoints(String[] operations){
        Stack<Integer> s = new Stack<>();
        int n = operations.length;
        for(int i=0;i<n;i++){
            if(operations[i].equals("C")){
                s.pop();
            }
            else if(operations[i].equals("D")){
                int num = s.peek();
                num = num * 2;
                s.push(num);
            }
            else if(operations[i].equals("+")){
                int top = s.pop();
                int newTop = top + s.peek();
                s.push(top);
                s.push(newTop);
            }
            else{
                s.push((Integer.parseInt(operations[i])));
            }
        }
        int totalSum = 0;
        while(!s.isEmpty()){
            int sum = s.pop();
            totalSum += sum;
        }
        return totalSum;
    }
    public static void main(String[] args) {
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(ops));
    }
}
