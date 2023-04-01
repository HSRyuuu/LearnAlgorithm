package brute_force.no1436_영화감독숌;

import java.util.Scanner;

public class no1436 {
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
