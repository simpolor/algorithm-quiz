package io.simpolor.quiz.programmers.condingTestPractice.hash01;

import java.util.*;

/***
 * 완주하지 못한 선수
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다.
 * 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
 *
 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
 * 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
 * completion의 길이는 participant의 길이보다 1 작습니다.
 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
 * 참가자 중에는 동명이인이 있을 수 있습니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * participant,	    completion, 	return
 * [leo, kiki, eden],	[eden, kiki],	leo
 * [marina, josipa, nikola, vinko, filipa],	[josipa, filipa, marina, nikola],	vinko
 * [mislav, stanko, mislav, ana],	[stanko, ana, mislav],	mislav
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 예제 #1
 * leo는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
 *
 * 예제 #2
 * vinko는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
 *
 * 예제 #3
 * mislav는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
 *
 */
public class HASH001 {

    public static void main(String[] args) {

        /* String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"}; */

        /* String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"}; */

        String[] participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = new String[]{"josipa", "filipa", "marina", "marina"};

        Solution solution = new Solution();
        String result = solution.solution(participant, completion);

        System.out.println(result);
    }

    public static class Solution {

        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Map<String, Integer> marathon = new HashMap<>();

            // 참가자의 이름을 기준으로 값을 1씩 증가 ( 동일한 참자가는 중복 카운트 )
            for(String s : participant){
                marathon.put(s, marathon.getOrDefault(s, 0) + 1);
            }

            // 마라톤 완주자의 이름을 기준으로 값을 1씩 감소
            for(String s : completion){
                marathon.put(s, marathon.get(s) -1);
            }

            // 0이 아닌 경우 완주하지 못한 경우 이므로 출력
            for(String key : marathon.keySet()){
                if(marathon.get(key) != 0){
                    answer = key;
                }
            }

            return answer;
        }
    }

    public static class Solution1 {

        public String solution(String[] participant, String[] completion) {

            Arrays.sort(participant);
            Arrays.sort(completion);
            for(int i=0; i<completion.length; i++){
                if(!participant[i].equals(completion[i])) {
                    return participant[i];
                }
            }
            return participant[participant.length-1];
        }
    }


}
