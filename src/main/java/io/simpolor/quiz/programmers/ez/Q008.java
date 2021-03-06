package io.simpolor.quiz.programmers.ez;

public class Q008 {


    /***
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

        // int[] n = new int[]{1, 2, 3, 4};
        int[] n = new int[]{5, 5};

        Solution solution = new Solution();
        double result = solution.solution(n);

        System.out.println(result);
    }


    public static class Solution {

        public double solution(int[] arr){

            int count = arr.length;
            double sum = 0;

            for(int n : arr){
                sum += n;
            }

            return sum / count;
        }

    }
}
