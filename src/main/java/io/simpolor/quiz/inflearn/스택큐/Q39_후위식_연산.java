package io.simpolor.quiz.inflearn.스택큐;

import java.util.Scanner;
import java.util.Stack;

// 후위식 연산이란 5+3 -> 53+ 으로 표현
// 중위식에서 후위식 변환 검색하기
public class Q39_후위식_연산 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();

        int answer = solution(s);
        System.out.print(answer);
    }

    // 숫자만 스택에 넣음, 연산자를 만나면 숫자만 꺼냄
    // 첫번째 숫자는 rt, 두번째 숫자는 lt 그리고 더한값은 스택에 넣음, 다 끝나면 스택 값은 하나가 남음
    public static int solution(String s){

        Stack<Integer> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(Character.getNumericValue(c)); // 아스키넘버 '0'이 48
            }else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(c == '+') stack.push(lt + rt);
                else if(c == '-') stack.push(lt - rt);
                else if(c == '*') stack.push(lt * rt);
                else if(c == '/') stack.push(lt / rt);
            }
        }

        return stack.get(0);
    }
}
