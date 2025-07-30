
import java.util.*;
public class SortingString2 {
    void func(){
        
        String str = "UNIVERSITY";

        byte[] by = str.getBytes();

        for(int i = 0;i<by.length-1;i++){
            for(int j = 0;j<(by.length-1-i);j++){
                if(by[j] > by[j+1]){
                    byte temp  = by[j];
                    by[j] = by[j+1];
                    by[j+1] = temp;
                }
            }
        }
        System.out.println(str);
        System.out.println(" sorted in alphabatical order ");
        for(int i = 0;i<by.length;i++){
            System.out.print((char)by[i]);
        }
        System.out.println();
        System.out.println(" reverse order");
        for(int i = by.length-1;i>=0;i--){
            System.out.print((char)by[i]);
        }   
    }
    public static void main(String[] args) {
        SortingString2 obj = new SortingString2();
        obj.func();
    }
}
