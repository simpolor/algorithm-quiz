package io.simpolor.quiz.programmers.condingTestPractice.hash01;

import java.util.*;

/***
 * 위장
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
 *
 * 예를 들어 스파이가 가진 옷이 아래와 같고 오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면 다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.
 *
 * 종류	이름
 * 얼굴	동그란 안경, 검정 선글라스
 * 상의	파란색 티셔츠
 * 하의	청바지
 * 겉옷	긴 코트
 * 스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 *------------------------------
 * 제한사항
 * ------------------------------
 * clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
 * 스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
 * 같은 이름을 가진 의상은 존재하지 않습니다.
 * clothes의 모든 원소는 문자열로 이루어져 있습니다.
 * 모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
 * 스파이는 하루에 최소 한 개의 의상은 입습니다.
 *
 *
 * [의상의 이름, 의상의 종류] 주의
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * clothes	return
 * [[yellow_hat, headgear], [blue_sunglasses, eyewear], [green_turban, headgear]]	5
 * [[crow_mask, face], [blue_sunglasses, face], [smoky_makeup, face]]	3
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 예제 #1
 * headgear에 해당하는 의상이 yellow_hat, green_turban이고 eyewear에 해당하는 의상이 blue_sunglasses이므로 아래와 같이 5개의 조합이 가능합니다.
 *
 * 1. yellow_hat
 * 2. blue_sunglasses
 * 3. green_turban
 * 4. yellow_hat + blue_sunglasses
 * 5. green_turban + blue_sunglasses
 *
 * 예제 #2
 * face에 해당하는 의상이 crow_mask, blue_sunglasses, smoky_makeup이므로 아래와 같이 3개의 조합이 가능합니다.
 *
 * 1. crow_mask
 * 2. blue_sunglasses
 * 3. smoky_makeup
 *
 */
public class HASH003 {

    public static void main(String[] args) {

        String[][] clothes = new String[][]{
                { "yellow_hat", "headgear" },
                { "blue_sunglasses", "eyewear" },
                { "green_turban", "headgear" },
                { "crow_mask", "face" },
        };
        /*String[][] clothes = new String[][]{
                { "crow_mask", "face" },
                { "blue_sunglasses", "face" },
                { "smoky_makeup", "face" },
        };*/

        Solution solution = new Solution();
        int result = solution.solution(clothes);

        System.out.println(result);
    }

    public static class Solution {

        // 가짓 수는 곱하기 이므로 종류 수 + ( 모자 * 안경 ) 의 공식으로 값을 구 할 수 있음
        // 3 + ( 0 * 3 ) = 3 vs 1 * ( 3 + 1 ) - 1 = 3
        // 3 + ( 1 * 2 ) = 5 vs 1 * ( 1 + 1 ) * ( 2 + 1 ) - 1
        // 4 + ( 2 * 2 ) = 8 vs 1 * ( 2 + 1 ) * ( 2 + 1 ) - 1
        // 5 + ( 2 * 3 ) = 11 vs 1 * ( 2 + 1 ) * ( 3 + 1 ) - 1
        // 6 + ( 3 * 3 ) = 15 vs 1 * ( 3 + 1 ) * ( 3 + 1 ) - 1
        // 7 + ( 3 * 4 ) = 19 vs 1 * ( 3 + 1 ) * ( 4 + 1 ) - 1
        // 4 + ( 1 * 1 * 2 ) = 11  vs 1 * ( 1 + 1 ) * ( 1 + 1 )  * ( 1 + 2 ) - 1
        public int solution(String[][] clothes) {

            Map<String, Integer> map = new HashMap();
            for(String[] strings : clothes) {
                map.put(strings[1], map.getOrDefault(strings[1], 0) + 1);
            }

            // 0으로 곱을 할 수 없으므로 1로 계산 후 최종 -1로 처리
            int answer = 1;
            Collection<Integer> values = map.values();
            for (int value : values) {
                answer *= value + 1;
            }

            return answer - 1;
        }
    }

    public static class Solution1 {
        public int solution(String[][] clothes) {

            Map<String, Integer> map = new HashMap<>();
            for (String[] strings : clothes) {
                int p = 0;
                String key = strings[1];
                if(map.containsKey(key)){
                    p = map.get(key);
                }
                map.put(key, p+1);
            }
            Collection<Integer> values = map.values();
            Integer[] counts = new Integer[values.size()];
            values.toArray(counts);

            int[][] dp = new int[values.size()][2];
            dp[0][0] = 1;
            dp[0][1] = counts[0];
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
                dp[i][1] = dp[i-1][0] * counts[i] + dp[i-1][1] * counts[i];
            }

            return dp[dp.length-1][0] + dp[dp.length-1][1] -1;
        }
    }

    public static class Solution2 {

        public int solution(String[][] clothes) {

            int answer = 0;
            ArrayList<String> clothesKinds = new ArrayList<>();
            ArrayList<ArrayList<String>> clothesBox = new ArrayList<>();
            for(String[] cloth : clothes){
                if(!clothesKinds.contains(cloth[1])){
                    //    System.out.println(cloth[1]);
                    clothesKinds.add(cloth[1]);
                    clothesBox.add(new ArrayList<>());
                }
                int indexNum = 0;
                for(String s : clothesKinds){
                    if(s.equals (cloth[1])){
                        break;
                    }
                    indexNum++;
                }
                clothesBox.get(indexNum).add(cloth[0]);
            }

            int mul = clothesBox.get(0).size()+1;
            for(int i  = 1; i<clothesBox.size(); i++){
                mul *= (clothesBox.get(i).size()+1);
            }
            System.out.println("Mul : "+mul);

            int indexNum = 0;
            for(ArrayList<String> array : clothesBox){
                System.out.print(clothesKinds.get(indexNum)+" : ");
                for(String s :  array){
                    System.out.print("\""+s+"\" ");
                }
                System.out.println();
                indexNum++;
            }
            answer = mul-1;
            return answer;
        }
    }

    public static class Solution3 {

        public int solution(String[][] clothes) {
            int answer = 0;
            HashMap<String, ArrayList<String>> clothMap = new HashMap<>();

            for (String[] line : clothes) {
                clothMap.computeIfAbsent(line[1], v -> new ArrayList<>()).add(line[0]);
            }
            if (clothMap.keySet().size() <= 1) {
                for (String key : clothMap.keySet()) {
                    return clothMap.get(key).size();
                }
            }
            int keyValCount = 1;
            for (String key : clothMap.keySet()) {
                int valSize = clothMap.get(key).size();
                keyValCount *= (valSize+1);
            }
            answer += keyValCount;

            return answer -1;
        }
    }

    public static class Solution4 {

        public int solution(String[][] clothes) {

            int answer = 1;

            HashMap<String, Integer> map = new HashMap();
            for(int i=0; i<clothes.length; i++){
                String key = clothes[i][1];
                if(!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }

            // 경우의 수를 구하기 위한 공식 ( 여기서 +1은  의상 하나만 입었을 경우에 해당? )
            Iterator<Integer> it = map.values().iterator();
            while(it.hasNext()) {
                answer *= it.next().intValue()+1;
            }

            return answer-1;
        }
    }


}
