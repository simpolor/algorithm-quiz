package io.simpolor.quiz.programmers.level01;

public class Q1010 {

    /***
     * 두 정수 사이의 합
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
     * 예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
     * a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
     * a와 b의 대소관계는 정해져있지 않습니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * a	b	return
     * 3	5	12
     * 3	3	3
     * 5	3	12
     *
     */
    public static void main(String[] args){

        int a = 3;
        int b = 5;

        /*int a = 3;
        int b = 3;*/

        /*int a = 5;
        int b = 3;*/

        Solution solution = new Solution();
        long result = solution.solution(a, b);

        System.out.println(result);
    }


    public static class Solution {
        public long solution(int a, int b) {

            long answer = 0;

            if(a < b){
                for(int i=a; i<=b; i++){
                    answer+=i;
                }
            }else{
                for(int i=b; i<=a; i++){
                    answer+=i;
                }
            }

            return answer;
        }
    }

    public static class Solution1 {
        public long solution(int a, int b) {
            long answer = 0;
            int max = a>b?a:b;
            int min = b>a?a:b;
            for(int i = min;i<=max;i++){
                answer = answer+i;
            }
            return answer;
        }
    }

    public static class Solution2 {
        public long solution(int a, int b) {

            int start = Math.min(a, b);
            int end = Math.max(a, b);
            long answer = 0;

            for(int i= start; i <= end; i++){
                answer += i;
            }

            return answer;

        }
    }

    public static class Solution3 {
        public long solution(int a, int b) {
            long answer = 0;

            if(a - b > 0){
                for(int i = 0; i<= a-b; i++){
                    answer += b + i;
                }
            } else if (a - b < 0){
                for(int i = 0; i<= b-a; i++){
                    answer += a + i;
                }
            } else  {
                answer = a;
            }

            return answer;
        }
    }

    public static class Solution4 {
        public long solution(int a, int b) {
            long answer = 0;
            int start = a > b ? b : a;
            int end = a > b ? a : b;

            while(start <= end) {
                answer += start;
                start++;
            }
            return answer;
        }
    }



}
