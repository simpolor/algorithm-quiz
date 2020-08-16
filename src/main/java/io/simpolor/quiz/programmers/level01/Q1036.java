package io.simpolor.quiz.programmers.level01;

import java.util.Arrays;
import java.util.Scanner;

public class Q1036 {

    /***
     * 직사각형 별찍기
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
     * 별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * n과 m은 각각 1000 이하인 자연수입니다.
     *
     *
     * ------------------------------
     * 입력 예시
     * ------------------------------
     * 5 3
     *
     * ------------------------------
     * 출력
     * ------------------------------
     * *****
     * *****
     * *****
     *
     */
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        Solution solution = new Solution();
        String result = solution.solution(a, b);

        System.out.printf(result);
    }

    public static class Solution {
        public String solution(int a, int b) {

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<b; i++){
                for(int j=0; j<a; j++){
                    sb.append("*");
                }
                sb.append("\n");
            }

            return sb.toString();
        }
    }

    public static class Solution1 {
        public void solution(int a, int b) {

            for (int i = 0; i < b; i++) {
                for (int j = 0; j < a; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

}
