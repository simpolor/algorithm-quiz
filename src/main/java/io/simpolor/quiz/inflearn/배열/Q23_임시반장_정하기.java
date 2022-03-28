package io.simpolor.quiz.inflearn.배열;

import java.util.Scanner;

public class Q23_임시반장_정하기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][5];
        for(int i=0; i<n; i++){
            for(int j=0; j<5; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int answer = solution(n, arr);
        System.out.print(answer);
    }

    // 이 문제의 함정은 같은 반을 여러번 했어도, 카운트는 한번만 해야한다.!
    // 그리고, 1번부터 시작이기때문에, +1 혹은 처음부터 index를 1번부터 작는 방법을 사용해야함
    public static int solution(int n, int[][] arr){

        int answer = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){ // n명(행)

            int cnt = 0;
            for(int j=0; j<n; j++) { // n명(행)
                for(int k=0; k<5; k++){ // 학년(6반까지 고정)(열)
                    if(arr[i][k] == arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }

            if(cnt > max){
                max = cnt;
                answer = i;
            }
        }

        return answer + 1;
    }
}
