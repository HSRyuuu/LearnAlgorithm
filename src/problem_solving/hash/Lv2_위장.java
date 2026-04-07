package problem_solving.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static common.Grader.grade;

/**
 * @문제명: 위장
 * @Tear: Lv2
 * @Algorithm: Hash
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Lv2_위장 {

    public static void main(String[] args) {

        // situation1: 종류가 2개, 의상이 3개인 일반 케이스
        String[][] input1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int expected1 = 5;
        int result1 = solution(input1);
        grade(1, "종류 2개 (headgear 2개, eyewear 1개)", expected1, result1);

        // situation2: 같은 종류의 의상만 있는 경우
        String[][] input2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        int expected2 = 3;
        int result2 = solution(input2);
        grade(2, "종류 1개에 의상 3개", expected2, result2);

        // situation3: 의상이 1개뿐인 최소 케이스
        String[][] input3 = {{"a", "b"}};
        int expected3 = 1;
        int result3 = solution(input3);
        grade(3, "의상 1개 (최소 입력)", expected3, result3);

        // situation4: 종류별로 1개씩만 있는 경우
        String[][] input4 = {{"hat", "headgear"}, {"glasses", "eyewear"}, {"shirt", "top"}};
        int expected4 = 7;
        int result4 = solution(input4);
        grade(4, "종류 3개, 각 1개씩 → 2*2*2-1=7", expected4, result4);
    }

    /**
     * TODO: 이 메서드를 구현하세요!
     *
     * @param clothes 의상 배열 [의상 이름, 의상 종류]
     * @return 서로 다른 옷의 조합의 수
     */
    static int solution(String[][] clothes) {
        Map<String, Set<String>> clothesMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            String name = clothes[i][0];
            clothesMap.putIfAbsent(type, new HashSet<>());
            clothesMap.get(type).add(name);
        }
        // hint
        int answer = 1;
        for (Set<String> value : clothesMap.values()) {
            answer *= value.size() + 1;
        }
        return answer - 1;
    }
}
