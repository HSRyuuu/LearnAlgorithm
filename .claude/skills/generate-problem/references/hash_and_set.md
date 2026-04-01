# 해시 테이블 & 집합

## 해시 테이블 (Hash Table / HashMap)

### 핵심 개념
- 키(Key) → 값(Value) 매핑, 전화번호부와 유사
- 해시 함수로 키를 인덱스로 변환 → 빠른 조회

### 시간 복잡도
| 연산 | 평균 | 최악 |
|------|------|------|
| 삽입 | O(1) | O(N) |
| 조회 | O(1) | O(N) |
| 삭제 | O(1) | O(N) |

### Java 핵심 API
```java
Map<String, Integer> map = new HashMap<>();

// 삽입/수정
map.put("Alice", 90);
map.putIfAbsent("Bob", 85);  // 없을 때만 삽입

// 조회
map.get("Alice");              // 없으면 null
map.getOrDefault("Eve", 0);   // 없으면 기본값

// 존재 확인
map.containsKey("Alice");
map.containsValue(90);

// 삭제
map.remove("Alice");

// 순회
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    entry.getKey();
    entry.getValue();
}

// 빈도 세기 패턴
map.merge(key, 1, Integer::sum);
// 또는
map.put(key, map.getOrDefault(key, 0) + 1);
```

### 사용 시점
- 빠른 검색이 필요할 때 (키로 값 조회)
- 빈도수 세기 (각 항목의 등장 횟수)
- 두 값의 관계를 매핑할 때

---

## 집합 (Set)

### 핵심 개념
- 중복을 허용하지 않는 고유 데이터 보관
- 존재 여부 확인이 핵심

### Java 구현
```java
Set<Integer> set = new HashSet<>();
set.add(element);         // 추가 O(1)
set.remove(element);      // 삭제 O(1)
set.contains(element);    // 존재 확인 O(1)
set.size();

// 집합 연산
Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3));
Set<Integer> b = new HashSet<>(Arrays.asList(2, 3, 4));

// 교집합
Set<Integer> intersection = new HashSet<>(a);
intersection.retainAll(b);  // {2, 3}

// 합집합
Set<Integer> union = new HashSet<>(a);
union.addAll(b);  // {1, 2, 3, 4}

// 차집합
Set<Integer> diff = new HashSet<>(a);
diff.removeAll(b);  // {1}
```

---

## TreeMap / TreeSet

### 핵심 개념
- 정렬된 순서를 유지하는 Map/Set
- 내부적으로 레드-블랙 트리 사용

### Java 핵심 API
```java
TreeMap<Integer, String> treeMap = new TreeMap<>();
treeMap.firstKey();        // 최솟값 키
treeMap.lastKey();         // 최댓값 키
treeMap.floorKey(key);     // key 이하 최대 키
treeMap.ceilingKey(key);   // key 이상 최소 키

TreeSet<Integer> treeSet = new TreeSet<>();
treeSet.first();           // 최솟값
treeSet.last();            // 최댓값
treeSet.floor(element);    // element 이하 최대
treeSet.ceiling(element);  // element 이상 최소
```

| 연산 | HashMap/HashSet | TreeMap/TreeSet |
|------|-----------------|-----------------|
| 삽입/삭제/조회 | O(1) 평균 | O(log N) |
| 정렬 순서 | 보장 안됨 | 보장됨 |
| 사용 시점 | 빠른 조회 | 순서가 필요할 때 |

## 대표 문제 유형
- 완주하지 못한 선수 (빈도수)
- 전화번호 목록 (접두어 검사)
- 두 수의 합 (complement 탐색)
- 베스트앨범 (그룹핑 + 정렬)
- 의상 조합 (경우의 수)
- 고유 문자열 판별
