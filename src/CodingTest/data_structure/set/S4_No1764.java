package CodingTest.data_structure.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_No1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();

        for(int i = 0; i < M; i++){
            String s = br.readLine();
            if(set.contains(s)){
                list.add(s);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());

        StringJoiner sj = new StringJoiner("\n");
        for (String s : list) {
            sj.add(s);
        }
        System.out.println(sj);
    }
}