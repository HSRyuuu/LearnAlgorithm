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

class D_23_10_30 {
    static long[] lines;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        lines = new long[K];
        long max = 0;
        for(int i = 0; i < K; i++){
            lines[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lines[i]);
        }
        long left = 0L;
        long right = max + 1;

        while(left < right){
            long mid = (right + left)/ 2; //나무 조각 하나의 길이
            long amount = cut(mid); //자른 개수

            if(amount >= N){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        System.out.println(left - 1);

    }

    static int cut(long len){
        int cnt = 0;

        for (long line : lines) {
            cnt += line / len;
        }
        return cnt;
    }
}