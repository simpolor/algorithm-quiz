package io.simpolor.quiz.programmers.level01;

public class Q1021 {

    /***
     * 이상한 문자 만들기
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
     * 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
     * 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
     *
     * ------------------------------
     * 제한 사항
     * ------------------------------
     * 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
     * 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * s	return
     * try hello world	TrY HeLlO WoRlD
     *
     * ------------------------------
     * 입출력 예 설명
     * ------------------------------
     * try hello world는 세 단어 try, hello, world로 구성되어 있습니다.
     * 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다.
     * 따라서 TrY HeLlO WoRlD 를 리턴합니다.
     *
     */
    public static void main(String[] args){

        String s = "try hello world";

        Solution solution = new Solution();
        String result = solution.solution(s);

        System.out.println(result);
    }


    public static class Solution {
        public String solution(String s) {

            String answer = "";

            char[] chars = s.toCharArray();
            int count = 1;
            for(char c : chars){
                if(c == ' '){
                    answer += " ";
                    count = 1;
                }else{
                    if(count % 2 == 0){
                        answer += Character.toLowerCase(c);
                    }else {
                        answer += Character.toUpperCase(c);
                    }
                    count++;
                }
            }

            return answer;
        }
    }

    public static class Solution1 {
        public String solution(String s) {

            String answer = "";
            int cnt = 0;
            String[] array = s.split("");

            for(String ss : array) {
                cnt = ss.contains(" ") ? 0 : cnt + 1;
                answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
            }
            return answer;
        }
    }

    public static class Solution2 {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            int index = 0;
            for (char c : s.toLowerCase().toCharArray()) {
                if (c == ' ') {
                    index = 0;
                    sb.append(c);
                    continue;
                }
                if (index % 2 == 0) {
                    c += 'A' - 'a';
                }
                sb.append(c);
                index++;
            }
            return sb.toString();
        }
    }

}
