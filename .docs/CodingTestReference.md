# 코딩테스트 준비 핵심 레퍼런스 (Java)
---

## 필수 알고리즘/자료구조 목록 & 학습 로드맵

| 번호 | 주제                   | 핵심 아이디어                          | 대표 문제 유형              |
|----|----------------------|----------------------------------|-----------------------|
| 1  | **배열 & 연결 리스트**      | 순차적/연결된 데이터 저장, 접근 방식 차이         | 배열 조작, 연결 리스트 반전      |
| 2  | **스택 & 큐**           | LIFO(스택), FIFO(큐)로 데이터 순서 관리     | 괄호 짝 맞추기, 대기열 처리      |
| 3  | **해시 테이블 & 집합**      | 빠른 검색, 중복 제거                     | 두 수의 합, 고유 문자열        |
| 4  | **정렬**               | 데이터를 순서대로 배치, 효율적인 탐색/처리의 전제조건   | 배열 정렬, K번째 수 찾기       |
| 5  | **이진 탐색**            | 정렬된 데이터에서 빠르게 값 찾기               | 특정 값 찾기, 최적값 범위 탐색    |
| 6  | **투 포인터**            | 두 인덱스를 이동시키며 효율적으로 쌍 또는 구간 탐색    | 두 수의 합(정렬 후), 연속 구간 합 |
| 7  | **백트래킹**             | 모든 가능한 경우를 체계적으로 탐색, 가지치기로 최적화   | 순열/조합 생성, N-Queen 문제  |
| 8  | **동적 계획법 (DP)**      | 하위 문제의 해를 저장하여 중복 계산 제거, 점화식 도출  | 계단 오르기, 배낭 문제         |
| 9  | **그래프 탐색 (DFS/BFS)** | 노드와 엣지로 연결된 관계 탐색, 최단 경로(BFS 활용) | 미로 탐색, 연결 요소 개수 세기    |

---

## 1. 배열 (Array)

### 개념

- 번호(인덱스)가 매겨진 연속된 칸에 데이터를 저장
- Java의 `int[]`(고정 크기)과 `ArrayList`(동적 배열) 역할

### 시간 복잡도

| 연산        | 배열 (`int[]`) | ArrayList |
|-----------|--------------|-----------|
| 조회 (인덱스)  | O(1)         | O(1)      |
| 맨 끝 추가/삭제 | -            | O(1)      |
| 중간 삽입/삭제  | O(N)         | O(N)      |

### 예시 코드

```java
import java.util.ArrayList;
import java.util.List;

// 고정 배열
int[] scores = {90, 85, 92};
System.out.

        println(scores[1]); // 85 (O(1))

        // 동적 배열 (ArrayList)
        List<Integer> scoreList = new ArrayList<>(List.of(90, 85, 92));

// 맨 끝에 추가 (O(1))
scoreList.

        add(88);

// 중간 삽입 (O(N))
scoreList.

        add(1,87);

// 중간 삭제 (O(N))
scoreList.

        remove(1);
```

### 사용 시점

- 순서가 중요하고 특정 위치 데이터를 자주 조회할 때
- 정렬된 데이터를 다루거나 특정 구간 처리 시

---

## 2. 연결 리스트 (Linked List)

### 개념

- 각 노드가 데이터 + 다음 노드 포인터를 가짐
- 단일 연결: 1→2→3 / 이중 연결: 1↔2↔3
- Java의 `LinkedList<E>`가 이중 연결 리스트 구현체

### 시간 복잡도

| 연산               | 복잡도  |
|------------------|------|
| 조회               | O(N) |
| 삽입/삭제 (위치 알 때)   | O(1) |
| 삽입/삭제 (위치 탐색 포함) | O(N) |

### 예시 코드

