package Algorithm.bfs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의
 * 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다. 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는
 * 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 */

/**
 * @문제명: 숨바꼭질
 * @Tear: S1
 * @Algorithm:
 * @Link: https://www.acmicpc.net/problem/1697
 */
public class S1_BFS_No1697 {

  static final int MAX_K = 100_000;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int K = sc.nextInt();
    sc.close();

    if (N == K) {
      System.out.println(0);
      return;
    }
    int result = bfs(N, K);
    System.out.println(result);
  }

  static int bfs(int start, int target) {
    // 방문 배열
    boolean[] visited = new boolean[MAX_K + 1];
    visited[start] = true;

    Queue<Record> queue = new LinkedList<>();
    queue.offer(new Record(start, 0));

    while (!visited[target] && !queue.isEmpty()) {
      Record cur = queue.poll();
      // 찾으면 그냥 반환
      if (cur.position == target) {
        return cur.count;
      }
      // 지난번에 방문했던 곳
      int lastVisited = cur.position;
      // 방문 체크
      visited[lastVisited] = true;
      // 방법 1 => X - 1
      int option1 = lastVisited - 1;
      if (isValidPosition(option1) && !visited[option1]) {
        queue.offer(new Record(option1, cur.count + 1));
      }
      // 방법 2 => X + 1
      int option2 = lastVisited + 1;
      if (isValidPosition(option2) && !visited[option2]) {
        queue.offer(new Record(option2, cur.count + 1));
      }
      // 방법 3 => X * 2
      int option3 = lastVisited * 2;
      if (isValidPosition(option3) && !visited[option3]) {
        queue.offer(new Record(option3, cur.count + 1));
      }
    }

    return -1; // 버그
  }

  private static boolean isValidPosition(int option1) {
    return option1 >= 0 && option1 <= MAX_K;
  }

  public static class Record {

    public int position;
    public int count;

    public Record(int position, int count) {
      this.position = position;
      this.count = count;
    }
  }

}
