package CodingTest.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * package : CodingTest.string
 * class name : No1254.java
 * date : 2023-07-03 오후 11:26
 * info : 펠린드롬 만들기 / silver 1 / 브루트포스
 * link : https://www.acmicpc.net/problem/1254
 */
public class No1254{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String str = br.readLine();
        int ans = str.length();
        for (int i = 0; i < str.length(); i++) {
            if(isPalindrome(str.substring(i))){
                break;
            }
            ans++;
        }
        System.out.println(ans);
    }
    static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left++) != str.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
