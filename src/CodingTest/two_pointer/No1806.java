package CodingTest.two_pointer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * package : CodingTest.two_pointer
 * class name : No1806.java
 * date : 2023-06-23 오후 7:08
 * note : 부분합 / gold 4 / 투포인터
 */
public class No1806{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수열 길이
        int S = Integer.parseInt(st.nextToken()); //합

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        if(max >= S){
            System.out.println(1);
            return;
        }

        int left = 0;
        int right = 1;
        int len = N+1;
        int sum = arr[left] + arr[right];

        while(left <= right && right <= arr.length-1){
            if(sum >S){
                len = Math.min(len, right - left + 1);
                sum -= arr[left++];
            }else if(sum == S){
                len = Math.min(len, right - left + 1);
                right++;
                if(right == arr.length){
                    continue;
                }
                sum += arr[right];
            }else{
                right++;
                if(right == arr.length){
                    continue;
                }
                sum += arr[right];
            }

        }
        if(len > N){
            System.out.println(0);
        }else{
            System.out.println(len);
        }

    }
}
