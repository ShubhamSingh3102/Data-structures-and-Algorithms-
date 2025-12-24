package Strings;
import java.util.*;
import java.lang.*;
import java.nio.channels.ScatteringByteChannel;
public class CustomStringBuilder {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("hello");
        str.append("world");
        System.out.println(str);


        // // hello --> mello
        // str.setCharAt(0, 'm');
        // System.out.println(str);

        // // append
        // str.append(" world");
        // System.out.println(str);


        // // insert
        // str.insert(2,'y');
        // System.out.println(str);


        // // delete
        // str.deleteCharAt(0);
        // System.out.println(str);


        // reverse
        StringBuilder gtr = new StringBuilder("physics");
        System.out.println(gtr);
        gtr.reverse();
        System.out.println(gtr);
        gtr.reverse();
        System.out.println(gtr);

        // delete
        gtr.delete(2, 4); // 2 to 3 delete ho jaega....
        System.out.println(gtr);
    }
}
