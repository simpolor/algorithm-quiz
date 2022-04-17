package io.simpolor.quiz.inflearn.스택큐;

import java.util.Scanner;
import java.util.Stack;

public class Q40_쇠막대기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.next();

        int answer = solution(str);
        System.out.print(answer);
    }

    // 인접한 괄호는 레이저이며, 레이저를 만났을때마다, 스택에 쌓인 갯수를 쇠막대기 자른 갯수라 생각하고 누적
    // 막대기의 끝을 만나면, pop을 만나고 +1
    // 생각해내는게 힘든 것 같음..
    public static int solution(String str){

        int answer = 0;

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push('(');
            }else{
                stack.pop();
                if(str.charAt(i -1) == '('){
                    answer += stack.size();
                }else{
                    answer++;
                }
            }
        }

        return answer;
    }
}
