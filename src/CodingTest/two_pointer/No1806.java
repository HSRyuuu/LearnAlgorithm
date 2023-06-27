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

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int len = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = arr[0];

        while(left <= right){
            if(sum >= S){
                len = Math.min(len, right-left+1);
            }
            if(sum > S){
                sum -= arr[left++];
            }else{
                if(right == arr.length-1){
                    break;
                }
                sum += arr[++right];
            }

        }
        if(len == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(len);
        }
    }
}
