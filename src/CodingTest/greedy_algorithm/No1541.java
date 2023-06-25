package CodingTest.greedy_algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * package : CodingTest.greedy_algorithm
 * class name : No1541.java
 * date : 2023-06-25 오후 3:42
 * note : 잃어버린 괄호 / silver 2 / 그리디
 */
public class No1541{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String str = br.readLine();
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        int tmp = 0;
        boolean isMinus = false;
        for (char ch : str.toCharArray()){
            if(ch == '-'){
                if(isMinus){
                    tmp += Integer.parseInt(sb.toString());
                    sum += tmp * -1;
                    tmp = 0;
                }else{
                    sum += Integer.parseInt(sb.toString());
                }
                isMinus = true;
                sb.setLength(0);
            }else if(ch == '+'){
                if(isMinus){
                    tmp += Integer.parseInt(sb.toString());
                }else{
                    sum += Integer.parseInt(sb.toString());
                }
                sb.setLength(0);
            }else{
                sb.append(ch);
            }
        }
        if(isMinus){
            tmp += Integer.parseInt(sb.toString());
            sum += tmp * -1;
        }else{
            sum += Integer.parseInt(sb.toString());
        }
        System.out.println(sum);
    }
}
