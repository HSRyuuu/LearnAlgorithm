package CodingTest.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * package : CodingTest.binary_search
 * class : No1654
 * date : 2024-02-20 오후 4:53
 * info : 랜선 자르기 silver2
 * link :
 */
public class No1654 {

    static long[] lines;
    static int K, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lines = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            int cur = Integer.parseInt(br.readLine());
            max = Math.max(cur, max);
            lines[i] = cur;
        }

        //나무 한조각의 길이
        long left = 0;
        long right = max + 1;

        while (left < right) {
            long mid = (left + right) / 2;
            long count = count(mid);

            if (count >= N) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left - 1);
    }

    static long count(long len) {
        int count = 0;
        for (long tree : lines) {
            count += tree / len;
        }
        return count;
    }
}