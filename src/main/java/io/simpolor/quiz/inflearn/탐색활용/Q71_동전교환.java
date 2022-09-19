package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Q71_동전교환 {

    public static int n, m;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = scanner.nextInt();
        DFS(0, 0, arr);
        System.out.println(answer);
    }

    public static void DFS(int level, int sum, Integer[] arr){

        if(sum > m){
            return;
        }
        if(level >= answer){
            return;
        }

        if(sum == m){
            answer = Math.min(answer, level);
        }else{
            for(int i=0; i<n; i++){
                DFS(level+1, sum+arr[i], arr);
            }
        }
    }
}
