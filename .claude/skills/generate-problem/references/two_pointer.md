# 투 포인터 (Two Pointers)

## 핵심 개념
- 두 개의 인덱스(포인터)를 사용해 배열을 효율적으로 탐색
- O(N²)을 O(N)으로 줄일 수 있는 강력한 기법

## 패턴 1: 양쪽에서 좁혀오기

정렬된 배열에서 특정 조건을 만족하는 쌍을 찾을 때 사용.

```java
// 두 수의 합이 target인 쌍 찾기
static int[] twoSum(int[] arr, int target) {
    Arrays.sort(arr);
    int left = 0, right = arr.length - 1;
    while (left < right) {
        int sum = arr[left] + arr[right];
        if (sum == target) return new int[]{arr[left], arr[right]};
        else if (sum < target) left++;
        else right--;
    }
    return new int[]{};  // 없음
}
```

## 패턴 2: 같은 방향 이동 (슬라이딩 윈도우)

연속 부분 배열에서 조건을 만족하는 구간을 찾을 때 사용.

```java
// 합이 target 이상인 최소 길이 부분 배열
static int minSubArrayLen(int target, int[] nums) {
    int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];
        while (sum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left++];
        }
    }
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}
```

## 패턴 3: 빠른/느린 포인터

연결 리스트에서 사이클 감지, 중간 노드 찾기 등에 사용.

```java
// 연결 리스트 사이클 감지 (Floyd's Algorithm)
static boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

## 사용 시점
- 정렬된 배열에서 두 수의 합/차 조건을 만족하는 쌍 찾기
- 연속된 구간(부분 배열)의 합, 길이 최적화
- N >= 100,000 이상 대용량 데이터 처리
- "연속", "구간", "부분 배열" 키워드가 보이면 고려

## 대표 문제 유형
- 두 수의 합 (정렬 + 투 포인터)
- 연속 부분 수열의 합
- 보석과 돌
- 가장 긴 부분 문자열 (중복 없는)
- 물통 (Container With Most Water)
