package CodingTest.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;

/**
 * package : CodingTest.sort
 * class name : S5_No1181.java
 * date : 2024-03-22 오후 2:03
 * info : 정렬, 문자열, Set
 * link :
 */
public class S5_No1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>(set);

        Collections.sort(list, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }else{
                return o1.length() - o2.length();
            }
        });

        StringJoiner sj = new StringJoiner("\n");
        for (String s : list) {
            sj.add(s);
        }
        System.out.println(sj);
    }
}