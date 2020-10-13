package io.simpolor.quiz.programmers.level01;

import java.util.Arrays;

public class Q_평균_구하기 {

    /***
     * 평균 구하기 ( 연습문제 )
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
     *
     * ------------------------------
     * 제한사항
     * ------------------------------
     * arr은 길이 1 이상, 100 이하인 배열입니다.
     * arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * arr	return
     * [1,2,3,4]	2.5
     * [5,5]	5
     *
     */
    public static void main(String[] args){

        int[] arr = new int[]{1,2,3,4};
        // int[] arr = new int[]{5,5};

        Solution solution = new Solution();
        double result = solution.solution(arr);

        System.out.println(result);
    }

    public static class Solution {
        public double solution(int[] arr) {

            double sum = 0;
            for(int num : arr){
                sum += num;
            }

            return sum / arr.length;
        }
    }

    public static class Solution1 {
        public double solution(int[] arr) {

            double sum = 0;
            for(int num : arr){
                sum += num;
            }

            double answer = sum / arr.length;
            if(sum % arr.length == 0){
                return (int)answer;
            }

            return answer;
        }
    }

    public static class Solution2 {
        public double solution(int[] arr) {
            return Arrays.stream(arr).mapToDouble(val -> Double.valueOf(val)).average().getAsDouble();
        }
    }

}