```java
// 방법 1: Java 내장 LinkedList 사용

import java.util.LinkedList;

LinkedList<String> playlist = new LinkedList<>();
playlist.

add("1번곡");
playlist.

add("2번곡");
playlist.

add("3번곡");

// 전체 출력
for(
String song :playlist){
        System.out.

print(song +" -> ");
}

// 2번곡 뒤에 "새로운곡" 삽입
int idx = playlist.indexOf("2번곡");
if(idx >=0){
        playlist.

add(idx +1, "새로운곡");
}

// 방법 2: 직접 구현
class ListNode {
    String val;
    ListNode next;

    ListNode(String val) {
        this.val = val;
    }
}

ListNode head = new ListNode("1번곡");
head.next =new

ListNode("2번곡");

head.next.next =new

ListNode("3번곡");

// 순회
ListNode current = head;
while(current !=null){
        System.out.

print(current.val +(current.next!=null?" -> ":""));
current =current.next;
}
```

---

## 3. 스택 (Stack)

### 개념

- LIFO (Last-In, First-Out): 마지막에 들어온 것이 먼저 나감
- 접시 쌓기 비유: push로 쌓고, pop으로 위에서부터 꺼냄

### 핵심 연산

- **Push**: 맨 위에 추가 → O(1)
- **Pop**: 맨 위 제거 → O(1)
- **Peek**: 맨 위 확인 → O(1)

### 예시 코드

```java
import java.util.ArrayDeque;
import java.util.Deque;

// ArrayDeque를 스택으로 사용 (Stack 클래스보다 권장)
Deque<String> stack = new ArrayDeque<>();

// Push (웹 페이지 방문 기록)
stack.

        push("네이버 메인");
stack.

        push("뉴스 기사 페이지");
stack.

        push("블로그 글 페이지");

        // Peek (현재 페이지 확인)
        String currentPage = stack.peek(); // "블로그 글 페이지"

        // Pop (뒤로 가기)
        String prevPage = stack.pop(); // "블로그 글 페이지"

// 비었는지 확인
if(stack.

        isEmpty()){
        System.out.

        println("스택이 비었습니다.");
}
```

### 사용 시점

- 웹 브라우저 뒤로 가기
- 괄호 유효성 검사 ({[]})
- 함수 호출 스택 (재귀)
- 수식 계산 (후위 표기법)

---

## 4. 큐 (Queue)

### 개념

- FIFO (First-In, First-Out): 먼저 들어온 것이 먼저 나감
- 줄 서기 비유: 뒤에서 추가, 앞에서 제거

### 핵심 연산

- **offer**: 맨 뒤에 추가 → O(1)
- **poll**: 맨 앞 제거 → O(1)

### 예시 코드

```java
import java.util.ArrayDeque;
import java.util.Queue;

Queue<String> queue = new ArrayDeque<>();

// offer (프린터 대기열)
queue.

offer("문서1.docx");
queue.

offer("사진2.jpg");
queue.

offer("보고서3.pdf");

// peek (다음 인쇄 문서 확인)
String nextDoc = queue.peek(); // "문서1.docx"

// poll (인쇄 시작)
String currentDoc = queue.poll(); // "문서1.docx"

// 비었는지 확인
if(queue.

isEmpty()){
        System.out.

println("대기열이 비었습니다.");
}
```

### 사용 시점

- 프린터 작업 대기열
- 운영체제 작업 스케줄링
- BFS (너비 우선 탐색)
- 버퍼 역할

### 스택 vs 큐 비교

| 기준   | 스택                      | 큐                         |
|------|-------------------------|---------------------------|
| 순서   | LIFO                    | FIFO                      |
| 비유   | 접시 쌓기                   | 줄 서기                      |
| Java | `Deque` (push/pop/peek) | `Queue` (offer/poll/peek) |
| 사용처  | 역순 처리, 최근 작업            | 순서대로 처리, 공정 분배            |

> **참고**: Java에서 `Stack` 클래스는 동기화 오버헤드가 있어 `ArrayDeque`를 사용하는 것이 권장됨.

---

## 5. 해시 테이블 (Hash Table)

### 개념

