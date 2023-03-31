package mathematics.no1929_소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1929 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        answer(m,n);
        System.out.println(sb);
    }
    static void answer(int m,int n){
        if(m==2){
            sb.append(2).append("\n");
            m+=1;
        }else if(m==1){
            sb.append(2).append("\n");
            m=3;
        } else if(m%2==0){
            m+=1;
        }

        while(m<=n){
            boolean YN = check(m);
            if(YN){
                sb.append(m).append("\n");
            }
            m+=2;
        }
    }
    static boolean check(int m){
        for(int i=2;i<=(int)Math.sqrt(m);i++){
            if(m%i==0) return false;
        }
        return true;
    }
}