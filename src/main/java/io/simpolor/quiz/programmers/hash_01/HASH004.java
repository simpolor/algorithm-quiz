package io.simpolor.quiz.programmers.hash_01;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/***
 * 베스트앨범
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 [두 개씩] 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다. ( 1. 장르 우선 )
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다. ( 2. 재생 수 )
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다. ( 3. 같은 경우 고유 번호 )
 *
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
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
 * genres | plays |	return
 * [classic, pop, classic, classic, pop],	[500, 600, 150, 800, 2500],	[4, 1, 3, 0]
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


            for(int i=0; i<genres.length; i++){

            }


            return new int[0];
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

    public static class Solution2 {

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

    public static class Solution3 {
        public int[] solution(String[] genres, int[] plays) {
            List<String> generList = new ArrayList<>();
            List<List<Integer>> totalPlayList = new ArrayList<>();
            List<Integer> playList = new ArrayList<>();

            for (int index = 0; index < genres.length; index++) {
                String gener = genres[index];

                if (generList.contains(gener)) {
                    int position = generList.indexOf(gener);
                    totalPlayList.get(position).add(plays[index]);
                } else {
                    generList.add(gener);

                    List<Integer> list = new ArrayList<Integer>();
                    list.add(plays[index]);

                    totalPlayList.add(list);
                }

                playList.add(plays[index]);
            }

            List<Integer> maxCountList = new ArrayList<>();

            for (int index = 0; index < totalPlayList.size(); index++) {
                List<Integer> list = totalPlayList.get(index);
                Collections.sort(list);
                maxCountList.add(list.get(list.size() - 1));
            }

            List<Integer> sortedMaxCountList = new ArrayList<>();
            sortedMaxCountList.addAll(maxCountList);
            Collections.sort(sortedMaxCountList);

            List<Integer> result = new ArrayList<>();

            for (int index = sortedMaxCountList.size() -1; index >= 0 ; index--) {
                int maxCount = sortedMaxCountList.get(index);
                int position = maxCountList.indexOf(maxCount);
                List<Integer> list = totalPlayList.get(position);

                for (int listPosition = 0; listPosition < list.size(); listPosition++) {

                    int playItem = list.get(list.size() - listPosition - 1);
                    int playPosition = playList.indexOf(playItem);
                    result.add(playPosition);
                    playList.set(playPosition, -1);


                    if (listPosition == 1) {
                        break;
                    }
                }
            }

            int[] answer = new int[result.size()];
            for (int index = 0; index < result.size(); index++) {
                answer[index] = result.get(index);
            }

            return answer;
        }
    }

    public static class Solution4 {
        public int[] solution(String[] genres, int[] plays) {
            //int[] answer1 = new int[10000];
            List<Integer> answer1=new ArrayList<>();
            int answerNum=0;
            Map<String,Integer> ms = new HashMap<>();
            Map<Integer,String> msVal= new TreeMap<>();
            for(int i =0 ; i < genres.length;i++){
                if(ms.containsKey(genres[i]))
                    ms.put(genres[i],ms.get(genres[i])+plays[i]);
                else
                    ms.put(genres[i],plays[i]);
            }
            Set<String> keyset = ms.keySet();
            for(String key1 : keyset){
                msVal.put(ms.get(key1),key1);
            }
            Collection<String> msG1 = msVal.values();
            Stack<String> msG = new Stack<>();
            for(String kk : msG1)
                msG.push(kk);
            for(int k=0;k<ms.size();k++){
                String key2=msG.pop();
                int order=0;
                for(int i =0 ; i< genres.length;i++){
                    int max =0;
                    int code=-1;
                    for(int j =0 ; j< genres.length;j++){
                        if(key2.equals(genres[j])&&plays[j]>max){
                            max=plays[j];
                            code=j;
                        }
                    }
                    if(order<2&&code!=-1){
                        //answer1[answerNum]=code;
                        answer1.add(code);
                        answerNum++;
                        order++;
                        plays[code]=0;
                    }
                }
            }
            int[] answer = new int[answerNum];
            int ap=0;
            for(int a : answer1){
                answer[ap]=a;
                ap++;
            }
            return answer;
        }
    }

    public static class Solution5 {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer = {};
            //장르의 총 재생 횟수(해쉬맵)
            //장르별 노래 리스트( 고유번호, 플레이 수)
            HashMap<String, Integer> total = new HashMap<String,Integer>();
            for(int i=0; i<plays.length; i++){
                total.put(genres[i], total.getOrDefault(genres[i],0)+plays[i]);
            }

            TreeMap<Integer, String> sorted = new TreeMap<Integer,String>(Collections.reverseOrder());
            for(Map.Entry<String,Integer> entry : total.entrySet()){
                sorted.put(entry.getValue(), entry.getKey());
            }

            PriorityQueue<int[]>[] each_gen = new PriorityQueue[sorted.size()]; //재생 수, 고유번호
            int idx=0;
            for(Map.Entry<Integer,String> entry : sorted.entrySet()){
                String g = entry.getValue();

                each_gen[idx]=new PriorityQueue<int[]>((o1,o2)->{
                    int re = o2[0]-o1[0];
                    if(re==0) re =o1[1]-o2[1];
                    return re;
                });

                for(int i=0; i<genres.length; i++){
                    if(g.equals(genres[i])){
                        each_gen[idx].add(new int[]{ plays[i],i});
                    }
                }
                idx++;
            }

            ArrayList<Integer> list = new ArrayList<Integer>();
            for(PriorityQueue<int[]> que : each_gen){
                list.add(que.poll()[1]);
                if(!que.isEmpty())
                    list.add(que.poll()[1]);
            }

            answer=new int[list.size()];

            for(int i=0; i<list.size(); i++){
                answer[i]=list.get(i);
            }

            return answer;
        }
    }

    public static class Solution6 {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer;
            HashMap<String, Integer> sales_figure_of_genre = new HashMap<String, Integer>();
            HashMap<Integer, String[]> serial_number = new HashMap<Integer, String[]>();
            Integer ordered_sales_figure_of_genre[];
            ArrayList<String> genre_of_ranking = new ArrayList<String>();
            ArrayList<Integer> answer_list = new ArrayList<Integer>();

            for (int i = 0; i < genres.length; i++) {
                sales_figure_of_genre.put(genres[i], plays[i] + sales_figure_of_genre.getOrDefault(genres[i], 0));
                serial_number.put(i, new String[] { genres[i], plays[i] + "" });
            }

            ordered_sales_figure_of_genre = new Integer[sales_figure_of_genre.size()];
            sales_figure_of_genre.values().toArray(ordered_sales_figure_of_genre);
            Arrays.sort(ordered_sales_figure_of_genre, Collections.reverseOrder());

//              장르를 판매 수대로 정렬하여 genre_of_ranking에 넣어둔다.
            for (int sales_figure : ordered_sales_figure_of_genre) {
                for (String key : sales_figure_of_genre.keySet()) {
                    if (sales_figure_of_genre.get(key) == sales_figure) {
                        genre_of_ranking.add(key);
                    }
                }
            }

            for (String genre : genre_of_ranking) {
                ArrayList<Integer> song = new ArrayList<Integer>();
                for (int key : serial_number.keySet()) {
                    String[] info = serial_number.get(key);
                    if (genre.equals(info[0])) {
                        song.add(Integer.parseInt(info[1]));
                    }
                }
                Collections.sort(song);
                Collections.reverse(song);
                System.out.println(song);

                for (int i = 0; i < 2; i++) {
                    for (int key : serial_number.keySet()) {
                        String[] info2 = serial_number.get(key);
                        if (genre.contentEquals(info2[0]) && song.get(i).toString().equals(info2[1])) {
                            answer_list.add(key);
                            serial_number.put(key, new String[] { "", "" });
                            break;
                        }
                    }
                    if (song.size() == 1)
                        break;
                }
            }
            answer = new int[answer_list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = answer_list.get(i);
                System.out.print(answer[i] + ", ");
            }
            return answer;
        }
    }



}
