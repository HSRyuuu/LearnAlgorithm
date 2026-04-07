# 위장

- **난이도**: Lv2
- **알고리즘**: Hash
- **출처**: https://school.programmers.co.kr/learn/courses/30/lessons/42578

## 문제 설명

스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.

예를 들어 스파이가 가진 옷이 아래와 같고, 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 정확히 같은 조합이 아닌 다른 조합으로 옷을 입어야 합니다.

| 종류 | 이름 |
|------|------|
| 얼굴 | 동그란 안경, 검정 선글라스 |
| 상의 | 파란색 티셔츠 |
| 하의 | 청바지 |
| 겉옷 | 긴 코트 |

스파이가 가진 의상들이 담긴 2차원 배열 `clothes`가 주어질 때, 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

## 입력

- `clothes`: 2차원 문자열 배열
  - 각 행은 `[의상의 이름, 의상의 종류]`로 이루어져 있습니다.

## 출력

- 서로 다른 옷의 조합의 수 (int)

## 제한 조건

- `clothes`의 각 행은 `[의상의 이름, 의상의 종류]`로 이루어져 있습니다.
- 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
- 같은 이름을 가진 의상은 존재하지 않습니다.
- `clothes`의 모든 원소는 문자열로 이루어져 있습니다.
- 모든 문자열의 길이는 1 이상 20 이하인 자연수이고, 알파벳 소문자 또는 '_'로만 이루어져 있습니다.
- **스파이는 하루에 최소 한 개의 의상은 입습니다.**

## 입출력 예시

| clothes | return |
|---------|--------|
| `[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]` | 5 |
| `[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]` | 3 |

## 입출력 예시 설명

### 예시 1
headgear: yellow_hat, green_turban (2개)
eyewear: blue_sunglasses (1개)

가능한 조합:
1. yellow_hat
2. blue_sunglasses
3. green_turban
4. yellow_hat + blue_sunglasses
5. green_turban + blue_sunglasses

→ 총 5가지

### 예시 2
face: crow_mask, blue_sunglasses, smoky_makeup (3개)

종류가 하나뿐이므로 하나씩 입는 경우만 가능 → 총 3가지
