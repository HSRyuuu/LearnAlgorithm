package CodingTest.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * No 7568 덩치
 * 브루트포스
 * silver 5
 */
public class No7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        //list에 man 넣기
        List<Man> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int tall = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Man man = new Man(tall,weight);
            list.add(man);
        }
        //man의 count 설정
        for(int i=0;i<N;i++){
            Man thisMan = list.get(i);
            for(int j=0;j<N;j++){
                if(i == j)continue;
                Man compareMan = list.get(j);
                if(isSmaller(thisMan,compareMan)){
                    thisMan.count();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            Man man = list.get(i);
            sb.append(man.count+1).append(" ");
        }
        System.out.println(sb);

    }

    public static boolean isSmaller(Man thisMan, Man compareMan){
        if(thisMan.tall<compareMan.tall && thisMan.weight<compareMan.weight){
            return true;
        }
        return false;
    }
    static class Man{
        int tall;
        int weight;
        int count;

        public Man(int tall, int weight) {
            this.tall = tall;
            this.weight = weight;
            this.count = 0;
        }
        public void count() {
            this.count++;
        }
    }
}