- 키(Key) → 값(Value) 매핑, 전화번호부와 유사
- Java의 `HashMap`이 해시 테이블

### 시간 복잡도

| 연산       | 평균   | 최악   |
|----------|------|------|
| 삽입/조회/삭제 | O(1) | O(N) |

### 예시 코드

```java
import java.util.HashMap;
import java.util.Map;

// 학생 점수 관리
Map<String, Integer> scores = new HashMap<>();

// 삽입
scores.

        put("Alice",90);
scores.

        put("Bob",85);
scores.

        put("Charlie",92);

// 조회
System.out.

        println(scores.get("Alice")); // 90

// 존재 확인
        System.out.

        println(scores.containsKey("Bob")); // true

// 삭제
        scores.

        remove("Bob");

// 수정
scores.

        put("Alice",95);

        // getOrDefault (키 없으면 기본값)
        int score = scores.getOrDefault("Dave", 0); // 0

        // 빈도 세기 패턴
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        Map<String, Integer> freq = new HashMap<>();
for(
        String w :words){
        freq.

        merge(w, 1,Integer::sum); // 또는 freq.put(w, freq.getOrDefault(w, 0) + 1);
}
// {apple=3, banana=2, cherry=1}
```

### 사용 시점

- 빠른 검색 (키로 값 조회)
- 빈도 세기 (각 항목의 등장 횟수)

---

## 6. 집합 (Set)

### 개념

- 중복을 허용하지 않는 고유 데이터 보관
- Java의 `HashSet`

### 시간 복잡도

- 삽입/삭제/존재 확인: 평균 O(1)

### 예시 코드

```java
import java.util.HashSet;
import java.util.Set;

Set<String> classA = new HashSet<>(Set.of("Alice", "Bob", "Charlie"));
Set<String> classB = new HashSet<>(Set.of("Bob", "Charlie", "Dave"));

// 교집합: 두 집합 모두에 있는 원소
Set<String> intersection = new HashSet<>(classA);
intersection.

retainAll(classB);
System.out.

println(intersection); // [Bob, Charlie]

// 합집합: 두 집합의 모든 원소 (중복 제거)
Set<String> union = new HashSet<>(classA);
union.

addAll(classB);
System.out.

println(union); // [Alice, Bob, Charlie, Dave]

// 차집합: classA에만 있는 원소
Set<String> diff = new HashSet<>(classA);
diff.

removeAll(classB);
System.out.

println(diff); // [Alice]

// 존재 확인
System.out.

println(classA.contains("Alice")); // true
```

### 해시 테이블 vs 집합

| 기준    | HashMap | HashSet             |
|-------|---------|---------------------|
| 저장 형태 | 키-값 쌍   | 값만                  |
| 사용 목적 | 키로 값 조회 | 중복 제거, 존재 확인, 집합 연산 |
| 예시    | 전화번호부   | 중복 없는 초대 명단         |

---

## 7. 정렬 (Sorting)

### 개념

- 데이터를 특정 기준으로 순서대로 재배열
- Java 내장 정렬: Arrays.sort (Dual-Pivot Quicksort) / Collections.sort (Timsort)
- 모두 O(N log N) 보장

### 예시 코드

