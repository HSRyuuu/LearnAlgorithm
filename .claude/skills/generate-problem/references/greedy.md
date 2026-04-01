# 그리디 (Greedy)

## 핵심 개념
- 각 단계에서 **현재 가장 좋은 선택**을 하는 방법
- 탐욕적 선택 속성: 지역 최적 선택이 전역 최적으로 이어짐
- 최적 부분 구조: 부분 문제의 최적해가 전체 문제의 최적해 포함
- DP와 달리 이전 선택을 번복하지 않음

## 그리디 적용 가능 조건
1. **탐욕적 선택 속성**: 현재 최선의 선택이 이후 선택에 영향 없음
2. **최적 부분 구조**: 부분 문제의 최적해 → 전체 최적해

이 두 조건이 성립하지 않으면 DP나 완전 탐색을 고려해야 한다.

## 대표 패턴

### 패턴 1: 활동 선택 (구간 스케줄링)
```java
// 가장 많은 활동을 선택 (끝나는 시간 기준 정렬)
static int activitySelection(int[][] activities) {
    // activities[i] = {시작시간, 종료시간}
    Arrays.sort(activities, (a, b) -> a[1] - b[1]);  // 종료시간 기준 정렬
    int count = 1;
    int lastEnd = activities[0][1];
    for (int i = 1; i < activities.length; i++) {
        if (activities[i][0] >= lastEnd) {
            count++;
            lastEnd = activities[i][1];
        }
    }
    return count;
}
```

### 패턴 2: 거스름돈
```java
// 최소 동전 개수
static int minCoins(int amount, int[] coins) {
    Arrays.sort(coins);  // 오름차순 정렬
    int count = 0;
    for (int i = coins.length - 1; i >= 0; i--) {
        count += amount / coins[i];
        amount %= coins[i];
    }
    return count;
}
// 주의: 동전이 배수 관계가 아니면 그리디 불가 → DP 사용
```

### 패턴 3: 크루스칼 알고리즘 (MST)
```java
// 간선을 가중치 순으로 정렬 → Union-Find로 사이클 검사
Arrays.sort(edges, (a, b) -> a[2] - b[2]);
for (int[] edge : edges) {
    if (find(edge[0]) != find(edge[1])) {
        union(edge[0], edge[1]);
        totalWeight += edge[2];
    }
}
```

## 그리디 vs DP
| 기준 | 그리디 | DP |
|------|--------|-----|
| 접근 방식 | 현재 최적 선택 | 모든 경우 고려 |
| 선택 번복 | 안 함 | 비교 후 최적 선택 |
| 시간 복잡도 | 보통 O(N log N) | 보통 O(N²) 이상 |
| 정확성 | 조건 만족 시에만 최적 | 항상 최적 |

## 대표 문제 유형
- 체육복 (탐욕 배분)
- 큰 수 만들기 (스택 + 그리디)
- 구명보트 (투 포인터 + 그리디)
- 조이스틱
- 단속카메라 (구간 스케줄링)
- 거스름돈
- 회의실 배정
- 허프만 코딩
