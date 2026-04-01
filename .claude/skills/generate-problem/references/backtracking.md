# 백트래킹 (Backtracking)

## 핵심 개념
- 모든 가능성을 탐색하되, 조건 불만족 시 즉시 되돌아감 (가지치기)
- 재귀 함수로 구현
- 완전 탐색(Brute Force)의 최적화 버전

## 기본 패턴
```java
static void backtrack(현재상태, 결과리스트) {
    if (종료조건) {
        결과리스트.add(현재상태의_복사본);
        return;
    }
    for (선택지 : 가능한_선택들) {
        if (유망하지_않으면) continue;  // 가지치기 (pruning)
        선택();           // 상태 변경
        backtrack(다음상태, 결과리스트);
        선택취소();       // 백트래킹
    }
}
```

## 순열 (Permutation)
```java
static void permute(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
    if (current.size() == nums.length) {
        result.add(new ArrayList<>(current));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (used[i]) continue;
        used[i] = true;
        current.add(nums[i]);
        permute(nums, used, current, result);
        current.remove(current.size() - 1);
        used[i] = false;
    }
}
```

## 조합 (Combination)
```java
static void combine(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
    if (current.size() == k) {
        result.add(new ArrayList<>(current));
        return;
    }
    for (int i = start; i <= n; i++) {
        current.add(i);
        combine(n, k, i + 1, current, result);
        current.remove(current.size() - 1);
    }
}
```

## 부분집합 (Subset)
```java
static void subsets(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));  // 매 단계가 부분집합
    for (int i = start; i < nums.length; i++) {
        current.add(nums[i]);
        subsets(nums, i + 1, current, result);
        current.remove(current.size() - 1);
    }
}
```

## 가지치기 (Pruning) 전략
- 이미 답이 될 수 없는 경로는 즉시 중단
- 방문 배열(visited/used)로 중복 방지
- 합이 초과하면 더 이상 탐색하지 않음
- 정렬 후 탐색하면 가지치기가 더 효율적

## 시간 복잡도
- 순열: O(N!)
- 조합: O(C(N,K))
- 부분집합: O(2^N)
- 가지치기로 실제 탐색량은 크게 줄어듦

## 대표 문제 유형
- 순열, 조합, 부분집합 생성
- N-Queen 문제
- 스도쿠 풀기
- 타겟 넘버 (특정 합을 만드는 조합)
- 단어 검색 (Word Search)
- 소수 찾기 (숫자 카드 조합)
