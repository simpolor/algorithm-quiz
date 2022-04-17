package io.simpolor.quiz.inflearn.스택큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q42_교육과정설계 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String need = in.next();
        String plan = in.next();

        String answer = solution(need, plan);
        System.out.print(answer);
    }

    // 알파벳 갯수는 26개라는 걸 명심, 넘을 경우 중복이 가능하다는걸 유추
    // 필수과목 순서는 중복되지 않는다.
    public static String solution(String need, String plan){

        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();
        for(char c : need.toCharArray()){
            queue.offer(c);
        }

        for(char c: plan.toCharArray()){
            if(queue.contains(c)){
                if(c != queue.poll()){
                    return "NO";
                }
            }
        }

        if(!queue.isEmpty()){
            return "NO";
        }

        return answer;
    }
}
