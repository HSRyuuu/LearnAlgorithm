package CodingTest.data_structure.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1717번 : 집합의 표현
 * 이 방법으론 메모리 초과 됨
 * "유니온파인드" 라는 알고리즘 필요
 */
public class No1717{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //집합 : N+1개 0~N
        int M = Integer.parseInt(st.nextToken()); //연산의 개수

        List<Set<Integer>> setList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken()); //0 : 합집합 //1 : a와 b가 같은 집합에 포함되어있는지 확인
            // 0, A, B : A가 포함되어있는 집합과 B가 포함되어있는 집합을 합침
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cmd == 0){
                int idxA = 0;
                int idxB = 0;
                boolean isThereA = false;
                boolean isThereB = false;
                for (int j = 0; j < setList.size(); j++) {
                    if(setList.get(j).contains(a)){
                        isThereA = true;
                        idxA = j;
                    }else if(setList.get(j).contains(b)){
                        isThereB = true;
                        idxB = j;
                    }
                }
                if(isThereA && isThereB){
                    setList.get(idxA).addAll(setList.get(idxB));
                    setList.remove(idxB);
                }else if(isThereA){
                    setList.get(idxA).add(b);
                }else if(isThereB){
                    setList.get(idxB).add(a);
                }else{
                    setList.add(new HashSet<>(Arrays.asList(a,b)));
                }
            }else{
                for (Set<Integer> set : setList) {
                    if(set.contains(a) && set.contains(b)){
                        sb.append("YES\n");
                        break;
                    }else if(set.contains(a) || set.contains(b)){
                        sb.append("NO\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}