package CodingTest.greedy_algorithm;

import java.util.Scanner;

public class No2839 {
    //2839번 : 설탕 배달
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 0;

        int x = n%5;
        //3 6 9 12 15 18 21 24 27 30
        switch(x){
            case 0: break;

            case 1: {
                if (n < 6) {
                    myExit();
                } else {
                    n -= 6;
                    ans += 2;
                }
                break;
            }
            case 2:  {
                if(n<12){
                    myExit();
                } else{
                    n-=12;
                    ans+=4;
                }
                break;
            }
            case 3: {
                if (n < 3) {
                    myExit();
                }else{
                    n-=3;
                    ans+=1;
                }
                break;
            }
            case 4:{
                if (n < 9) {
                    myExit();
                }else{
                    n-=9;
                    ans+=3;
                }
                break;
            }
        }
        ans+=n/5;
        System.out.println(ans);
    }
    static void myExit(){
        System.out.println(-1);
        System.exit(0);
    }
}
