package Bit_Manipulation;
import java.util.*;
public class Binary_Watch {
    public static List<String> readBinaryWatch(int turnedOn){
        List<String> result = new ArrayList<>();

        for(int hh = 0; hh <= 11; hh++){
            for(int mm = 0; mm <= 59; mm++){

                if(Integer.bitCount(hh) + Integer.bitCount(mm) == turnedOn) {
                    String hour = String.valueOf(hh);
                    String minute = (mm < 10 ? "0" : "") + mm;
                    result.add(hour + ":" + minute);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int turnedOn = 1;
        System.out.println(readBinaryWatch(turnedOn));
    }
}
