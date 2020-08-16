package io.simpolor.quiz.programmers.level01;

public class Q1034 {

    /***
     * 행렬의 덧셈
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
     *
     * 전화번호가 문자열 phone_number로 주어졌을 때,
     * 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * s는 길이 4 이상, 20이하인 문자열입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * phone_number	return
     * 01033334444	*******4444
     * 027778888	*****8888
     *
     */
    public static void main(String[] args){

        String phone_number = "01033334444";
        // String phone_number = "027778888";

        Solution solution = new Solution();
        String result = solution.solution(phone_number);

        System.out.println(result);
    }

    public static class Solution {
        public String solution(String phone_number) {

            int length = phone_number.length();
            String firstNumber = phone_number.substring(0, length - 4);
            String lastNumber = phone_number.substring(length - 4, length);

            String answer = "";
            for(int i=0; i<firstNumber.length(); i++){
                answer += "*";
            }
            answer += lastNumber;

            return answer;
        }
    }

    public static class Solution1 {
        public String solution(String phone_number) {
            char[] ch = phone_number.toCharArray();
            for(int i = 0; i < ch.length - 4; i ++){
                ch[i] = '*';
            }
            return String.valueOf(ch);
        }
    }

    public static class Solution2 {
        public String solution(String phone_number) {
            return phone_number.replaceAll(".(?=.{4})", "*");
        }
    }

    public static class Solution3 {
        public String solution(String phone_number) {
            int size = phone_number.length();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<size-4; i++){
                sb.append("*");
            }
            sb.append(phone_number.substring(size-4, size));
            return sb.toString();
        }
    }

}
