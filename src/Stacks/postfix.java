package Stacks;
import java.util.Stack;
public class postfix {
    public static int eval(String str){
        Stack<Integer> val = new Stack<>();
        int n = str.length();
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii>=48 && ascii<=57){
                val.push(ascii-48);
            }
            else{ // operator...
                int v2 = val.pop();
                int v1 = val.pop();
                if(ch=='+' ){
                    val.push(v1+v2);
                }
                if(ch=='-'){
                    val.push(v1-v2);
                }
                if(ch=='*'){
                    val.push(v1*v2);
                }
                if(ch=='/'){
                    val.push(v1/v2);
                }
            }
        }
        return val.peek();
    }
    public static void main(String[] args) {
        String str = "953+4*6/-";
        System.out.println(eval(str));
    }
}
