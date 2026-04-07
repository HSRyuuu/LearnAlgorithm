package problem_solving.Greedy;

import static common.Grader.grade;

/**
 * @문제명: 설탕 배달
 * @Tear: Silver 4
 * @Algorithm: Greedy
 * @Link: https://www.acmicpc.net/problem/2839
 */
public class S4_설탕_배달 {

    public static void main(String[] args) {

        // situation1: 일반 케이스 - 5kg와 3kg 조합
        int result1 = solution(18);
        grade(1, "18kg → 5x3 + 3x1 = 4봉지", 4, result1);

        // situation2: 엣지 케이스 - 만들 수 없는 경우
        int result2 = solution(4);
        grade(2, "4kg → 불가능 = -1", -1, result2);

        // situation3: 엣지 케이스 - 3으로만 나누어지는 경우
        int result3 = solution(6);
        grade(3, "6kg → 3x2 = 2봉지", 2, result3);

        // situation4: 엣지 케이스 - 5와 3 혼합
        int result4 = solution(11);
        grade(4, "11kg → 5x1 + 3x2 = 3봉지", 3, result4);

        // situation5: 엣지 케이스 - 5로만 나누어지는 경우
        int result5 = solution(15);
        grade(5, "15kg → 5x3 = 3봉지", 3, result5);
    }

    /**
     * TODO: 이 메서드를 구현하세요!
     *
     * @param n 배달해야 할 설탕 무게 (kg)
     * @return 최소 봉지 수 (불가능하면 -1)
     */
    static int solution(int n) {
        if (n % 5 == 0) {
            return n / 5;
        }
        int weight = n;
        int count = 0;
        while (weight > 0) {
            weight -= 3;
            count++;
            if (weight % 5 == 0) {
                return count + weight / 5;
            }
        }
        return -1;
    }
}
