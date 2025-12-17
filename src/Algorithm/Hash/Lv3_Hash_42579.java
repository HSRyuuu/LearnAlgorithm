package Algorithm.Hash;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @문제명: 베스트앨범
 * @Tear: Lv3
 * @Algorithm: Hash
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=java
 */
public class Lv3_Hash_42579 {

    public static void main(String[] args) throws IOException {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plays);

        System.out.println(Arrays.toString(result));
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
