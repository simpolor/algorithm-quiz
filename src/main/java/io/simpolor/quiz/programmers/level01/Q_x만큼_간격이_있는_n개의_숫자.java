package io.simpolor.quiz.programmers.level01;

import java.util.Arrays;

public class Q_x만큼_간격이_있는_n개의_숫자 {

    /***
     * x만큼 간격이 있는 n개의 숫자 ( 연습문제 )
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
     * 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * x는 -10000000 이상, 10000000 이하인 정수입니다.
     * n은 1000 이하인 자연수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * x	n	answer
     * 2	5	[2,4,6,8,10]
     * 4	3	[4,8,12]
     * -4	2	[-4, -8]
     *
     */
    public static void main(String[] args){

        // int x = 2; int n = 5;
        // int x = 4; int n = 3;
        int x = -4; int n = 2;

        Solution solution = new Solution();
        long[] result = solution.solution(x, n);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public long[] solution(int x, int n) {

            long[] answer = new long[n];
            for(int i=1; i<=n; i++){
                answer[i-1] = x * i;
            }

            return answer;
        }
    }

    public static class Solution2 {
        public long[] solution(long x, int n) {
            long[] answer = new long[n];
            for(int i = 0; i < n; i++){
                answer[i] = x * (i + 1);
            }
            return answer;
        }
    }

    public static class Solution3 {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            for(int i=1; i<=n; i++){
                answer[i-1] = (long)x*i;
            }
            return answer;
        }
    }

    public static class Solution4 {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            long sum = 0;
            for(int i = 0;i<answer.length;i++){
                sum += x;
                answer[i] = sum;
            }


            return answer;
        }
    }

    public static class Solution5 {
        public long[] solution(int x, int n) {
            long[] answer = {};

            answer = new long[n];
            int i,j;
            if(x>=-10000000 && x<=10000000 &&  n>0 && n<=1000) {
                for(i=0;i<n;i++){
                    long tmp = Long.valueOf(x)*(i+1);
                    answer[i]= tmp;
                }
            }
            return answer;
        }
    }

    public static class Solution6 {
        public long[] solution(int x, int n) {
            long[] answer = {};
            answer = new long[n];
            long y = (long)x;
            for(long i = 0; i<answer.length;i++)
            {
                answer[(int)i] = y*(i+1);
            }
            return answer;
        }
    }

    public static class Solution7 {
        public long[] solution(int x, int n) {
            long[] answer = new long[n];
            int count = 0;
            long value = x;
            while(count<n){
                answer[count] = value;
                value = value+x;
                count++;
            }

            return answer;
        }
    }


}
