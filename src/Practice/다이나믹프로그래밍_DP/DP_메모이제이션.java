package Practice.다이나믹프로그래밍_DP;

/**
 * 메모이제이션 = 탑-다운 방식
 */
public class DP_메모이제이션 {
    static int[] dpTable;
    public static int fibonacci(int n){
        if(n <= 2){
            return 1;
        }
        if(dpTable[n] != -1){
            return dpTable[n];
        }
        dpTable[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return dpTable[n];
    }
    public static void main(String[] args) {
        //피보나치 수열
        int n = 7;
        dpTable = new int[n + 1];
        for (int i = 0; i < dpTable.length; i++) {
            dpTable[i] = -1;
        }
        System.out.println(fibonacci(n));
    }
}
