package CodingTest.greedy_algorithm.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * package : CodingTest.greedy_algorithm
 * class name : No2839.java
 * date : 2023-06-25 오후 1:35
 * note : 설탕 배달 / silver 4 / 그리디
 */
public class No2839{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());

        int five = n/5;
        int three = 0;

        boolean isPossible = false;
        while(five >= 0){

            int remain = n - five*5;
            if(remain % 3 == 0){
                three = remain/3;
                isPossible = true;
                break;
            }
            five--;
        }
        if(!isPossible){
            System.out.println(-1);
        }else{
            System.out.println(five + three);
        }


    }
}