```java
import java.util.*;

// 기본 배열 정렬
int[] scores = {85, 92, 78, 100, 85};
Arrays.

        sort(scores); // 오름차순: [78, 85, 85, 92, 100]

        // 내림차순 (Integer 배열 필요)
        Integer[] boxedScores = {85, 92, 78, 100, 85};
Arrays.

        sort(boxedScores, Collections.reverseOrder()); // [100, 92, 85, 85, 78]

        // ArrayList 정렬
        List<String> names = new ArrayList<>(List.of("Alice", "Bob", "Charlie", "David"));
Collections.

        sort(names); // 알파벳 오름차순

// 문자열 길이순
names.

        sort(Comparator.comparingInt(String::length));

// 여러 기준 (길이 오름차순, 같으면 알파벳순)
        names.

        sort(Comparator.comparingInt(String::length).

        thenComparing(Comparator.naturalOrder()));

        // 2차원 배열 정렬 (점수 기준)
        int[][] students = {{"Alice", 90}, {"Bob", 85}, {"Charlie", 92}};
        // → 객체 리스트로 처리
        List<int[]> studentList = List.of(new int[]{90, 0}, new int[]{85, 1}, new int[]{92, 2});
// 점수 오름차순
studentList.

        sort(Comparator.comparingInt(a ->a[0]));
// 점수 내림차순
        studentList.

        sort((a, b) ->b[0]-a[0]);

        // 실전: Map 정렬 (점수 내림차순, 이름 오름차순)
        Map<String, Integer> scoreMap = Map.of("Alice", 90, "Bob", 85, "Charlie", 92);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(scoreMap.entrySet());
entries.

        sort(Map.Entry .<String, Integer>comparingByValue().

        reversed()
        .

        thenComparing(Map.Entry.comparingByKey()));
```

### Arrays.sort() vs Collections.sort()

| 기준    | Arrays.sort()                             | Collections.sort()   |
|-------|-------------------------------------------|----------------------|
| 대상    | 배열 (`int[]`, `String[]`)                  | List (`ArrayList` 등) |
| 알고리즘  | Dual-Pivot Quicksort (원시형) / Timsort (객체) | Timsort              |
| 원본 변경 | O                                         | O                    |

### 사용 시점

- 데이터를 순서대로 볼 때
- 이진 탐색, 투 포인터의 전처리
- K번째 작은/큰 값 찾기

---

## 8. 이진 탐색 (Binary Search)

### 개념

- **정렬된 데이터**에서 중간값과 비교하며 탐색 범위를 절반씩 줄임
- 시간 복잡도: O(log N) ← 1백만 개 데이터도 최대 20번 비교

### 예시 코드

```java
import java.util.Arrays;

// 방법 1: 직접 구현 (반복문)

public static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2; // 오버플로 방지
        if (arr[mid] == target) {
            return mid;         // 찾음
        } else if (arr[mid] < target) {
            left = mid + 1;     // 오른쪽 탐색
        } else {
            right = mid - 1;    // 왼쪽 탐색
        }
    }
    return -1; // 없음
}

        int[] scores = {10, 20, 30, 40, 50}; // 정렬 필수!
System.out.

        println(binarySearch(scores, 30)); // 2
        System.out.

        println(binarySearch(scores, 25)); // -1

        // 방법 2: Arrays.binarySearch() 활용
        int idx = Arrays.binarySearch(scores, 30);
// 찾으면 인덱스 반환, 없으면 -(삽입 위치) - 1 반환
System.out.

        println(idx); // 2

        int idx2 = Arrays.binarySearch(scores, 25);
System.out.

        println(idx2); // -3 (삽입 위치 2의 음수 표현)
```

### Lower Bound / Upper Bound (직접 구현)

```java
// lower bound: target 이상인 첫 번째 위치
public static int lowerBound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] < target) left = mid + 1;
        else right = mid;
    }
    return left;
}

// upper bound: target 초과인 첫 번째 위치
public static int upperBound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] <= target) left = mid + 1;
        else right = mid;
    }
    return left;
}
```

### 주의사항

- 반드시 정렬된 상태에서 사용
- `mid = left + (right - left) / 2`로 오버플로 방지 (Java 필수 패턴)
- `Arrays.binarySearch()`는 없으면 `-(삽입 위치) - 1` 반환

### 선형 탐색 vs 이진 탐색

| 기준     | 선형 탐색       | 이진 탐색     |
|--------|-------------|-----------|
| 시간 복잡도 | O(N)        | O(log N)  |
| 정렬 필요  | X           | O (필수)    |
| 사용 시   | 소량 데이터, 비정렬 | 대량 정렬 데이터 |

---

## 9. 투 포인터 (Two Pointers)

### 개념

