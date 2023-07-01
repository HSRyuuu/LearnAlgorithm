package Practice.다이나믹프로그래밍_DP;

/**
 * 타뷸레이션 = 바텀 업 방식
 */
public class DP_Bottom_up {
    //타뷸레이션(바텀 업) 방식으로 풀이
    public static void main(String[] args) {
        //피보나치 수열
        int n = 7;
        System.out.println(fibonacci(n));
    }
    public static int fibonacci(int n) {
        int[] DP = new int[n < 2 ? 2 : n+1];
        DP[1] = 1;
        DP[2] = 1;

        for (int i = 3; i <= n; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }
        return DP[n];
    }
}
