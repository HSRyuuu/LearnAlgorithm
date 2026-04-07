package problem_solving.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static common.Grader.grade;

/**
 * @문제명: 전화번호 목록
 * @Tear: Lv2
 * @Algorithm: Hash
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class LV2_전화번호_목록 {

    public static void main(String[] args) {

        // situation1: 접두어가 존재하는 일반 케이스
        String[] input1 = {"119", "97674223", "1195524421"};
        boolean expected1 = false;
        boolean result1 = solution(input1);
        grade(1, "119는 1195524421의 접두어", expected1, result1);

        // situation2: 접두어가 없는 케이스
        String[] input2 = {"123", "456", "789"};
        boolean expected2 = true;
        boolean result2 = solution(input2);
        grade(2, "접두어 관계 없음", expected2, result2);

        // situation3: 연쇄 접두어 관계
        String[] input3 = {"12", "123", "1235", "567", "88"};
        boolean expected3 = false;
        boolean result3 = solution(input3);
        grade(3, "12→123→1235 연쇄 접두어", expected3, result3);

        // situation4: 원소가 1개인 경우
        String[] input4 = {"12345"};
        boolean expected4 = true;
        boolean result4 = solution(input4);
        grade(4, "원소 1개 - 접두어 불가", expected4, result4);

        // situation5: 길이가 같은 번호들
        String[] input5 = {"111", "222", "333"};
        boolean expected5 = true;
        boolean result5 = solution(input5);
        grade(5, "길이 동일 - 접두어 불가", expected5, result5);
    }

    /**
     * TODO: 이 메서드를 구현하세요!
     *
     * @param phone_book 전화번호를 담은 배열
     * @return 접두어인 경우가 있으면 false, 없으면 true
     */
    static boolean solution(String[] phone_book) {
        // 여기에 풀이를 작성하세요
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));

        for (int i = 0; i < phone_book.length - 1; i++) {
            String cur = phone_book[i];
            String next = phone_book[i + 1];
            if (next.startsWith(cur) || cur.startsWith(next)) {
                return false;
            }
        }
        return true;
    }

    /**
     * TODO: 이 메서드를 구현하세요!
     *
     * @param phone_book 전화번호를 담은 배열
     * @return 접두어인 경우가 있으면 false, 없으면 true
     */
    static boolean solution2(String[] phone_book) {
        // 여기에 풀이를 작성하세요
        Set<String> hashSet = new HashSet<>();
        for (String s : phone_book) {
            hashSet.add(s);
        }
        for (String s : phone_book) {
            for (int i = 0; i < s.length(); i++) {
                if (hashSet.contains(s.substring(0, i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
