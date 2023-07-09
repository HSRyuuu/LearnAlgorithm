package CodingTest.back_tracking;

import java.util.Scanner;

/**
 * package : CodingTest.back_tracking
 * class name : No2023.java
 * date : 2023-07-09 오후 1:59
 * info : 신기한 소수 / gold 5 / 백트래킹
 * link : https://www.acmicpc.net/problem/2023
 */
public class No2023 {
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //한자리 수가 소수인 경우는 2,3,5,7 가 있다.
        backTracking(2,1);
        backTracking(3,1);
        backTracking(5,1);
        backTracking(7,1);

        System.out.println(sb);
    }
    static void backTracking(int num, int digit){
        if(digit == n){
            if(isPrime(num)){
                sb.append(num).append("\n");
                return;
            }
        }
        for(int i=1;i<=9;i+=2){
            if(isPrime(num*10+i)){
                backTracking(num*10+i,digit+1);
            }
        }
    }
    static boolean isPrime(int number){
        for(int i=2;i<=(int)Math.sqrt(number);i++){
            if(number%i == 0)return false;
        }
        return true;
    }
}
