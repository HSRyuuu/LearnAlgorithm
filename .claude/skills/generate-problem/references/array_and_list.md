# 배열 & 연결 리스트

## 배열 (Array)

### 핵심 개념
- 번호(인덱스)가 매겨진 연속된 칸에 데이터를 저장
- Java: `int[]`, `String[]` 등 고정 크기 배열 + `ArrayList`(동적 배열)

### 시간 복잡도
| 연산 | 배열 | ArrayList |
|------|------|-----------|
| 인덱스 조회 | O(1) | O(1) |
| 맨 끝 추가/삭제 | - | O(1) |
| 중간 삽입/삭제 | O(N) | O(N) |
| 탐색 (값으로) | O(N) | O(N) |

### Java 핵심 API
```java
// 배열
int[] arr = new int[10];
int[] arr2 = {1, 2, 3, 4, 5};
Arrays.sort(arr);
Arrays.copyOf(arr, newLength);
Arrays.fill(arr, 0);

// ArrayList
List<Integer> list = new ArrayList<>();
list.add(element);        // 맨 끝 추가 O(1)
list.add(index, element); // 중간 삽입 O(N)
list.get(index);          // 조회 O(1)
list.set(index, element); // 수정 O(1)
list.remove(index);       // 삭제 O(N)
list.contains(element);   // 탐색 O(N)
list.size();
```

### 사용 시점
- 순서가 중요하고 특정 위치 데이터를 자주 조회할 때
- 정렬된 데이터를 다루거나 특정 구간 처리 시

---

## 연결 리스트 (Linked List)

### 핵심 개념
- 각 노드가 데이터 + 다음 노드 포인터를 가짐
- 단일 연결: 1→2→3 / 이중 연결: 1↔2↔3
- Java: `LinkedList<E>` (이중 연결 리스트)

### 시간 복잡도
| 연산 | 복잡도 |
|------|--------|
| 조회 (인덱스) | O(N) |
| 삽입/삭제 (위치 알 때) | O(1) |
| 삽입/삭제 (위치 탐색 포함) | O(N) |
| 앞/뒤 추가/삭제 | O(1) |

### Java 핵심 API
```java
LinkedList<Integer> list = new LinkedList<>();
list.addFirst(element);   // 앞에 추가 O(1)
list.addLast(element);    // 뒤에 추가 O(1)
list.removeFirst();       // 앞에서 삭제 O(1)
list.removeLast();        // 뒤에서 삭제 O(1)
list.getFirst();
list.getLast();
```

### 사용 시점
- 앞/뒤 삽입/삭제가 빈번할 때
- Queue, Deque 구현에 활용

## 대표 문제 유형
- 배열 회전 (rotate)
- 연결 리스트 반전 (reverse)
- 두 정렬된 배열 병합
- 배열에서 중복 제거
- 부분 배열의 최대 합 (Kadane's Algorithm)
- 연결 리스트에서 사이클 감지 (Floyd's Cycle Detection)
