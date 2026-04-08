package problem_solving.hash;

import java.util.*;
import java.util.stream.Collectors;

import static common.Grader.grade;

/**
 * @문제명: 베스트앨범
 * @Tear: Lv3
 * @Algorithm: Hash
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
public class LV3_베스트앨범_V1 {

    public static void main(String[] args) {

        // situation1: 기본 예시 - pop이 classic보다 재생수 많음
        String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays1 = {500, 600, 150, 800, 2500};
        int[] expected1 = {4, 1, 3, 0};
        int[] result1 = solution(genres1, plays1);
        grade(1, "기본 예시 (pop > classic)", expected1, result1);

        // situation2: 장르에 곡이 하나만 있는 경우
        String[] genres2 = {"classic", "pop", "jazz"};
        int[] plays2 = {500, 600, 900};
        int[] expected2 = {2, 1, 0};
        int[] result2 = solution(genres2, plays2);
        grade(2, "장르별 곡이 1개씩만 있는 경우", expected2, result2);

        // situation3: 같은 장르 내 재생 횟수가 같은 경우 (고유번호 낮은 순)
        String[] genres3 = {"pop", "pop", "pop"};
        int[] plays3 = {100, 100, 200};
        int[] expected3 = {2, 0};
        int[] result3 = solution(genres3, plays3);
        grade(3, "같은 재생수일 때 고유번호 낮은 순 우선", expected3, result3);

        // situation4: 장르가 여러 개이고 곡 수가 다양한 경우
        String[] genres4 = {"rock", "rock", "pop", "pop", "pop", "jazz"};
        int[] plays4 = {300, 200, 500, 100, 400, 800};
        int[] expected4 = {5, 2, 4, 0, 1};
        int[] result4 = solution(genres4, plays4);
        grade(4, "장르별 곡 수가 다양한 경우", expected4, result4);
    }

    static int[] solution(String[] genres, int[] plays) {
        // 장르 종류별 집계
        // 1. 장르별 재생수 많은 순
        // 2. 장르 내에서 재생 수 많은 순
        // 3. 재생 수 같을 경우 고유 번호가 낮은 순
        // 4. 장르별 최대 2개

        // 장르 별 재생수
        Map<String, Integer> genreCountMap = new HashMap<>();
        Map<String, PriorityQueue<Music>> genreToMusicListMap = new HashMap<>();

        // 전체 집계
        for (int i = 0; i < genres.length; i++) {
            Music music = new Music(genres[i], plays[i], i);

            genreCountMap.put(music.genre, genreCountMap.getOrDefault(music.genre, 0) + music.plays);
            if (!genreToMusicListMap.containsKey(music.genre)) {
                genreToMusicListMap.put(music.genre, createPQ());
            }
            genreToMusicListMap.get(music.genre).offer(music);
        }


        List<String> genresOrderByPlayCount = genreCountMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();
        for (String genre : genresOrderByPlayCount) {
            PriorityQueue<Music> musicList = genreToMusicListMap.get(genre);
            result.add(musicList.poll().number);
            if (!musicList.isEmpty()) {
                result.add(musicList.poll().number);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    static PriorityQueue<Music> createPQ() {
        return new PriorityQueue<>((m1, m2) -> {
            if (m2.plays == m1.plays) {
                return Integer.compare(m1.number, m2.number);
            }
            return Integer.compare(m2.plays, m1.plays);
        });
    }

    static class Music {

        String genre;
        int plays;
        int number;

        public Music(String genre, int plays, int number) {
            this.genre = genre;
            this.plays = plays;
            this.number = number;
        }
    }
}
