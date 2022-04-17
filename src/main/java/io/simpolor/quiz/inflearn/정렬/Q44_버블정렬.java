package io.simpolor.quiz.inflearn.정렬;

import java.util.Scanner;

public class Q44_버블정렬 {

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

    // 버블 정렬은 이웃하는 두 숫자를 비교하여 작은 수를 앞으로 바꿔주는 방법
    // 첫번째 변경하면 가장 큰수가 뒤로 가게됨, 한번으로 많은걸 이룰 수가 있음
    // 비교 횟수는 뒤에서 줄어듬
    public static int[] solution(int n, int[] arr){

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){ // 반복문은 여기 핵심
                if(arr[j] > arr[j+1]){ // 알고리즘은 여기가 핵심
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }
}
