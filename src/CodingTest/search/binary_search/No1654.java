package CodingTest.search.binary_search;

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

        int K = Integer.parseInt(st.nextToken()); // 갖고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); //필요한 랜선의 개수
        lines = new int[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(lines[i], max);
        }
        max++;

        long left = 0;
        long right = max;
        while(left < right){
            long mid = (right + left) / 2;
            long amount = getLines(mid);

            if(amount < N){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        System.out.println(left-1);
    }
    static long getLines(long len){
        long amount = 0;
        for(int line : lines){
            amount += line / len;
        }
        return amount;
    }
}