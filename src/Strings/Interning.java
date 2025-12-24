package Strings;
public class Interning {
    public static void main(String[] args) {
        String s = "Hello";
        String x = "Hello";
        x = "Mello";
        System.out.println(s); // strings are immutable...
        System.out.println(x); 


        
        // System.out.println(s.replace('l', 'y')); This is the way of replacing string 

        
        //s.charAt(0) = 'q'; // strings are immutable....

        // change Hello to Heylo....
        s = s.substring(0,2) + 'y' + s.substring(3);
        System.out.println(s);
    }
}