- 두 개의 인덱스(포인터)를 사용해 배열을 효율적으로 탐색
- O(N²)을 O(N)으로 줄일 수 있는 강력한 기법

### 패턴 1: 양쪽에서 좁혀오기 (정렬된 배열에서 쌍 찾기)

```java
import java.util.*;

public static List<int[]> twoPointerSum(int[] arr, int target) {
    Arrays.sort(arr); // 정렬 필수!
    List<int[]> result = new ArrayList<>();
    int left = 0, right = arr.length - 1;

    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) {
            result.add(new int[]{arr[left], arr[right]});
            left++;
        } else if (sum < target) {
            left++;   // 합이 작으면 left 증가
        } else {
            right--;  // 합이 크면 right 감소
        }
    }
    return result;
}

// 사용 예시
int[] numbers = {2, 7, 11, 15, 3, 6};
List<int[]> pairs = twoPointerSum(numbers, 9);
// [[2,7], [3,6]]
```

### 패턴 2: 같은 방향으로 이동 (슬라이딩 윈도우)

```java
public static int slidingWindowMinLength(int[] arr, int targetSum) {
    int left = 0;
    int currentSum = 0;
    int minLength = Integer.MAX_VALUE;

    for (int right = 0; right < arr.length; right++) {
        currentSum += arr[right]; // 오른쪽 확장

        while (currentSum >= targetSum && left <= right) {
            minLength = Math.min(minLength, right - left + 1);
            currentSum -= arr[left]; // 왼쪽 축소
            left++;
        }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}

// 사용 예시
int[] numbers = {2, 3, 1, 2, 4, 3};
System.out.

println(slidingWindowMinLength(numbers, 7)); // 2 (구간 [4,3])
```

### 사용 시점

- 정렬된 배열에서 두 수의 합/차 조건 만족하는 쌍 찾기
- 연속된 구간(부분 배열)의 합, 길이 최적화
- N ≥ 100,000 이상 대용량 데이터 처리

---

## 10. 백트래킹 (Backtracking)

### 개념

- 모든 가능성을 탐색하되, 조건 불만족 시 즉시 되돌아(가지치기)
- 재귀 함수로 구현

### 예시 1: 순열 생성

```java
import java.util.*;

public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    backtrack(nums, new ArrayList<>(), used, result);
    return result;
}

private static void backtrack(int[] nums, List<Integer> current,
                              boolean[] used, List<List<Integer>> result) {
    if (current.size() == nums.length) {
        result.add(new ArrayList<>(current)); // 깊은 복사
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;
        current.add(nums[i]);
        used[i] = true;
        backtrack(nums, current, used, result);
        current.remove(current.size() - 1); // 백트랙 (선택 취소)
        used[i] = false;
    }
}

// [1,2,3]의 모든 순열
// [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
```

### 예시 2: N-Queen 문제

```java
public static List<int[]> nQueen(int n) {
    List<int[]> result = new ArrayList<>();
    int[] board = new int[n]; // board[row] = col

    solve(board, 0, n, result);
    return result;
}

private static boolean isSafe(int[] board, int row, int col) {
    for (int prevRow = 0; prevRow < row; prevRow++) {
        if (board[prevRow] == col) return false;                          // 같은 열
        if (Math.abs(board[prevRow] - col) == Math.abs(prevRow - row))    // 대각선
            return false;
    }
    return true;
}

private static void solve(int[] board, int row, int n, List<int[]> result) {
    if (row == n) {
        result.add(board.clone());
        return;
    }
    for (int col = 0; col < n; col++) {
        if (isSafe(board, row, col)) {
            board[row] = col;
            solve(board, row + 1, n, result);
            // 다음 반복에서 덮어쓰므로 명시적 초기화 생략 가능
        }
    }
}

// 4x4 N-Queen 해: 2개
```

### 사용 시점

- 순열, 조합, 부분집합 생성
- N-Queen, 스도쿠
- 특정 합을 만드는 조합 찾기

---

## 11. 동적 계획법 (Dynamic Programming, DP)

