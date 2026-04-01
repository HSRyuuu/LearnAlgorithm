---
name: generate-problem
description: 코딩테스트 문제 출제 및 풀이 환경 생성 스킬. 알고리즘/자료구조 카테고리를 선택하면 널리 알려진 코딩테스트 문제를 출제하고, solution()만 구현하면 되는 Java 보일러플레이트를 생성한다. "문제 출제", "문제 내줘", "코테 문제", "알고리즘 문제", "learning-algorithm", "문제 풀고 싶어", "연습 문제", "코딩테스트 연습" 등 요청 시 사용. 사용자가 특정 알고리즘을 언급하지 않아도 코딩테스트 연습 의도가 보이면 트리거한다.
---

# Learning Algorithm - 코딩테스트 문제 출제 스킬

코딩테스트 준비를 위한 문제 출제 스킬이다. 사용자가 알고리즘 카테고리를 선택하면 널리 알려진 문제를 출제하고, `solution()` 메서드만 구현하면 바로 채점할 수 있는 Java 파일을 생성한다.

## 워크플로우

### Step 1: 카테고리 선택

사용자에게 아래 카테고리 중 하나를 선택하도록 안내한다. 사용자가 이미 카테고리를 지정했으면 이 단계를 건너뛴다.

| 번호 | 카테고리 | 대표 유형 |
|------|----------|-----------|
| 1 | 배열 & 리스트 | 배열 조작, 연결 리스트 반전 |
| 2 | 스택 & 큐 | 괄호 검사, 대기열 처리 |
| 3 | 해시 & 집합 | 두 수의 합, 중복 제거 |
| 4 | 정렬 | K번째 수, 커스텀 정렬 |
| 5 | 이진 탐색 | 특정 값 찾기, 파라메트릭 서치 |
| 6 | 투 포인터 | 연속 구간 합, 두 수의 합 |
| 7 | 백트래킹 | 순열/조합, N-Queen |
| 8 | 동적 계획법 (DP) | 계단 오르기, 배낭 문제, LIS |
| 9 | 그래프 (DFS/BFS) | 미로 탐색, 최단 경로, 연결 요소 |
| 10 | 그리디 | 활동 선택, 거스름돈 |

난이도도 함께 물어본다:
- **입문** (Lv1 / Bronze~Silver 5): 기본 자료구조 활용
- **중급** (Lv2 / Silver 4~1): 핵심 알고리즘 적용
- **고급** (Lv3+ / Gold): 복합 알고리즘, 최적화

### Step 2: 문제 선정

선택된 카테고리의 레퍼런스 파일을 읽어 해당 알고리즘의 핵심 개념을 파악한다.

**레퍼런스 매핑:**
| 카테고리 | 레퍼런스 파일 |
|----------|-------------|
| 배열 & 리스트 | `references/array_and_list.md` |
| 스택 & 큐 | `references/stack_and_queue.md` |
| 해시 & 집합 | `references/hash_and_set.md` |
| 정렬 | `references/sorting.md` |
| 이진 탐색 | `references/binary_search.md` |
| 투 포인터 | `references/two_pointer.md` |
| 백트래킹 | `references/backtracking.md` |
| 동적 계획법 | `references/dynamic_programming.md` |
| 그래프 | `references/graph_traversal.md` |
| 그리디 | `references/greedy.md` |

그 다음, 웹 검색이나 내장 지식을 활용하여 **널리 알려진 코딩테스트 문제**를 선정한다.

문제 선정 기준:
- Programmers, 백준, LeetCode 등에서 출제된 유명한 문제
- 해당 알고리즘의 핵심 개념을 연습할 수 있는 문제
- 난이도에 맞는 문제
- 사용자가 이미 풀었던 문제는 피한다 (프로젝트 내 기존 파일명 확인)

기존 풀이 확인 방법:
```
# Glob으로 해당 알고리즘 폴더의 기존 파일들 확인
src/Algorithm/{카테고리}/*.java
src/CodingTest/{카테고리}/**/*.java
```

### Step 3: Java 파일 생성

아래 보일러플레이트 구조로 파일을 생성한다. 사용자는 `solution()` 메서드만 구현하면 된다.

**파일 위치:** `src/Algorithm/{카테고리}/` 폴더에 생성
**파일명 규칙:** `{AlgorithmName}_{ProblemName}.java` 형식
- 예: `Queue_BridgeTruck.java`, `DP_ClimbStairs.java`, `BFS_Maze.java`
- AlgorithmName: 핵심 알고리즘 (Queue, Stack, Hash, DP, BFS, DFS, Greedy, BinarySearch, TwoPointer, Backtracking 등)
- ProblemName: 문제를 영문으로 간결하게 표현 (PascalCase)

