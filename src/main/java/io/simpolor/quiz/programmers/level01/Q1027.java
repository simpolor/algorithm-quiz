package io.simpolor.quiz.programmers.level01;

public class Q1027 {

    /***
     * 짝수와 홀수
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 정수 num이 짝수일 경우 Even을 반환하고 홀수인 경우 Odd를 반환하는 함수, solution을 완성해주세요.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * num은 int 범위의 정수입니다.
     * 0은 짝수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * num	return
     * 3	Odd
     * 4	Even
     *
     */
    public static void main(String[] args){

        int num = 3;
        // int num = 4;

        Solution solution = new Solution();
        String result = solution.solution(num);

        System.out.println(result);
    }

    public static class Solution {
        public String solution(int num) {

            String answer = "Odd";
            if(num % 2 == 0){
                answer = "Even";
            }

            return answer;
        }
    }

}