### 개념

- 큰 문제를 작은 하위 문제로 분할, 결과를 저장하여 중복 계산 제거
- 핵심: **겹치는 부분 문제** + **최적 부분 구조** + **점화식**

### 방법 1: 메모이제이션 (Top-down, 재귀 + 캐싱)

```java
import java.util.HashMap;
import java.util.Map;

private static Map<Integer, Long> memo = new HashMap<>();

public static long fibonacciMemo(int n) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n); // 이미 계산된 결과 반환

    long result = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
    memo.put(n, result);
    return result;
}

System.out.

println(fibonacciMemo(10)); // 55
```

### 방법 2: 테이블 방식 (Bottom-up, 반복문) — 더 권장

```java
public static long fibonacciTable(int n) {
    if (n <= 1) return n;
    long[] dp = new long[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}

System.out.

println(fibonacciTable(10)); // 55
```

### 응용: 계단 오르기 (1칸 또는 2칸씩)

```java
public static int climbStairs(int n) {
    if (n <= 1) return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1; // 시작점
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2]; // 점화식
    }
    return dp[n];
}

System.out.

println(climbStairs(3)); // 3가지 (1+1+1, 1+2, 2+1)
        System.out.

println(climbStairs(4)); // 5가지
```

### 자주 나오는 DP 유형

- 계단 오르기, 타일 채우기 (경우의 수)
- 배낭 문제 (최대 가치)
- 최장 증가 부분 수열 (LIS)
- 최장 공통 부분 수열 (LCS)
- 문자열 편집 거리

### 단순 재귀 vs DP 비교

| 기준     | 단순 재귀  | 동적 계획법        |
|--------|--------|---------------|
| 시간 복잡도 | O(2^N) | O(N) 또는 O(N²) |
| 중복 계산  | 많음     | 없음 (저장 활용)    |
| 구현     | 재귀 함수  | 메모이제이션 또는 테이블 |

---

## 12. 그래프 탐색 (DFS & BFS)

### 개념

- 그래프: 정점(Node) + 간선(Edge)으로 구성
- 인접 리스트로 표현 → O(V+E) 효율적

```java
import java.util.*;

// 인접 리스트 표현
Map<String, List<String>> graph = new HashMap<>();
graph.

        put("A",List.of("B", "C"));
        graph.

        put("B",List.of("A", "D","E"));
        graph.

        put("C",List.of("A", "F"));
        graph.

        put("D",List.of("B"));
        graph.

        put("E",List.of("B", "F"));
        graph.

        put("F",List.of("C", "E"));
```

### DFS (깊이 우선 탐색)

- 한 경로를 끝까지 깊게 탐색 → 스택 또는 재귀 사용

```java
// 재귀 방식
public static void dfsRecursive(Map<String, List<String>> graph,
                                String node, Set<String> visited) {
    visited.add(node);
    System.out.print(node + " ");
    for (String neighbor : graph.get(node)) {
        if (!visited.contains(neighbor)) {
            dfsRecursive(graph, neighbor, visited);
        }
    }
}

// 반복문(스택) 방식
public static void dfsIterative(Map<String, List<String>> graph, String start) {
    Set<String> visited = new HashSet<>();
    Deque<String> stack = new ArrayDeque<>();
    stack.push(start);

    while (!stack.isEmpty()) {
        String node = stack.pop();
        if (visited.contains(node)) continue;
        visited.add(node);
        System.out.print(node + " ");

        List<String> neighbors = graph.get(node);
        for (int i = neighbors.size() - 1; i >= 0; i--) {
            if (!visited.contains(neighbors.get(i))) {
                stack.push(neighbors.get(i));
            }
        }
    }
}

// dfsRecursive(graph, "A", new HashSet<>());  // A B D E F C
```

### BFS (너비 우선 탐색)

- 가까운 노드부터 탐색 → 큐(Queue) 사용
- **최단 경로 탐색** (가중치 없는 그래프)에 최적!

