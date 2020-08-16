package io.simpolor.quiz.programmers.level01;

public class Q1022 {

    /***
     * 자릿수 더하기
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
     * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
     *
     * ------------------------------
     * 제한사항
     * ------------------------------
     * N의 범위 : 100,000,000 이하의 자연수
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * N	answer
     * 123	6
     * 987	24
     *
     * ------------------------------
     * 입출력 예 설명
     * ------------------------------
     * 입출력 예 #1
     * 문제의 예시와 같습니다.
     *
     * 입출력 예 #2
     * 9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
     *
     */
    public static void main(String[] args){

        int n = 123;
        // int n = 987;

        Solution solution = new Solution();
        int result = solution.solution(n);

        System.out.println(result);
    }


    public static class Solution {
        public int solution(int n) {

            char[] chars = String.valueOf(n).toCharArray();

            int sum = 0;
            for(char c : chars){
                sum += Character.getNumericValue(c);
            }

            return sum;
        }
    }

    public static class Solution1 {
        public int solution(int n) {

            int answer = 0;

            while(true){
                answer += n % 10;
                if(n < 10) {
                    break;
                }
                n=n/10;
            }

            return answer;
        }
    }

    public static class Solution2 {
        public int solution(int n) {
            int answer = 0;
            String[] array = String.valueOf(n).split("");
            for(String s : array){
                answer += Integer.parseInt(s);
            }
            return answer;
        }
    }

    public static class Solution3 {
        public int solution(int n) {
            int answer = 0;
            int len = (int)Math.log10(n)+1;
            for(int i = 0; i < len; i++) {
                answer += n%10;
                n = n/10;
            }
            return answer;
        }
    }

    public static class Solution4 {
        public static int solution(int input) {

            int sum = 0 ;

            while(input != 0) {
                sum += input % 10;
                input /= 10;
            }

            return sum;
        }
    }



}
