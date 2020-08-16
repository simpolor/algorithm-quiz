package io.simpolor.quiz.programmers.level01;

public class Q1017 {

    /***
     * 수박수박수박수박수박수?
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수,
     * solution을 완성하세요. 예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * n은 길이 10,000이하인 자연수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * n	return
     * 3	수박수
     * 4	수박수박
     *
     */
    public static void main(String[] args){

        int n = 3;
        //int n = 4;

        Solution solution = new Solution();
        String result = solution.solution(n);

        System.out.println(result);
    }


    public static class Solution {
        public String solution(int n) {
            String answer = "";

            for(int i=0; i<n; i++){
                if(i % 2 == 0){
                    answer += "수";
                }else{
                    answer += "박";
                }
            }

            return answer;
        }
    }

    public static class Solution1 {
        public String solution(int n) {

            String text = "수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박수박";

            return text.substring(0, n);
        }
    }

    public static class Solution2 {

        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            String word = "수박";
            char[] ch = word.toCharArray();
            for (int i = 0; i < n; i++) {
                sb.append(i % 2 == 0 ? ch[0] : ch[1]);
            }
            return sb.toString();
        }
    }

}
