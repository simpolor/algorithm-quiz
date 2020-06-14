package io.simpolor.quiz.programmers.skillCheck_01;

import java.util.*;

/***
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
 * 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
 *
 * 예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.
 *
 * ------------------------------
 * 제한 조건
 * ------------------------------
 * strings는 길이 1 이상, 50이하인 배열입니다.
 * strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
 * strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
 * 모든 strings의 원소의 길이는 n보다 큽니다.
 * 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * strings	n	return
 * [sun, bed, car]	1	[car, bed, sun]
 * [abce, abcd, cdx]	2	[abcd, abce, cdx]
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 입출력 예 1
 * sun, bed, car의 1번째 인덱스 값은 각각 u, e, a 입니다.
 * 이를 기준으로 strings를 정렬하면 [car, bed, sun] 입니다.
 *
 * 입출력 예 2
 * abce와 abcd, cdx의 2번째 인덱스 값은 c, c, x입니다. 따라서 정렬 후에는 cdx가 가장 뒤에 위치합니다.
 * abce와 abcd는 사전순으로 정렬하면 abcd가 우선하므로, 답은 [abcd, abce, cdx] 입니다.
 *
 */
public class Q014 {

    public static void main(String[] args) {

        /* String[] strings = new String[]{"sun", "bed", "car"};
        int n = 1; */
        String[] strings = new String[]{"abce", "abcd", "cdx"};
        int n = 2;

        Solution solution = new Solution();
        String[] result = solution.solution(strings, n);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public String[] solution(String[] strings, int n) {

            String[] answer = new String[strings.length];

            List<String> list = new LinkedList<>();

            // 정수 n 기준으로 1글자 뽑기
            // 뽑은 글자와 strings를 결합
            for(int i=0; i<strings.length; i++){

                list.add(strings[i].charAt(n) + strings[i]);
            }

            // 정수 n 기준 정렬
            Collections.sort(list);

            // strings[i].charAt(n)을 자르고 완전한 단어로 출력
            for (int i=0; i<list.size(); i++) {

                int length = list.get(i).length();
                String word = list.get(i).substring(1, length);

                answer[i] = word;
            }

            return answer;
        }
    }

    public static class Solution1 {
        public String[] solution(String[] strings, int n) {
            String[] answer = {};

            Arrays.sort(strings, new Comparator<String>() {

                @Override
                public int compare(String arg0, String arg1) {

                    if (arg0.charAt(n) == arg1.charAt(n)) {
                        return arg0.compareTo(arg1);
                    }

                    return arg0.charAt(n) - arg1.charAt(n);
                }
            });

            answer = new String[strings.length];

            for (int i = 0; i < strings.length; i++) {
                answer[i] = strings[i];
            }

            return answer;
        }
    }

}
