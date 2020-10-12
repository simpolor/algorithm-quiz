package io.simpolor.quiz.programmers.level01;

public class Q_가운데_글자_가져오기 {

    /***
     * 가운데 글자 가져오기 ( 연습문제 )
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
     *
     * ------------------------------
     * 재한사항
     * ------------------------------
     * s는 길이가 1 이상, 100이하인 스트링입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * s	return
     * abcde	c
     * qwer we
     *
     */
    public static void main(String[] args){

        // String s = "abcde";
        String s = "qwer";

        Solution solution = new Solution();
        String result = solution.solution(s);

        System.out.println(result);
    }


    public static class Solution {
        public String solution(String s) {

            String answer = "";

            int length = s.length();
            int div = length / 2;

            if(length % 2 == 0){
                answer = s.substring(div-1, div+1);

            }else{
                answer = s.substring(div, div+1);
            }

            return answer;
        }
    }

    public static class Solution1 {

        public String solution(String s) {
            String answer = "";

            //1-1. s의 길이
            int len = s.length();
            char[] arr = new char[2];

            //2. s의 길이 홀수
            if(len%2==1){
                arr[0] = s.charAt(len/2);
                answer = String.valueOf(arr[0]);
            }
            //3. s의 길이 짝수
            if(len%2==0){
                arr[0] = s.charAt(len/2-1);
                arr[1] = s.charAt(len/2);
                answer = String.valueOf(arr);
            }

            return answer;
        }
    }

    public static class Solution2 {

        public String solution(String s) {

            return s.substring((s.length()-1) / 2, s.length()/2 + 1);
        }
    }



}
