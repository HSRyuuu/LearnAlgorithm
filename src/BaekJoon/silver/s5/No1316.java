package BaekJoon.silver.s5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 문제명: 그룹 단어 체커
 * Tear: S5
 */
public class No1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));


        int numberOfWords = Integer.parseInt(br.readLine()); // 단어 개수

        int count = 0;

        for(int i = 0; i< numberOfWords; i++) {
            String str = br.readLine();
            if(isGroupWord(str)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isGroupWord(String word){
        Set<Character> characterSet = new HashSet<>();

        char[] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char cur = chars[i];
            if(i == 0){
                characterSet.add(cur);
                continue;
            }
            boolean add = characterSet.add(cur);

            if(cur != chars[i-1] && !add){
                return false;
            }
        }
        return true;
    }
}
