package data_structure.string.no9093_단어뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9093 {
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
