# LearnAlgorithm

Java algorithm problem-solving study repository.   
One problem per day.
use generate-problem to setting code base

## Project Structure

```
src/
  common/             # Shared utilities (Grader.java, Main.java, Programmers.java templates)
  problem_solving/    # New problem-solving practice (organized by algorithm category)
  Algorithm/          # Programmers problems organized by algorithm (recent)
    Hash/             # Hash problems (Lv1~Lv3)
    StackQueue/       # Stack/Queue problems
    DP/               # Dynamic Programming
    bfs/              # BFS problems
  CodingTest/         # Baekjoon + Programmers problems organized by algorithm
    DP_dynamic_programming/   # DP (silver/ subfolder for tier)
    back_tracking/
    binary_search/
    brute_force/
    data_structure/           # stack, queue, deque, hash, set, map, tree, treemap, trie, priority_queue
    graph/                    # BFS, DFS, dijkstra, bellman-ford, floyd-warshall, bipartite
    greedy_algorithm/         # silver/, gold/ subfolders
    mathematics/
    sort/
    string/
    two_pointer/
  BaekJoon/           # Baekjoon problems by tier (s4, s5)
  Practice/           # Practice problems (Korean folder names)
  Programmers/        # Programmers standalone problems
```

## Conventions

### File Naming

- **Baekjoon**: `No{문제번호}.java` (e.g., `No1697.java`) or `{Tier}_No{번호}.java` (e.g., `S1_BFS_No1697.java`,
  `G5_No2493.java`)
- **Programmers**: `P{문제번호}.java` (e.g., `P42898.java`) or `Lv{레벨}_{알고리즘}_{번호}.java` (e.g., `Lv2_Queue_42583.java`)
- Tier prefixes: `S1`~`S5` (Silver), `G4`~`G5` (Gold)

### Javadoc Header (Required for every solution)

```java
/**
 * @문제명: 문제 이름
 * @Tear: Lv2 / Silver 1 / Gold 5
 * @Algorithm: Queue, BFS, Hash, etc.
 * @Link: https://...
 */
```

### Code Pattern

- Each file is a standalone solution with `public static void main(String[] args)`
- `main` method contains test cases with expected output as comments
- Solution logic in `static` methods (typically named `solution`)
- Uses `java.io.*` for I/O (BufferedReader/StringTokenizer for Baekjoon, method params for Programmers)
- Package declaration matches directory path

### Commit Message

- Follows the Javadoc header format as commit message
- Example: `/**  * @문제명: 올바른 괄호  * @Tear: Lv2  * @Algorithm: Stack  * @Link: https://...  */`

## Language

- Code comments and problem names are in Korean
- Respond in Korean when discussing problems