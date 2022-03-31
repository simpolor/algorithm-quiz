package io.simpolor.quiz.inflearn.집합;

import java.util.Scanner;

// 슬라이딩 윈도우
public class Q27_최대_매출 {

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

    // 커서가 옴길때마다, 뒤에 값을 더하고 앞에 값을 뺀다.
    public static int solution(int n, int m, int[] arr){

        int answer=0, sum=0;
        for(int i=0; i<m; i++){ // 초기값 세팅
            sum += arr[i];
        }
        answer = sum;

        for(int i=m; i<n; i++){
            sum += (arr[i] - arr[i-m]); // i-m은 앞의 인덱스
            answer = Math.max(answer, sum);
        }

        return answer;
    }
}
