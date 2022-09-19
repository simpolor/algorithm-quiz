package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Scanner;

// 다음 레벨때, +1하여 구하는 것을 말함
public class Q75_조합_구하기 {

    public static int[] combi;
    public static int n, m;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        combi = new int[m];
        DFS(0, 1 );
    }

    public static void DFS(int L, int s){
        if(L == m){
            for(int x : combi){
                System.out.print(x + " ");
            }
            System.out.println();
        }else{
            for(int i=s; i<=n; i++){
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
}