**문제 설명 파일:** 동일한 이름의 `.md` 파일을 같은 폴더에 생성
- 예: `Queue_BridgeTruck.java` → `Queue_BridgeTruck.md`
- 문제 설명, 입출력 형식, 제한 조건, 예시를 마크다운으로 작성

#### 문제 설명 파일 (.md) 템플릿

```markdown
# {문제 이름}

- **난이도**: {Lv2 / Silver 1 / Gold 5}
- **알고리즘**: {Queue, BFS, Hash 등}
- **출처**: {URL 또는 "자체 출제"}

## 문제 설명
{상세한 문제 설명}

## 입력
{입력 형식 설명}

## 출력
{출력 형식 설명}

## 제한 조건
{제한 사항 목록}

## 입출력 예시
| 입력 | 출력 |
|------|------|
| {예시 입력} | {예시 출력} |

## 입출력 예시 설명
{예시에 대한 설명}
```

#### Java 보일러플레이트 템플릿

```java
package Algorithm.{카테고리};

import java.util.*;
import static Algorithm.Base.Grader.*;

/**
 * @문제명: {문제 이름}
 * @Tear: {난이도}
 * @Algorithm: {알고리즘}
 * @Link: {출처 URL 또는 "자체 출제"}
 */
public class {AlgorithmName}_{ProblemName} {

    public static void main(String[] args) {

        // situation1: 일반적인 케이스
        {타입} input1 = {값};
        {타입} expected1 = {정답};
        {타입} result1 = solution(input1);
        grade(1, "일반 케이스 설명", expected1, result1);

        // situation2: 엣지 케이스 - {설명}
        {타입} input2 = {값};
        {타입} expected2 = {정답};
        {타입} result2 = solution(input2);
        grade(2, "엣지 케이스 설명", expected2, result2);

        // situation3: 엣지 케이스 - {설명}
        {타입} input3 = {값};
        {타입} expected3 = {정답};
        {타입} result3 = solution(input3);
        grade(3, "엣지 케이스 설명", expected3, result3);
    }

    /**
     * TODO: 이 메서드를 구현하세요!
     * {파라미터 설명}
     * @return {반환값 설명}
     */
    static {반환타입} solution({파라미터}) {
        // 여기에 풀이를 작성하세요
        return {기본값};
    }
}
```

### 보일러플레이트 작성 시 핵심 규칙

1. **테스트 케이스는 최소 3개**: 일반 케이스 1개 이상 + 엣지 케이스 2개 이상
2. **엣지 케이스 예시**:
   - 빈 배열/문자열
   - 원소가 1개인 입력
   - 최댓값/최솟값 경계
   - 모든 원소가 같은 경우
   - 이미 정렬된/역순 정렬된 입력
   - 결과가 0 또는 음수인 경우
3. **solution() 메서드**: 반환 타입과 매개변수를 정확히 설정하고, 기본 반환값을 넣어 컴파일 에러 없이 실행 가능하게 한다
4. **grade() 사용**: `import static Algorithm.Base.Grader.*;`로 임포트하여 사용. 각 문제 파일에 채점 코드를 직접 작성하지 않는다
5. **문제 설명 .md 파일**: 문제를 읽고 바로 이해할 수 있도록 충분히 상세하게 작성. 입출력 예시 포함. Java 파일과 동일한 이름으로 같은 폴더에 생성
6. **import**: 필요한 import만 추가 (java.util.* 기본 포함)
7. **파일 생성 순서**: .md 파일 먼저 생성 → .java 파일 생성

### Step 4: 힌트 제공 (선택)

파일 생성 후, 사용자에게 힌트를 줄지 물어본다:
- **힌트 없음**: 바로 풀기 시작
- **접근법 힌트**: 어떤 자료구조/알고리즘을 써야 하는지 방향만 제시
- **단계별 힌트**: 풀이 과정을 단계별로 나누어 제시

### Step 5: 풀이 검토

사용자가 solution()을 구현하고 검토를 요청하면:
1. 코드 실행 결과 확인
2. 시간/공간 복잡도 분석
3. 더 나은 풀이가 있으면 제안
4. 해당 알고리즘의 레퍼런스 내용과 연결하여 학습 포인트 정리

## 주의사항

- 문제 출처가 있으면 반드시 Link에 URL 포함
- 프로젝트의 CLAUDE.md 컨벤션(패키지명, Javadoc 헤더, 파일명)을 반드시 준수
- 문제 설명은 한국어로 작성
- solution() 내부는 절대 구현하지 않는다 (사용자가 직접 풀어야 함)
- 채점 함수(grade, format)는 항상 포함한다
