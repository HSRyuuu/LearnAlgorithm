package CodingTest.greedy_algorithm.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * package : CodingTest.greedy_algorithm.gold
 * class name : No1339.java
 * date : 2023-06-25 오후 7:29
 * note : 단어 수학 / gold 4 / 그리디
 */
public class No1339{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int len = str.length();
            int val = (int)Math.pow(10,len-1); //자릿수

            for (int j = 0; j < len; j++) {
                char ch = str.charAt(j);
                alphabet[ch-'A'] += val; //자릿수를 더해줌
                val /= 10;
            }
        }
        Arrays.sort(alphabet);

        int sum = 0;
        int value = 9;
        for (int i = alphabet.length - 1; i >= 0 ; i--) {
            if(alphabet[i] == 0){
                break;
            }
            sum += alphabet[i]*value; //가장 큰 수부터 자릿수 x 9, 8, 7...0
            value--;
        }
        System.out.println(sum);
    }
}
