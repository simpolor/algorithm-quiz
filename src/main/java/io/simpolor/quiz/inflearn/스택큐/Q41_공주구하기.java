package io.simpolor.quiz.inflearn.스택큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q41_공주구하기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int answer = solution(n, k);
        System.out.print(answer);
    }

    // queue는 first in first out의 자료구조
    // 데이터를 넣을때 offer를 사용하고, 꺼낼때 poll을 사용, 제일 앞의 값을 확인할때 peek
    // 해당 방법은 빼고 넣고하다가 해당 카운트가 될 경우 그냥 뺀다.
    public static int solution(int n, int k){

        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.offer(i);
        }

        while (!queue.isEmpty()){
            for(int i=1; i<k; i++){ // k-1 까지 반복문
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size() == 1){
                answer = queue.poll();
            }
        }

        return answer;
    }
}
