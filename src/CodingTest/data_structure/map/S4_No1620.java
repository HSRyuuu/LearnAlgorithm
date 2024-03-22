package CodingTest.data_structure.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/**
 * package : CodingTest.data_structure.map
 * class name : S4_No1620.java
 * date : 2024-03-22 오후 2:42
 * info : 나는야 포켓몬 마스터 이다솜 / Map
 * link :
 */
public class S4_No1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> numberMap = new HashMap<>();
        Map<String, Integer> nameMap = new HashMap<>();

        for(int i = 1; i <= N; i++){
            String p = br.readLine();
            numberMap.put(i, p);
            nameMap.put(p, i);
        }

        StringJoiner sj = new StringJoiner("\n");
        for(int i = 0; i < M; i++){
            String q = br.readLine();
            if(q.charAt(0) >= '0' && q.charAt(0) <= '9'){
                sj.add(numberMap.get(Integer.parseInt(q)));
            }else{
                sj.add(String.valueOf(nameMap.get(q)));
            }
        }

        System.out.println(sj);

    }
}