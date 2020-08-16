package io.simpolor.quiz.programmers.level01;

import java.util.Arrays;

public class Q1033 {

    /***
     * 핸드폰 번호 가리기
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
     * 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * arr1	arr2	return
     * [[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
     * [[1],[2]]	[[3],[4]]	[[4],[6]]
     *
     */
    public static void main(String[] args){

        int[][] arr1 = new int[][]{{1, 2}, {2, 3}};
        int[][] arr2 = new int[][]{{3, 4}, {5, 6}};

        Solution solution = new Solution();
        int[][] result = solution.solution(arr1, arr2);

        for(int i=0; i<result.length; i++){
            System.out.printf(Arrays.toString(result[i]));
        }
    }

    public static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {

            int[][] answer = new int[arr1.length][arr1[0].length]; // 확인 필요

            for(int i=0; i<arr1.length; i++){
                for(int j=0; j<arr1.length; j++){
                    answer[i][j] = arr1[i][j] + arr2[i][j];
                }
            }

            return answer;
        }
    }

    public static class Solution1 {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int lengthRow = arr1.length;
            int lengthCol = arr1[0].length;

            int[][] answer = new int[lengthRow][];
            for(int index=0; index < lengthRow ; index++) {
                answer[index] = new int[lengthCol];
            }

            for(int row=0; row < lengthRow ;row++) {
                for(int col=0; col < lengthCol ;col++) {
                    answer[row][col] = arr1[row][col] + arr2[row][col];
                }
            }

            return answer;
        }
    }

}
