package io.simpolor.quiz.inflearn.스택큐;

import java.util.Scanner;
import java.util.Stack;

public class Q37_괄호문자제거 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();

        String answer = solution(s);
        System.out.print(answer);
    }

    // 문자열을 계속 푸쉬 닫는 괄호를 만났을 경우 여는 괄호를 만날때까지 팝
    public static String solution(String s){

        String answer = "";

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                while (stack.pop() != '('){ } // pop은 꺼낸 값을 리턴 받는다.
            }else{
                stack.push(c);
            }
        }

        /*for(char x : stack){
            answer += x;
        }*/
        for(int i=0; i<stack.size(); i++){
            answer += stack.get(i);
        }

        return answer;
    }
}
