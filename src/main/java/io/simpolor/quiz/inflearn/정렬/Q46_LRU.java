package io.simpolor.quiz.inflearn.정렬;

import java.util.Scanner;

// LRU는 Least Recently Used의 약자로 가장 최근에 사용되지 않는 것
public class Q46_LRU {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[k];
        for(int i=0; i<k; i++){
            arr[i] = in.nextInt();
        }

        int[] answer = solution(n, k, arr);
        for(int x : answer){
            System.out.print(x + " ");
        }
    }

    // 역순 반복문 처리
    public static int[] solution(int n, int k, int[] arr){

        int[] cache = new int[n];

        for(int num : arr){
            int pos = -1;
            for(int i=0; i<n; i++){
                if(cache[i] == num){
                    pos = i;
                }
            }

            if(pos == -1){
                for(int i=n-1; i>=1; i--){
                    cache[i] = cache[i-1];
                }
            }else{ // pos가 존재하면 해당 숫자까지 밀고, 해당 숫자를 맨 앞으로 땡김
                for(int i=pos; i>=1; i--){
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = num;
        }

        return cache;
    }
}
