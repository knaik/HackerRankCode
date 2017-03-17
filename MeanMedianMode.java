import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arSize = scan.nextInt();
        int[] data = new int[arSize];
        float sum = 0;
        
        for (int i = 0; i < arSize; i++){
            data[i] = scan.nextInt();
            //sum += data[i]; useful if you want to compute sum on first pass
        }
        
        Arrays.sort(data);
        
        System.out.println(mean(data));
        System.out.println(median(data));
        System.out.println(mode(data));
        
    }
    
    public static float mean(int[] data) {
        float sumInternal = 0; //IMPORTANT sum is float instead of int, as dividing by int will cause meanRaw to be floored
        for (int i = 0; i < data.length; i++){
            sumInternal += data[i];
        }
        float meanRaw = sumInternal/data.length;
        return (round(meanRaw,1));
        
    }

    public static float median(int[] data) {
        if (data.length%2 == 0) {
            float median1 = data[data.length/2 - 1];
            float median2 = data[data.length/2];
            float medianFinal = (median1 + median2) / 2;
            return (round(medianFinal, 1));
        }
        return (data[data.length/2]);   
    }

    public static int mode(int []array)
    {HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
    int max=1;
    int temp = array[0];
    for(int i=0;i<array.length;i++)
        {
            if(hash.get(array[i])!=null)
            {int count=hash.get(array[i]);
            count=count+1;
            hash.put(array[i],count);
            if(count>max)
                {max=count;
                 temp=array[i];}
            }
            else
            {hash.put(array[i],1);}
        }
        return temp;
    }
    
    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}