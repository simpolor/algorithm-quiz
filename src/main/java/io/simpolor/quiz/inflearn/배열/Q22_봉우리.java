package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

// 이해가 필요한 문제
public class Q22_봉우리 {

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

    // 3중 for문, 그리고 미리 동서남북의 변수를 셋팅
    public static int solution(int n, int[][] arr){

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                boolean flag = true;
                for(int k=0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    answer++;
                }
            }
        }

        return answer;
    }
}
