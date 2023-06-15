package CodingTest.data_structure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No26008{
    static final Long MODE = 1_000_000_007L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken()); //비밀번호 길이
        long M = Long.parseLong(st.nextToken()); //문자 종류의 개수
        long A = Long.parseLong(st.nextToken()); //정수 A

        int hashValue = Integer.parseInt(br.readLine());//정수 H : 해시값
        long answer = 1;
        /*
        h(P) = (P0*A^0 + P1*A^1 + P2*A^2 ... +Pn-1*A^n-1) % M
        -> 해시값은 항상 0이상 M-1 이하의 정수 -> M개의 정수

        전체 가능한 가짓수 : M^n가지
        답 : M^n-1 가지
         */

        for(int i=0;i<N-1;i++){
            answer = (answer*M) % MODE;
        }
        
        System.out.println(answer);
    }
}