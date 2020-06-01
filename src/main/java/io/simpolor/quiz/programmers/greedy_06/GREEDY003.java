package io.simpolor.quiz.programmers.greedy_06;

import java.util.Stack;

/***
 * 큰 수 만들기
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 *
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
 * 이 중 가장 큰 숫자는 94 입니다.
 *
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
 * number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * ------------------------------
 * 제한 조건
 * ------------------------------
 * number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * number, k, return
 * 1924, 2,	94
 * 1231234,	3, 3234
 * 4177252841, 4, 775841
 *
 */
public class GREEDY003 {

    public static void main(String[] args) {

        String number = "1924";
        int k = 2;

        Solution solution = new Solution();
        String result = solution.solution(number, k);

        System.out.println(result);
    }

    public static class Solution1 {
        public String solution(String number, int k) {
            char[] result = new char[number.length() - k];
            Stack<Character> stack = new Stack<>();

            for (int i=0; i<number.length(); i++) {
                char c = number.charAt(i);
                while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                    stack.pop();
                }
                stack.push(c);
            }
            for (int i=0; i<result.length; i++) {
                result[i] = stack.get(i);
            }
            return new String(result);
        }
    }

    public static class Solution {
        public String solution(String number, int k) {

            StringBuilder sb = new StringBuilder(number);

            for (int i = 0; i+1 < sb.length() && k > 0; i++) {
                if(sb.charAt(i) < sb.charAt(i+1)) {
                    sb.deleteCharAt(i);
                    i=-1;
                    k--;
                }
            }

            if(k!=0){
                sb.delete(sb.length() - k, sb.length());
            }

            return sb.toString();
        }
    }

    public static class Solution2 {
        public String solution(String number, int k) {

            String answer = "";
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < number.length(); i++) {
                if(stack.isEmpty()) {
                    stack.add(number.charAt(i));
                }else {
                    while(!stack.isEmpty() && stack.peek() - '0' < number.charAt(i) - '0') {
                        stack.pop();
                        k--;
                        if(k == 0) {
                            break;
                        }
                    }
                    stack.add(number.charAt(i));
                }
                if(k == 0) {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.reverse().append(number.substring(i + 1));
                    break;
                }
            }
            if(k > 0) {
                while(k > 0) {
                    stack.pop();
                    k--;
                }
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                    sb.reverse();
                }
            }

            answer = sb.toString();
            return answer;
        }
    }

    public static class Solution3 {
        public String solution(String number, int k) {
            String answer = "";
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < number.length(); i++) {
                while(!stack.isEmpty() && stack.peek() - '0' < number.charAt(i) - '0' && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(number.charAt(i));
            }
            while(k > 0) {
                stack.pop();
                k--;
            }
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            answer = sb.reverse().toString();
            return answer;
        }
    }

}
