package io.simpolor.quiz.inflearn.집합;

import java.util.Scanner;

// 2포인트 방식 ( rt는 0을 1로, lt는 1을 0로 변경 )
public class Q30_최대_길이_연속부분수열 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        int answer = solution(n, k, arr);
        System.out.print(answer);
    }

    // rt는 무조건 1로 바꿈, cnt가 k보다 큰 경우 lt는 1을 0으로 변경
    public static int solution(int n, int k, int[] arr){

        int answer=0, cnt=0, lt=0;

        for(int rt=0; rt<n; rt++){

            if(arr[rt] == 0){
                cnt++;
            }

            while (cnt > k){ // lt가 0인 경우 cnt를 감소 시키기 위한 구문
                if(arr[lt] == 0){
                    cnt--;
                }
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }
}
