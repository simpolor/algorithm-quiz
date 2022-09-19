package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Scanner;

// 핵심은 전체합과 하나의 부분 집합을 구하고, 두개를 빼면 절반으로 나눠지면 정답
public class Q67_합이_같은_부분집합 {

    public static String answer = "NO";
    public static int n, total = 0;
    public static boolean  flag = false;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
            total += arr[i];
        }
        DFS(0, 0, arr);
        System.out.println(answer);
    }

    public static void DFS(int L, int sum, int[] arr){
        if(flag){
            return;
        }

        if(sum > total/2){
            return;
        }

        if(L == n){
            if((total - sum) == sum){
                answer = "YES";
                flag = true;
            }
        }else{
            DFS(L+1, sum + arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
}
