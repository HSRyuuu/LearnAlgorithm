package common;

import java.util.Arrays;
import java.util.Objects;

/**
 * 코딩테스트 채점 유틸리티
 * 모든 문제 파일에서 import하여 사용
 * <p>
 * 사용법:
 * import static common.Grader.*;
 * grade(1, "일반 케이스", expected, actual);
 */
public class Grader {

    public static <T> void grade(int situationNo, String description, T expected, T actual) {
        boolean passed = Objects.deepEquals(expected, actual);
        String icon = passed ? "✅" : "⛔";
        System.out.printf("%s Situation %d: %s%n", icon, situationNo, description);
        if (!passed) {
            System.out.printf("    Expected: %s%n", format(expected));
            System.out.printf("    Actual  : %s%n", format(actual));
        }
    }

    public static String format(Object obj) {
        if (obj instanceof int[]) return Arrays.toString((int[]) obj);
        if (obj instanceof long[]) return Arrays.toString((long[]) obj);
        if (obj instanceof double[]) return Arrays.toString((double[]) obj);
        if (obj instanceof String[]) return Arrays.toString((String[]) obj);
        if (obj instanceof boolean[]) return Arrays.toString((boolean[]) obj);
        if (obj instanceof int[][]) return Arrays.deepToString((int[][]) obj);
        return String.valueOf(obj);
    }
}
