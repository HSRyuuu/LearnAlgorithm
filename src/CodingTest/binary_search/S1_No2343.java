package CodingTest.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.binary_search
 * class name : No2343.java
 * date : 2024-02-22 오후 4:14
 * info : 기타 레슨 / silver 1
 * link :
 */
public class S1_No2343 {

    static int N, M;
    static int[] movies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //레슨의 수
        M = Integer.parseInt(st.nextToken()); //블루레이 수
        movies = new int[N];

        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            movies[i] = Integer.parseInt(st.nextToken());
            right += movies[i];
            left = Math.max(left, movies[i]);
        }
        //--------여기까지 입력-----------

        while (left <= right) {
            int mid = (left + right) / 2;
            int lectures = getLectures(mid);

            if (lectures > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }


    //해당 길이로 만들면 몇 개의 영상이 되는지 반환
    static int getLectures(int len) {
        int count = 1;
        int amount = movies[0];
        for (int i = 1; i < N; i++) {
            int cur = movies[i];
            if (amount + cur > len) {
                count++;
                amount = cur;
            } else {
                amount += cur;
            }
        }
        return count;
    }
}
