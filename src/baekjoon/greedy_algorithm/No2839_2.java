package baekjoon.greedy_algorithm;

import java.util.Scanner;

public class No2839_2 {
    //2839번 : 설탕 배달
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 0;
        int x = n%5;
        //3 6 9 12 15 18 21 24 27 30
        //12 이상은 모두 가능
        if(n==4 || n==7)
            System.out.println(-1);
        else if(n%5==0)
            System.out.println(n/5);
        else if(n%5==1 || n%5==3) // 1 -> 5 1개 빼고 3 두개+ / 3 -> 5 그대로, 3하나+
            System.out.println(n/5+1);
        else if(n%5==2 || n%5==4) // 2 -> 5 2개 빼고 3 4개+ / 4 -> 5 1개 빼고, 3 3개+
            System.out.println(n/5+2);
    }
}
