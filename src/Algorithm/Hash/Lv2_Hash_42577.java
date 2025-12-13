package Algorithm.Hash;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @문제명: 전화번호 목록
 * @Tear: Lv2
 * @Algorithm: Hash
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class Lv2_Hash_42577 {

  public static void main(String[] args) throws IOException {
    String[] phone_book = {"119", "97674223", "1195524421"};
    boolean result = solution(phone_book);
    System.out.println(result);
  }

  public static boolean solution(String[] phone_book) {

    Set<String> set = new HashSet<>(Arrays.asList(phone_book));

    for (String phoneNum : phone_book) {
      for (int i = 0; i < phoneNum.length(); i++) {
        if (set.contains(phoneNum.substring(0, i))) {
          return false;
        }
      }
    }

    return true;
  }
}
