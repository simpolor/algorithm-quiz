package io.simpolor.quiz.inflearn.해쉬;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Q35_K번째_큰_수 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }

        int answer = solution(n, m, arr);
        System.out.print(answer);
    }

    // 3중 for문 사용과 Set 사용이 핵심 ( 그 중에 정렬해주는 TreeSet 사용 )
    // m은 역정렬의 번째를 출력하므로 문제 이해가 핵심..
    public static int solution(int n, int m, int[] arr){

        int answer = -1;

        // first() 함수는 정렬에 따라, 최대값과 최소값을 출력
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    treeSet.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        int cnt = 1;
        for(int num : treeSet){
            if(cnt == m){
                answer = num;
                break;
            }
            cnt++;
        }

        return answer;
    }
}
