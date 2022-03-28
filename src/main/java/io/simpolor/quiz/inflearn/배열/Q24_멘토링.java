package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

public class Q24_멘토링 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int answer = solution(n, m, arr);
        System.out.print(answer);
    }

    // 4중 for문...
    public static int solution(int n, int m, int[][] arr){

        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){ // 경우의 수를 구하기 위해서 학생 번호 만큼 곱

                for(int k=0; k<m; k++){
                    for(int s=0; s<n; k++){

                    }
                }
            }
        }


        return answer;
    }
}
