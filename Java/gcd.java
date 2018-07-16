import java.util.*;

public Class hw1{
    
    public static void main(String[] args){
        String first = "10^44 + 1";
        String second = "-1 + 10^44";
        long f_num = numerize(first);
        long s_num = numerize(second);
        long gcd = gcd(f_num, s_num);
    }
    
    long numerize(String num){
        String x = num;
        long num = 0;
        
        for (int i = 0; i < num.length; i++){
            if (num.charAt(i) == '^'){
                
            }
        }
        
    }
    
    long gcd(long num1, long num2);
}