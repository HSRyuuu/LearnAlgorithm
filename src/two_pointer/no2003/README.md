## comments
programmers 코딩테스트 방식처럼 입력받을 값만 입력받고,
아래에 메소드로 빼서 문제푸는 습관을 들여야 겠다.

이문제는 조금 어려웠다. 다시한번 복습 ㄱㄱ

---
# 2003번 : 수들의 합 2
|시간 제한|메모리 제한|제출|정답|맞힌 사람|정답 비율|
|------|-------|---|---|----|----|
|0.5 초|128 MB|	42495|	20413	|13740|	48.316%|

## 문제
N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 이 수열의 i번째 수부터 j번째 수까지의 합 A[i] + A[i+1] + … + A[j-1] + A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

## 입력
첫째 줄에 N(1 ≤ N ≤ 10,000), M(1 ≤ M ≤ 300,000,000)이 주어진다. 다음 줄에는 A[1], A[2], …, A[N]이 공백으로 분리되어 주어진다. 각각의 A[x]는 30,000을 넘지 않는 자연수이다.

## 출력
첫째 줄에 경우의 수를 출력한다.

## 예제 입력 1
```
4 2
1 1 1 1
```
## 예제 출력 1
```
3
```
## 예제 입력 2
```
10 5
1 2 3 4 2 5 3 1 1 2
```
## 예제 출력 2
```
3
```