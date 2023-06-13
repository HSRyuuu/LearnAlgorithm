package CodingTest.search.DFS;

import java.util.Scanner;

public class No2023 {
    // 2023번 : 신기한 소수
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //한자리 수가 소수인 경우는 2,3,5,7 가 있다.
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);

        System.out.println(sb);
    }
    static void DFS(int num, int digit){
        if(digit == n){
            if(isPrime(num)){
                sb.append(num).append("\n");
                return;
            }
        }
        for(int i=1;i<=9;i+=2){
            if(isPrime(num*10+i)){
                DFS(num*10+i,digit+1);
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
