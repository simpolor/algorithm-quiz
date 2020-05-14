package io.simpolor.quiz.programmers.hash;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/***
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 [두 개씩] 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 *------------------------------
 * 제한사항
 * ------------------------------
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 *
 *------------------------------
 * 입출력 예
 * ------------------------------
 * genres	plays	return
 * [classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 *
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 *
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 *
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 *
 * ※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
 *
 */
public class HASH004 {

    public static void main(String[] args) {

        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        Solution solution = new Solution();
        int[] result = solution.solution(genres, plays);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {

        public int[] solution(String[] genres, int[] plays) {
            HashMap<String, Map<Integer, Integer>> genresMap = new HashMap<>();      //<장르, 곡 정보>
            HashMap<String, Integer> playMap = new HashMap<>(); //<장르, 총 장르 재생수>
            ArrayList<Integer> resultAL = new ArrayList<>();

            for(int i = 0; i < genres.length; i++){
                String key = genres[i];
                Map<Integer, Integer> infoMap;       // 곡 정보 : <곡 고유번호, 재생횟수>

                if(genresMap.containsKey(key)){
                    infoMap = genresMap.get(key);
                }
                else {
                    infoMap = new HashMap();
                }

                infoMap.put(i, plays[i]);
                genresMap.put(key, infoMap);

                //재생수
                if(playMap.containsKey(key)){
                    playMap.put(key, playMap.get(key) + plays[i]);
                }
                else {
                    playMap.put(key, plays[i]);
                }
            }

            Iterator it = sortByValue(playMap).iterator();

            while(it.hasNext()){
                String key = (String)it.next();

                Iterator indexIt = sortByValue(genresMap.get(key)).iterator();
                int playsCnt = 0;

                while(indexIt.hasNext()){
                    resultAL.add((int)indexIt.next());
                    playsCnt++;
                    if(playsCnt >= 2) break;
                }
            }

            int[] answer = new int[resultAL.size()];

            for(int i = 0; i < resultAL.size(); i++){
                answer[i] = resultAL.get(i).intValue();
            }

            return answer;
        }

        private ArrayList sortByValue(final Map map){
            ArrayList<Object> keyList = new ArrayList();
            keyList.addAll(map.keySet());

            Collections.sort(keyList, new Comparator(){
                public int compare(Object o1, Object o2){
                    Object v1 = map.get(o1);
                    Object v2 = map.get(o2);

                    return ((Comparable) v2).compareTo(v1);
                }
            });

            return keyList;
        }
    }

    public static class Solution1 {

        public int[] solution(String[] genres, int[] plays) {
            return IntStream.range(0, genres.length)
                    .mapToObj(i -> new Music(genres[i], plays[i], i))
                    .collect(Collectors.groupingBy(Music::getGenre))
                    .entrySet().stream()
                    .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                    .flatMap(x->x.getValue().stream().sorted().limit(2))
                    .mapToInt(x->x.id).toArray();
        }

        private int sum(List<Music> value) {
            int answer = 0;
            for (Music music : value) {
                answer+=music.played;
            }
            return answer;
        }

        public class Music implements Comparable<Music>{

            private int played;
            private int id;
            private String genre;

            public Music(String genre, int played, int id) {
                this.genre = genre;
                this.played = played;
                this.id = id;
            }

            @Override
            public int compareTo(Music other) {
                if(this.played == other.played) return this.id - other.id;
                return other.played - this.played;
            }

            public String getGenre() {return genre;}
        }


    }

}
