package Practice.다이나믹프로그래밍_DP;

/**
 * 타뷸레이션 = 바텀 업 방식
 */
public class DP_타뷸레이션 {
    //타뷸레이션 방식으로 풀이
    public static int fibonacci(int n) {
        int[] dpTable = new int[n < 2 ? 2 : n+1];
        dpTable[0] = 0;
        dpTable[1] = 1;

        for (int i = 1; i <= n; i++) {
            dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
        }
        return dpTable[n];
    }
    public static void main(String[] args) {
        //피보나치 수열
        int n = 7;
        System.out.println(fibonacci(n));
    }
}
