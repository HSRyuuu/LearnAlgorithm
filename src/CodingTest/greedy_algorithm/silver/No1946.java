package CodingTest.greedy_algorithm.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.greedy_algorithm
 * class name : No1946.java
 * date : 2023-06-25 오후 6:48
 * note : 신입 사원 / silver1 / 그리디
 */
public class No1946{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n+1]; //0번 안씀
            for (int i = 0; i <n; i++) {
                st = new StringTokenizer(br.readLine());
                int rank1 = Integer.parseInt(st.nextToken());
                int rank2 = Integer.parseInt(st.nextToken());
                arr[rank1] = rank2;
            }
            int cnt = 0;
            int best = arr[1];
            for (int i = 2; i <= n; i++) {
                if(arr[i] > best){
                    cnt++;
                }else{
                    best = Math.min(arr[i], best);
                }
            }
            System.out.println(n-cnt);
        }
    }
}
