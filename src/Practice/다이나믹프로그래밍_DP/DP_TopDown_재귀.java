package Practice.다이나믹프로그래밍_DP;


public class DP_TopDown_재귀 {
    static int[] DP;

    public static void main(String[] args) {
        //피보나치 수열
        int n = 7;
        DP = new int[n + 1];
        for (int i = 0; i < DP.length; i++) {
            DP[i] = -1;
        }
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n){
        if(n <= 2){
            return 1;
        }
        if(DP[n] != -1){
            return DP[n];
        }
        DP[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return DP[n];
    }
}
