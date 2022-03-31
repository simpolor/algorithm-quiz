package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

public class Q24_멘토링 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int answer = solution(n, m, arr);
        System.out.print(answer);
    }

    // 4중 for문...
    public static int solution(int n, int m, int[][] arr){

        int answer = 0;

        for(int i=1; i<=n; i++){ // 학생 번호가 1부터 n이므로 1부터 시작해야함
            for(int j=1; j<=n;  j++){ // 경우의 수를 구하기 위해서 학생 번호 만큼 곱

                int cnt = 0; // 테스트 횟수와 cnt가 동일하면 멘토 멘티 조건에 충족
                for(int k=0; k<m; k++){ // 테스트 횟수

                    int pi=0, pj=0;
                    for(int s=0; s<n; s++){ // 순위를 매기기 위한 학생의 수
                        if(arr[k][s] == i) pi = s;
                        if(arr[k][s] == j) pj = s;
                    }
                    if(pi < pj) cnt++;
                }
                if(cnt == m){
                   answer++;
                }
            }
        }

        return answer;
    }
}
