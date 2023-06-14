package CodingTest.data_structure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
/**
 * package : CodingTest.data_structure.tree
 * class name : No7662.java
 * date : 2023-06-14 오전 11:56
 * note : gold 4 / treemap , 우선순위 큐
 */
public class No7662 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();//정답 입력 sb
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int cases=0;cases<N;cases++) {
        //케이스 시작============================================
            TreeMap< Integer,Integer> map = new TreeMap<>();
            int K = Integer.parseInt(br.readLine());

            
            for(int i=0;i<K;i++) {
                //입력 받기 시작===============================
                st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if(cmd.equals("I")){
                    map.put(value,map.getOrDefault(value,0)+1);
                }else if(map.isEmpty()) {
                    continue;
                }else{ // cmd.equals("D")
                    int key = value == 1 ? map.lastKey():map.firstKey();
                    if(map.get(key) == 1){
                        map.remove(key);
                    }else{
                        map.put(key, map.get(key)-1);
                    }

                }//D 끝
            }//커멘드 셋 입력 끝
            if(map.isEmpty()){
                sb.append("EMPTY\n");
            }else{
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
            //입력 받기 끝===============================
            
        // 케이스 끝=======================================
        }
        System.out.println(sb);
    }
}