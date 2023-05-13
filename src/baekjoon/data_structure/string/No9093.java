package baekjoon.data_structure.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9093 {
    // 9093번 : 단어 뒤집기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            
            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                StringBuffer stb = new StringBuffer(str);
                sb.append(stb.reverse().toString()+" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
