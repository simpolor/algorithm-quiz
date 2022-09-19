package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 순열, 이름 그대로 순서대로 뽑아서 줄을 세우는 것을 말하며,
// 서로 다른 n개 중에서 r개를 택하여 일렬로 배열하는 경우를 말한다.
// 예를 들어) 1~5까지 적힌 카드가 한 장씩 있을 경우, 세장을 뽑아서 경우의 수를 구하는 방법은
// 5 * 4 * 3 = 60가지
public class Q72_순열_구하기 {

    public static int[] pm, ch, arr;
    public static int n, m;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        ch = new int[n];
        pm = new int[m];

        DFS(0);
    }

    public static void DFS(int level){
        if(level == m){
            for(int x : pm){
                System.out.print(x + " ");
            }
            System.out.println();
        }else{
            for(int i=0; i<n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    pm[level] = arr[i];
                    DFS(level + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
