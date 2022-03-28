package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

// 무언가를 전체를 비교할때는 2중 for문을 사용
public class Q21_격자판_최대합 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int answer = solution(n, arr);
        System.out.print(answer);
    }

    public static int solution(int n, int[][] arr){

        int answer = Integer.MIN_VALUE;

        int sum1, sum2;
        for(int i=0; i<n; i++){

            sum1 = 0;
            sum2 = 0;
            for(int j=0; j<n; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        sum1 = 0;
        sum2 = 0;
        for(int i=0; i<n; i++){
            sum1 += arr[i][i];
            sum2 += arr[i][n-i-1]; // 처음에 0이니깐 -1를 추가
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }
}
