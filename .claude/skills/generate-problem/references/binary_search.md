# 이진 탐색 (Binary Search)

## 핵심 개념
- **정렬된 데이터**에서 중간값과 비교하며 탐색 범위를 절반씩 줄임
- 시간 복잡도: O(log N) — 1백만 개 데이터도 최대 20번 비교

## Java 구현

### 직접 구현 (반복문)
```java
static int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;  // 오버플로우 방지
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;  // 없음
}
```

### Arrays.binarySearch() 활용
```java
int[] arr = {10, 20, 30, 40, 50};
int index = Arrays.binarySearch(arr, 30);  // 2
// 없으면 -(삽입위치) - 1 반환
```

### Lower Bound / Upper Bound
```java
// lower bound: target 이상인 첫 인덱스
static int lowerBound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] < target) left = mid + 1;
        else right = mid;
    }
    return left;
}

// upper bound: target 초과인 첫 인덱스
static int upperBound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] <= target) left = mid + 1;
        else right = mid;
    }
    return left;
}
```

## 파라메트릭 서치 (Parametric Search)
- 최적화 문제를 결정 문제로 바꾸어 이진 탐색 적용
- "최솟값의 최댓값", "최댓값의 최솟값" 유형

```java
// 예: 나무 자르기 — 절단기 높이의 최댓값 구하기
static int parametricSearch(int[] trees, int target) {
    int left = 0, right = Arrays.stream(trees).max().getAsInt();
    int answer = 0;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (canCut(trees, mid, target)) {
            answer = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return answer;
}
```

## 주의사항
- 반드시 정렬된 상태에서 사용
- `mid = (left + right) / 2` 대신 `mid = left + (right - left) / 2` 사용 (오버플로우 방지)
- `left <= right` vs `left < right` 차이 주의

## 대표 문제 유형
- 정렬된 배열에서 특정 값 찾기
- 나무 자르기 (파라메트릭 서치)
- 랜선 자르기
- 입국 심사
- 징검다리
