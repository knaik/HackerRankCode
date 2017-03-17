import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int arSize = scan.nextInt();
        
        int[] elements = new int[arSize];
        int[] weights = new int[arSize];
        float weightsum = 0;
        float meansum = 0;
        
        for (int i = 0; i < arSize; i++){
            elements[i] = scan.nextInt();
        }
         
        for (int i = 0; i < arSize; i++){
            weights[i] = scan.nextInt();
            weightsum += weights[i];
        }
        
        for (int i = 0; i < arSize; i++){
            meansum = (elements[i] * weights[i]) + meansum;
        }
        
        float weightedmean = meansum/weightsum;
        
        System.out.println(round(weightedmean,1));
        
    }
    
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}