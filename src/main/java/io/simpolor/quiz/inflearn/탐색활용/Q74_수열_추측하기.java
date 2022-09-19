package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Scanner;

// 일렬로 나열하는 것은 순열
// 문제 이해가 필요, 순열구하기와 조합수 다시 볼 것
public class Q74_수열_추측하기 {

    public static int[] b, p, ch;
    public static int n, f;
    public static boolean flag = false;
    public static int[][] dy = new int[35][35];
    public static int combi(int n, int r){
        if(dy[n][r]>0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        f = scanner.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];
        for(int i=0; i<n; i++){
            b[i] = combi(n-1, i);
        }
        DFS(0, 0);
    }

    public static void DFS(int L, int sum){
        if(flag){
            return;
        }

        if(L==n){
            if(sum == f){
                for(int x : p){
                    System.out.print(x+" ");
                    flag = true;
                }
            }
        }else{
            for(int i=1; i<=n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    p[L] = i;
                    DFS(L+1, sum+(p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }
}
