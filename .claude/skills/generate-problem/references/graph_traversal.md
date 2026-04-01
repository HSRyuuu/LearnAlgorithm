# 그래프 탐색 (DFS & BFS)

## 핵심 개념
- 그래프: 정점(Node/Vertex) + 간선(Edge)으로 구성
- 인접 리스트: `List<List<Integer>>` → O(V+E) 효율적
- 인접 행렬: `int[][]` → O(V²) 공간, 간선 존재 확인 O(1)

## 그래프 표현
```java
// 인접 리스트 (가장 많이 사용)
List<List<Integer>> graph = new ArrayList<>();
for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
graph.get(u).add(v);  // u → v 간선 추가
graph.get(v).add(u);  // 양방향이면 추가

// 인접 행렬
int[][] matrix = new int[n][n];
matrix[u][v] = 1;  // u → v 간선
```

## DFS (깊이 우선 탐색)
한 경로를 끝까지 깊게 탐색 → 스택 또는 재귀 사용

### 재귀 방식
```java
static boolean[] visited;
static void dfs(List<List<Integer>> graph, int node) {
    visited[node] = true;
    for (int next : graph.get(node)) {
        if (!visited[next]) {
            dfs(graph, next);
        }
    }
}
```

### 스택 방식
```java
static void dfsIterative(List<List<Integer>> graph, int start) {
    boolean[] visited = new boolean[graph.size()];
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(start);
    while (!stack.isEmpty()) {
        int node = stack.pop();
        if (visited[node]) continue;
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) stack.push(next);
        }
    }
}
```

## BFS (너비 우선 탐색)
가까운 노드부터 탐색 → 큐(Queue) 사용. **최단 경로** 탐색에 최적.

```java
static int bfs(List<List<Integer>> graph, int start, int target) {
    boolean[] visited = new boolean[graph.size()];
    Queue<int[]> queue = new LinkedList<>();  // {노드, 거리}
    queue.offer(new int[]{start, 0});
    visited[start] = true;

    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int node = curr[0], dist = curr[1];
        if (node == target) return dist;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                visited[next] = true;
                queue.offer(new int[]{next, dist + 1});
            }
        }
    }
    return -1;  // 도달 불가
}
```

## 2차원 격자 탐색 (미로/맵)
```java
static int[] dx = {-1, 1, 0, 0};  // 상하좌우
static int[] dy = {0, 0, -1, 1};

static int bfsGrid(int[][] grid, int sr, int sc, int er, int ec) {
    int n = grid.length, m = grid[0].length;
    boolean[][] visited = new boolean[n][m];
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{sr, sc, 0});
    visited[sr][sc] = true;

    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int x = curr[0], y = curr[1], dist = curr[2];
        if (x == er && y == ec) return dist;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m
                && !visited[nx][ny] && grid[nx][ny] == 1) {
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }
    }
    return -1;
}
```

## DFS vs BFS 비교
| 기준 | DFS | BFS |
|------|-----|-----|
| 탐색 방식 | 깊게 파고들기 | 넓게 퍼지기 |
| 자료구조 | 스택 / 재귀 | 큐 |
| 시간 복잡도 | O(V+E) | O(V+E) |
| 최단 경로 | X (가중치 없는 경우도 보장 안됨) | O (가중치 없는 그래프) |
| 메모리 | 경로 길이에 비례 | 너비에 비례 |
| 주요 용도 | 경로 존재, 사이클 탐지, 위상 정렬 | **최단 경로**, 레벨 순회 |

## 대표 문제 유형
- 미로 탐색 (최단 경로 → BFS)
- 연결 요소 개수 (connected components)
- 섬의 개수
- 숨바꼭질 (1차원 BFS)
- 토마토 (다중 시작점 BFS)
- 단어 변환
- 여행 경로 (DFS)
- 네트워크 (연결 요소)
