package io.simpolor.quiz.inflearn.정렬;

import java.util.Scanner;

public class Q43_선택정렬 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        int[] answer = solution(n, arr);
        for(int x : answer){
            System.out.print(x + " ");
        }
    }

    // 선택 정렬은 첫번째부터 순차적으로 반복문을 돌려 비교하면서 최소 값을 교환하며 정렬
    public static int[] solution(int n, int[] arr){

        for(int i=0; i<n-1; i++){
            int index = i; // 이 부분이 핵심
            for(int j=i+1; j<n; j++){
                if(arr[index] > arr[j]){
                    index = j;
                }
            }

            // i 위치에서 비교하여 변경하므로 i와 index 스왑
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        return arr;
    }
}
