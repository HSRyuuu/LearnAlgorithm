package CodingTest.search.binary_search;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2805번 : 나무 자르기
 * 이분탐색, 매개변수 탐색
 * 실버2
 */
public class No2805 {
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        int max = 0;
        int min = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i],max);
        }

        //이분탐색
        while(min<max){
            int mid = (min+max)/2;
            long sum = cutting(mid);

            if(sum < M){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
    static long cutting(int height){
        long result = 0;
        for(int i=0;i<trees.length;i++){
            if(trees[i] > height){
                result += trees[i] - height;
            }
        }
        return  result;
    }
}
