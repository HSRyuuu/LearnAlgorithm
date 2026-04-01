# 정렬 (Sorting)

## 핵심 개념
- 데이터를 특정 기준으로 순서대로 재배열
- Java 내장 정렬: Dual-Pivot Quicksort (기본형) / TimSort (객체) → O(N log N) 보장

## Java 정렬 API

### 배열 정렬
```java
int[] arr = {5, 3, 1, 4, 2};
Arrays.sort(arr);                    // 오름차순 [1, 2, 3, 4, 5]
// 내림차순은 Integer[] 필요
Integer[] arr2 = {5, 3, 1, 4, 2};
Arrays.sort(arr2, Collections.reverseOrder());

// 부분 정렬
Arrays.sort(arr, fromIndex, toIndex);
```

### 리스트 정렬
```java
List<Integer> list = Arrays.asList(5, 3, 1, 4, 2);
Collections.sort(list);              // 오름차순
list.sort(Comparator.naturalOrder());
list.sort(Comparator.reverseOrder()); // 내림차순
```

### 커스텀 정렬 (Comparator)
```java
// 문자열 길이순 정렬
String[] names = {"Alice", "Bob", "Charlie"};
Arrays.sort(names, (a, b) -> a.length() - b.length());
// 또는
Arrays.sort(names, Comparator.comparingInt(String::length));

// 다중 기준 정렬: 길이 오름차순 → 같으면 사전순
Arrays.sort(names, Comparator.comparingInt(String::length)
                              .thenComparing(Comparator.naturalOrder()));

// 2차원 배열 정렬: 첫번째 원소 기준
int[][] intervals = {{3,5}, {1,3}, {2,4}};
Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
// 또는
Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
```

## 정렬 알고리즘 비교
| 알고리즘 | 시간 (평균) | 시간 (최악) | 공간 | 안정성 |
|----------|------------|------------|------|--------|
| 버블 정렬 | O(N²) | O(N²) | O(1) | 안정 |
| 선택 정렬 | O(N²) | O(N²) | O(1) | 불안정 |
| 삽입 정렬 | O(N²) | O(N²) | O(1) | 안정 |
| 병합 정렬 | O(N log N) | O(N log N) | O(N) | 안정 |
| 퀵 정렬 | O(N log N) | O(N²) | O(log N) | 불안정 |
| 힙 정렬 | O(N log N) | O(N log N) | O(1) | 불안정 |
| 계수 정렬 | O(N+K) | O(N+K) | O(K) | 안정 |

## 사용 시점
- 데이터를 순서대로 처리해야 할 때
- 이진 탐색, 투 포인터의 전처리
- K번째 작은/큰 값 찾기
- 그리디 알고리즘의 전처리

## 대표 문제 유형
- K번째 수 찾기
- 가장 큰 수 (커스텀 정렬)
- H-Index
- 회의실 배정 (구간 정렬)
- 파일명 정렬 (복합 기준)
