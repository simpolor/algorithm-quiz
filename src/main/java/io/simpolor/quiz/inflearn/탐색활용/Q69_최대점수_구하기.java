package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Scanner;

// 부분 집합의 경우의 수와 다를께 없다.
// 문제 갯수, 제한 시간
// 점수, 분
// DFS (L, Sum, time, 배열)
public class Q69_최대점수_구하기 {

    public static int answer = Integer.MIN_VALUE;
    public static int n, m;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 갯수
        m = scanner.nextInt(); // 제한시간
        int[] scores = new int[n];
        int[] times = new int[m];
        for(int i=0; i<n; i++){
            scores[i] = scanner.nextInt(); // 점수
            times[i] = scanner.nextInt(); // 푸는데 걸리는 시간
        }
        DFS(0, 0, 0, scores, times);
        System.out.println(answer);
    }

    public static void DFS(int level, int sum, int time, int[] scores, int[] times){

        if(time > m){
            return;
        }

        if(level == n){
            answer = Math.max(answer, sum);
        }else{
            DFS(level+1, sum + scores[level], time + times[level], scores, times);
            DFS(level+1, sum, time, scores, times);
        }
    }
}
