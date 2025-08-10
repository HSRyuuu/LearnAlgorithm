package BaekJoon.silver.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제명: 설탕 배달
 * Tear: S4
 */
public class No2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int goal = Integer.parseInt(br.readLine());


        final int BAG_THREE = 3;
        final int BAG_FIVE = 5;

        int countThree = 0;
        int countFive = goal / BAG_FIVE;

        while(countFive >= 0){
            int remain = goal - countFive * BAG_FIVE;
            if(remain % BAG_THREE == 0){
                countThree = remain / 3;
                System.out.println(countThree + countFive);
                return;
            }
            countFive--;
        }



        System.out.println(-1);


    }
}
