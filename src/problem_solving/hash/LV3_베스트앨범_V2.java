package problem_solving.hash;

import java.util.*;

import static common.Grader.grade;

/**
 * @문제명: 베스트앨범
 * @Tear: Lv3
 * @Algorithm: Hash
 * @Link: https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
public class LV3_베스트앨범_V2 {

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
        if (!isvalid(genres, plays)) {
            throw new IllegalArgumentException("길이가 다름");
        }
        // 장르별 2개까지 연속 수록, 1개일 경우 1개만 / 같으면 번호 낮은 순

        Map<String, Genre> genreMap = new HashMap<>();
        PriorityQueue<Genre> genreRankingQueue = new PriorityQueue<>((o1, o2) -> o2.playTimes - o1.playTimes);

        for (int i = 0; i < genres.length; i++) {
            String genreName = genres[i];
            int playTimes = plays[i];
            Song song = new Song(genreName, playTimes, i);

            if (genreMap.containsKey(genreName)) {
                genreMap.get(genreName).addSong(song);
            } else {
                Genre genre = new Genre(genreName);
                genre.addSong(song);
                genreMap.put(genreName, genre);
                genreRankingQueue.add(genre);
            }
        }

        List<Integer> answer = new ArrayList<>();

        while (!genreRankingQueue.isEmpty()) {
            Genre genre = genreRankingQueue.poll();
            List<Integer> songNums = genre.getSongNumsTopK(2);
            answer.addAll(songNums);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    static boolean isvalid(String[] genres, int[] plays) {
        return genres.length == plays.length;
    }

    static class Song {
        String genre;
        int playTimes;
        int num;

        public Song(String genre, int playTimes, int num) {
            this.genre = genre;
            this.playTimes = playTimes;
            this.num = num;
        }
    }

    static class Genre {
        String name;
        int playTimes;
        PriorityQueue<Song> songs;

        public Genre(String name) {
            this.name = name;
            this.playTimes = 0;
            songs = createSongPQ();
        }

        private PriorityQueue<Song> createSongPQ() {
            // 1. playTimes 높은 순
            // 2, playTimes 같으면 num이 작은 순
            return new PriorityQueue<>((o1, o2) -> {
                if (o1.playTimes == o2.playTimes) {
                    return o1.num - o2.num;
                }
                return o2.playTimes - o1.playTimes;
            });
        }

        /**
         * Genre의 playTimes를 증가시키고, Song을 추가한다.
         *
         * @param song
         */
        public void addSong(Song song) {
            songs.add(song);
            this.addPlayTimes(song.playTimes);
        }

        private void addPlayTimes(int playTimes) {
            this.playTimes += playTimes;
        }

        /**
         * Song에서 Ranking k 까지의 번호를 순서대로 반환한다.
         *
         * @param k 몇개 반환?
         * @return Ranking k까지의 노래 번호가 담긴 List
         */
        public List<Integer> getSongNumsTopK(int k) {
            List<Song> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (!songs.isEmpty()) {
                    result.add(songs.poll());
                }
            }
            this.songs.addAll(result);
            return result.stream().map(it -> it.num).toList();
        }
    }
}
