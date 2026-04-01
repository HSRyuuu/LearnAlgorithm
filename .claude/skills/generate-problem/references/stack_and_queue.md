# 스택 & 큐

## 스택 (Stack)

### 핵심 개념
- LIFO (Last-In, First-Out): 마지막에 들어온 것이 먼저 나감
- 접시 쌓기 비유: push로 쌓고, pop으로 위에서부터 꺼냄

### 핵심 연산 (모두 O(1))
- **Push**: 맨 위에 추가
- **Pop**: 맨 위 제거 및 반환
- **Peek/Top**: 맨 위 확인 (제거 안 함)
- **isEmpty**: 비었는지 확인

### Java 구현
```java
// Deque를 스택으로 사용 (Stack 클래스보다 권장)
Deque<Integer> stack = new ArrayDeque<>();
stack.push(element);     // 추가
stack.pop();             // 제거 및 반환
stack.peek();            // 확인
stack.isEmpty();         // 비었는지
stack.size();
```

### 사용 시점
- 괄호 유효성 검사 `({[]})`
- 웹 브라우저 뒤로 가기
- 수식 계산 (후위 표기법)
- 함수 호출 스택 (재귀)
- 히스토그램에서 최대 직사각형

---

## 큐 (Queue)

### 핵심 개념
- FIFO (First-In, First-Out): 먼저 들어온 것이 먼저 나감
- 줄 서기 비유: 뒤에서 추가, 앞에서 제거

### 핵심 연산 (모두 O(1))
- **Enqueue (offer/add)**: 맨 뒤에 추가
- **Dequeue (poll/remove)**: 맨 앞 제거 및 반환
- **Peek**: 맨 앞 확인

### Java 구현
```java
Queue<Integer> queue = new LinkedList<>();
queue.offer(element);    // 추가 (add는 예외 발생 가능)
queue.poll();            // 제거 및 반환 (비었으면 null)
queue.peek();            // 확인 (비었으면 null)
queue.isEmpty();
queue.size();
```

### 사용 시점
- BFS (너비 우선 탐색)
- 프린터 작업 대기열
- 프로세스 스케줄링
- 버퍼 관리

---

## 덱 (Deque)

### 핵심 개념
- 양쪽 끝에서 삽입/삭제 가능한 자료구조
- 스택과 큐를 모두 대체 가능

### Java 구현
```java
Deque<Integer> deque = new ArrayDeque<>();
deque.offerFirst(element);  // 앞에 추가
deque.offerLast(element);   // 뒤에 추가
deque.pollFirst();           // 앞에서 제거
deque.pollLast();            // 뒤에서 제거
deque.peekFirst();
deque.peekLast();
```

---

## 우선순위 큐 (Priority Queue)

### 핵심 개념
- 우선순위가 높은 원소가 먼저 나오는 큐
- 내부적으로 힙(Heap) 자료구조 사용

### Java 구현
```java
// 최소 힙 (기본)
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
// 최대 힙
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

minHeap.offer(element);   // 추가 O(log N)
minHeap.poll();            // 최솟값 제거 O(log N)
minHeap.peek();            // 최솟값 확인 O(1)
```

## 스택 vs 큐 비교
| 기준 | 스택 | 큐 |
|------|------|-----|
| 순서 | LIFO | FIFO |
| 비유 | 접시 쌓기 | 줄 서기 |
| Java | ArrayDeque (push/pop) | LinkedList (offer/poll) |
| 사용처 | 역순 처리, 최근 작업 | 순서대로 처리, BFS |

## 대표 문제 유형
- 올바른 괄호 검사
- 다리를 지나는 트럭
- 주식 가격 (스택)
- 프로세스 스케줄링 (큐)
- 최솟값/최댓값 추적 스택
- 슬라이딩 윈도우 최댓값 (덱)
