package baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * No 7568 덩치
 * 브루트포스
 * silver 5
 */
public class No7568_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        //배열에 man 넣기
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tall = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[i][0] = tall;
            arr[i][1] = weight;
        }
        //비교
        for(int i=0;i<N;i++){
            int rank = 1;
            for(int j=0;j<N;j++){
                if(i==j) continue;
                if(isSmaller(arr[i],arr[j])){
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        System.out.println(sb);
    }
    public static boolean isSmaller(int[] thisMan, int[] compareMan){
        if(thisMan[0]<compareMan[0] && thisMan[1]<compareMan[1]){
            return true;
        }
        return false;
    }
}
