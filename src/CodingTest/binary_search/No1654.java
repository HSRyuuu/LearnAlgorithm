package CodingTest.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * package : CodingTest.search.binary_search
 * class name : No1654.java
 * date : 2023-06-22 오후 4:53
 * note : 랜선 자르기 / silver 2 / 이분탐색
 */
public class No1654{
    static int[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //랜선의 개수
        int M = Integer.parseInt(st.nextToken()); //필요한 랜선의 개수
        lines = new int[N];

        long max = 0;
        for (int i = 0; i < N; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(lines[i], max);
        }

        long left = 0;
        long right = max  + 1;

        while (left < right) {
            long mid = (left + right) / 2;
            long amount = getLines(mid);

            if(amount < M){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left - 1);
    }

    private static long getLines(long len) {
        long cnt = 0;
        for (int line : lines) {
            cnt += line / len;
        }
        return cnt;
    }
}