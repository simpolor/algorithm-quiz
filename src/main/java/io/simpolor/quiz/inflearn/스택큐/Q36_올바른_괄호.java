package io.simpolor.quiz.inflearn.스택큐;

import java.util.Scanner;
import java.util.Stack;

// 스택의 대표적인 문제 ( 짝마추기 )
public class Q36_올바른_괄호 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();

        String answer = solution(s);
        System.out.print(answer);
    }

    // 여는 괄호는 스택에 넣고, 닫는 괄호는 스택에서 뺀다.
    public static String solution(String s){

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return "NO";
                }
                stack.pop();
            }
        }

        if(!stack.isEmpty()){
            return "NO";
        }


        return "YES";
    }
}
