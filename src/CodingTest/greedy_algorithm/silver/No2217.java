package CodingTest.greedy_algorithm.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * package : CodingTest.greedy_algorithm.easy
 * class name : No2217.java
 * date : 2023-06-25 오후 6:18
 * note : 로프 / silver 4 / 그리디
 */
public class No2217{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list,(o1, o2) -> o2-o1);

        int weight = 0;
        for(int i = 0; i < list.size(); i++){
            int lope = list.get(i);
            int w = lope * (i+1);
            weight = Math.max(weight, w);
        }
        System.out.println(weight);
    }
}
