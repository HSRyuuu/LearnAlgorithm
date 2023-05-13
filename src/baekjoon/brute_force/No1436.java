package baekjoon.brute_force;

import java.util.Scanner;

public class No1436 {
    // 1436번 : 영화감독 숌
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int result = 0;
        int num = 666;

        while(result<n){
            if(Integer.toString(num).contains("666")){
                result++;
            }
            num++;
        }
        System.out.println(num-1);
    }
}