```java
public static void bfs(Map<String, List<String>> graph, String start) {
    Set<String> visited = new HashSet<>();
    Queue<String> queue = new ArrayDeque<>();

    visited.add(start);
    queue.offer(start);

    while (!queue.isEmpty()) {
        String node = queue.poll();
        System.out.print(node + " ");
        for (String neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                queue.offer(neighbor);
            }
        }
    }
}

// bfs(graph, "A");  // A B C D E F
```

### BFS 최단 거리 (2차원 배열 / 미로 탐색)

```java
// dx, dy 방향 배열 패턴 (상하좌우)
int[] dx = {-1, 1, 0, 0};
int[] dy = {0, 0, -1, 1};

public static int bfsShortestPath(int[][] grid, int sr, int sc, int er, int ec) {
    int n = grid.length, m = grid[0].length;
    boolean[][] visited = new boolean[n][m];
    Queue<int[]> queue = new ArrayDeque<>();

    queue.offer(new int[]{sr, sc, 0}); // {row, col, distance}
    visited[sr][sc] = true;

    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int x = curr[0], y = curr[1], dist = curr[2];

        if (x == er && y == ec) return dist; // 도착

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                    && !visited[nx][ny] && grid[nx][ny] == 1) {
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }
    }
    return -1; // 도달 불가
}
```

### DFS vs BFS 비교

| 기준     | DFS                        | BFS            |
|--------|----------------------------|----------------|
| 탐색 방식  | 깊게 파고들기                    | 넓게 퍼지기         |
| 자료구조   | 스택 / 재귀                    | 큐 (ArrayDeque) |
| 시간 복잡도 | O(V+E)                     | O(V+E)         |
| 주요 용도  | 경로 존재 여부, 사이클 탐지, 모든 노드 방문 | **최단 경로** 탐색   |

---

## 시간 복잡도 & 알고리즘 선택 가이드

| 입력 크기 N          | 허용 복잡도             | 적합한 알고리즘                 |
|------------------|--------------------|--------------------------|
| N ≤ 1,000        | O(N²) 가능           | 이중 반복문, 완전 탐색            |
| N ≤ 100,000      | O(N log N) 또는 O(N) | 정렬, 이진 탐색, 해시 테이블, 투 포인터 |
| N ≤ 1,000,000 이상 | O(N) 또는 O(log N)   | 최적화된 선형 탐색, 이진 탐색        |

> **기준**: 보통 1초에 약 1억 번 연산 가능

---

## 코딩테스트 핵심 팁 요약 (Java)

1. **스택 구현** → `ArrayDeque` (push/pop/peek) 사용 — `Stack` 클래스 지양
2. **큐 구현** → `ArrayDeque` (offer/poll/peek) 사용 — `LinkedList`보다 빠름
3. **빠른 검색** → `HashMap` 또는 `HashSet` 활용 (O(1))
4. **정렬** → `Arrays.sort()` / `Collections.sort()` + `Comparator` (O(N log N))
5. **최단 경로 키워드** → BFS 우선 고려
6. **모든 경우 탐색** → 백트래킹 + 가지치기
7. **중복 계산 느낌** → DP 점화식 고민
8. **두 수의 합/연속 구간** → 투 포인터 고려
9. **정렬된 대량 데이터 탐색** → 이진 탐색 사용 (`mid = left + (right - left) / 2` 오버플로 방지)
10. **문제에서 "최소 OO", "최대 XX"** → DP 또는 이진 탐색(파라메트릭 서치) 고려

### Java 코딩테스트 필수 import

```java
import java.util.*;
import java.io.*;
```

### 자주 쓰는 입출력 패턴 (백준)

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int n = Integer.parseInt(st.nextToken());
int m = Integer.parseInt(st.nextToken());

StringBuilder sb = new StringBuilder();
sb.

append(result).

append('\n');
System.out.

print(sb);
```

---

*출처: Codetree 코테 실전 핵심노트 — Java 버전 재정리*
