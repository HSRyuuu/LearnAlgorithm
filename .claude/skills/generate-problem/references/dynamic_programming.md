# 동적 계획법 (Dynamic Programming, DP)

## 핵심 개념
- 큰 문제를 작은 하위 문제로 분할, 결과를 저장하여 중복 계산 제거
- 핵심 조건: **겹치는 부분 문제** + **최적 부분 구조**
- 가장 중요한 것: **점화식** 도출

## 접근 방식

### Top-Down (메모이제이션)
```java
// 재귀 + 캐싱
static int[] memo;
static int fib(int n) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];
    return memo[n] = fib(n - 1) + fib(n - 2);
}
```

### Bottom-Up (테이블)
```java
// 반복문 + dp 배열
static int fib(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0; dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}
```

## DP 문제 풀이 프레임워크
1. **상태 정의**: dp[i]가 무엇을 의미하는지 정의
2. **점화식 도출**: dp[i]와 이전 상태들의 관계
3. **초기값 설정**: 베이스 케이스 설정
4. **계산 순서 결정**: Bottom-Up이면 어떤 순서로 채울지
5. **답 도출**: dp 배열에서 최종 답 추출

## 자주 나오는 DP 유형

### 1차원 DP
```java
// 계단 오르기 (1칸 또는 2칸)
dp[i] = dp[i-1] + dp[i-2]

// 도둑질 (인접한 집 털 수 없음)
dp[i] = Math.max(dp[i-1], dp[i-2] + money[i])
```

### 2차원 DP
```java
// 최소 경로 합 (격자)
dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j]

// 배낭 문제
dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - weight[i]] + value[i])
```

### 문자열 DP
```java
// LCS (최장 공통 부분 수열)
if (s1[i] == s2[j]) dp[i][j] = dp[i-1][j-1] + 1;
else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

// 편집 거리 (Edit Distance)
if (s1[i] == s2[j]) dp[i][j] = dp[i-1][j-1];
else dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
```

### LIS (최장 증가 부분 수열)
```java
// O(N²) 풀이
dp[i] = 1;  // 자기 자신
for (int j = 0; j < i; j++) {
    if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
}

// O(N log N) 풀이: 이진 탐색 활용
```

## 단순 재귀 vs DP
| 기준 | 단순 재귀 | 동적 계획법 |
|------|----------|------------|
| 시간 복잡도 | O(2^N) | O(N) 또는 O(N²) |
| 중복 계산 | 많음 | 없음 (저장 활용) |
| 구현 | 재귀 함수 | 메모이제이션 또는 테이블 |

## 대표 문제 유형
- 피보나치 수
- 계단 오르기
- 등굣길 (격자 경로)
- 정수 삼각형
- N으로 표현 (사칙연산)
- 도둑질
- 배낭 문제 (Knapsack)
- LIS (최장 증가 부분 수열)
- LCS (최장 공통 부분 수열)
- 동전 교환 (Coin Change)
