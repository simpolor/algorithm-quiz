package io.simpolor.quiz.programmers.level01;

import java.util.*;

public class Q_3진법_뒤집기 {

    /***
     * 3진법 뒤집기 ( 월간 코드 챌린지 시즌1 )
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 자연수 n이 매개변수로 주어집니다.
     * n을 3진법 상에서 앞뒤로 뒤집은 후,
     * 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
     *
     * ------------------------------
     * 제한사항
     * ------------------------------
     * n은 1 이상 100,000,000 이하인 자연수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * n	result
     * 45	7
     * 125	229
     *
     * ------------------------------
     * 입출력 예 설명
     * ------------------------------
     * 입출력 예 #1
     * 답을 도출하는 과정은 다음과 같습니다.
     * n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
     * 45	1200	0021	7
     * 따라서 7을 return 해야 합니다.
     *
     * 입출력 예 #2
     * 답을 도출하는 과정은 다음과 같습니다.
     * n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
     * 125	11122	22111	229
     * 따라서 229를 return 해야 합니다.
     *
     *
     */
    public static void main(String[] args){

        int n = 45;
        //int n = 125;

        Solution solution = new Solution();
        int result = solution.solution(n);

        System.out.println(result);
    }


    public static class Solution {
        public int solution(int n) {

            StringBuilder sb = new StringBuilder();

            int mod, div;
            while (true){
                div = n / 3;
                mod = n % 3;
                n = div;
                sb.append(mod);

                if(div == 0){
                    break;
                }
            }

            int sum = 0;
            int gob = 0;
            double pow;
            String[] strings = sb.toString().split("");
            for(int i=strings.length-1; i>=0; i--){
                pow = Math.pow(3, gob);
                System.out.println(pow);
                sum += pow * Integer.parseInt(strings[i]);
                gob++;
            }

            return sum;
        }
    }

    public static class Solution1 {
        public int solution(int n) {
            int answer = 0;
            String third = Integer.toString(n, 3);
            StringBuffer sb = new StringBuffer(third);
            String reversed = sb.reverse().toString();

            int exp = 0;
            for (int i = reversed.length() - 1; i >= 0; i--) {
                answer += Integer.parseInt(String.valueOf(reversed.charAt(i))) * Math.pow(3, exp);
                exp++;
            }

            return answer;
        }
    }

    public static class Solution2 {
        public int solution(int n) {
            int answer = 0;
            List<Integer> list = new ArrayList<>();

            while(n != 0) {
                if(n%3 == 0) {
                    list.add(0);
                } else if(n%3 == 1) {
                    list.add(1);
                } else if(n%3 == 2) {
                    list.add(2);
                }
                n /= 3;
            }

            int x = 1;
            for(int i=list.size()-1; i>=0; i--) {
                answer += list.get(i)*x;
                x *= 3;
            }

            return answer;
        }
    }

    public static class Solution3 {
        public int solution(int n) {
            int answer = 0;

            Queue<Integer> queue = new LinkedList<>();

            while (n != 0) {
                int value = n % 3;
                queue.offer(value);
                n /= 3;
            }

            while (!queue.isEmpty()) {
                int pop = queue.poll();
                answer *= 3;
                answer += pop;
            }

            return answer;
        }

    }

}
