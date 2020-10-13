package io.simpolor.quiz.programmers.level01;

import java.util.*;

public class Q_자연수_뒤집어_배열로_만들기 {

    /***
     * 자연수 뒤집어 배열로 만들기 ( 연습문제 )
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
     * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * n은 10,000,000,000이하인 자연수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * n	return
     * 12345	[5,4,3,2,1]
     *
     */
    public static void main(String[] args){

        long n = 12345;

        Solution solution = new Solution();
        int[] result = solution.solution(n);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public int[] solution(long n) {

            int length =  String.valueOf(n).length();

            int[] answer = new int[length];

            int index = 0;
            while(n > 0) {
                answer[index] = (int)(n % 10);
                n /= 10;
                index++;
            }
            return answer;
        }
    }


    public static class Solution1 {
        public int[] solution(long n) {

            Stack<Integer> stack = new Stack<>();
            char[] chars = String.valueOf(n).toCharArray();
            for(char c : chars){
                stack.add(Character.getNumericValue(c));
            }

            int[] answer = new int[stack.size()];
            for(int i=0; i<answer.length; i++){
                answer[i] = stack.pop();
            }

            return answer;
        }
    }


    public static class Solution2 {
        public int[] solution(long n) {
            String s = String.valueOf(n);
            StringBuilder sb = new StringBuilder(s);
            sb = sb.reverse();
            String[] ss = sb.toString().split("");

            int[] answer = new int[ss.length];
            for (int i=0; i<ss.length; i++) {
                answer[i] = Integer.parseInt(ss[i]);
            }
            return answer;
        }
    }

    public static class Solution3 {
        public int[] solution(long n) {
            int length = Long.toString(n).length();
            int[] answer = new int[length];

            for (int i = 0; i < length; i++) {
                answer[i] = (int) (n % 10);
                n /= 10;
            }

            return answer;
        }
    }

    public static class Solution4 {
        public int[] solution(long n) {
            char[] arr = new StringBuffer(String.valueOf(n)).reverse().toString().toCharArray();
            int[] answer = new int[arr.length];

            for(int i = 0; i < arr.length; i++){
                // 문자 '0', '1', '2'... 등을 숫자 0, 1, 2... 로 바꿔주는 것이지요. 문자 '0'의 아스키 코드 값이 48이에요.
                answer[i] = arr[i] - 48;
            }

            return answer;
        }
    }

    public static class Solution5 {
        public int[] solution(long n) {
            int[] answer;
            int count=0;
            long temp= n;
            while(temp !=0){
                count++;
                temp/=10;
            }
            answer = new int[count];
            for(int i = 0;i<count;i++){
                answer[i] =(int)(n%10);
                n/=10;
            }

            return answer;
        }
    }

    public static class Solution6 {
        public int[] solution(long n) {
            String str = n + "";
            int[] answer = new int[str.length()];

            int j = 0;
            for(int i = str.length()-1; i >= 0; i-- ){
                answer[j] = Integer.parseInt(str.charAt(i) + "");
                j++;
            }

            return answer;
        }
    }

    public static class Solution7 {
        public int[] solution(long n) {
            String number = Long.toString(n);
            int[] answer = new int[number.length()];
            int j = 0;
            for(int i=number.length()-1; i>=0; i--){
                answer[j] = Integer.parseInt(number.substring(i,i+1));
                j++;
            }

            return answer;
        }
    }

    public static class Solution8 {
        public int[] solution(long n) {
            String s = n + "";
            int[] answer = new int[s.length()];

            for(int i = s.length()-1; i >= 0; i-- ){
                answer[s.length() - (i+1)] = s.charAt(i) -'0';
            }

            return answer;
        }
    }





}
