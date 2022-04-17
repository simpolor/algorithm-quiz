package io.simpolor.quiz.inflearn.정렬;

import java.util.Scanner;

public class Q45_삽입정렬 {

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

    // 삽입 정렬은 i가 i+1부터 시작하며, j는 i보다 이전까지 역순으로 반복하여 앞에 숫자를 비교 삽입
    // temp에  i를 미리 값을 넣어둔다.
    public static int[] solution(int n, int[] arr){

        for(int i=1; i<n; i++){
            int temp = arr[i], j; // 이 값이 j에 찾아 들어가는 방식
            for(j=i-1; j>=0; j--){ // j 시작전 부터 i에 값은 temp에만 보관되어 있음
                if(arr[j] > temp){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = temp;
        }

        return arr;
    }
}
