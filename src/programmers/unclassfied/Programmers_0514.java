package programmers.unclassfied;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 추억 점수
 * LV1
 */
public class Programmers_0514 {
    public static void main(String[] args) {
            //입력 값
            String[] name = {"may", "kein", "kain", "radi"};
            int[] yearning = {5, 10, 1, 3};
            String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
            System.out.println(Arrays.toString(solution(name, yearning, photo)));
        }
    static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        for(int i=0;i<photo.length;i++){
            int sum = 0;
            for(int j=0;j<photo[i].length;j++){
                if(map.containsKey(photo[i][j])){
                    sum+=map.get(photo[i][j]);
                }
            }
            answer[i] = sum;
        }
        return answer;
    }
}


