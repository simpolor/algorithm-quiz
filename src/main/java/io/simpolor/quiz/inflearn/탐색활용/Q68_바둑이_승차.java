package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Scanner;

// 부분집합은 DFS 문제
public class Q68_바둑이_승차 {

    public static int answer = Integer.MIN_VALUE;
    public static int n, c;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        DFS(0, 0, arr);
        System.out.println(answer);
    }

    public static void DFS(int L, int sum, int[] arr){
        if(sum > c){
            return;
        }

        if(L == n){ // 부분집의 완성은 L과 n이 같은 마지막 깊이까지 갔을 경우 계산
            answer = Math.max(answer, sum);

        }else{
            DFS(L+1, sum + arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
}
