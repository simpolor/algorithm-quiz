package io.simpolor.quiz.programmers.ez;

public class Q003 {


    /***
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
     *
     * 입출력 예 #1
     * 문제의 예시와 같습니다.
     *
     * 입출력 예 #2
     * 9 + 8 + 7 = 24이므로 24를 return 하면 됩니다.
     */
    public static void main(String[] args){

        Solution1 solution = new Solution1();

        int n = 123;
        // int n = 987;

        System.out.println(solution.solution(n));

    }

    public static class Solution {

        public int solution(int n){

            int answer = 0;

            char[] charArray = String.valueOf(n).toCharArray();
            for(char c : charArray){
                answer += Character.getNumericValue(c);
            }

            return answer;
        }
    }

    public static class Solution1 {

        public int solution(int n){

            int answer = 0;

            while( n > 0) {
                answer += n % 10; // n 값에서 10을 나눈 후 나머지를 구함
                n = n / 10; // n 값에서 나누어 10을 나눈 후 나머지가 0이면 종료
            }

            return answer;
        }
    }

    public static class Solution2 {

        public int solution(int n){

            int answer = 0;

            while(true) {
                answer += n % 10; // n 값에서 10을 나눈 후 나머지를 구함
                if(n < 10) break;
                n = n / 10; // n 값에서 나누어 10을 나눈 후 나머지가 0이면 종료
            }

            return answer;
        }
    }

    public static class Solution3 {

        public int solution(int n){

            int answer = 0;

            String str = String.valueOf(n);
            for(int i=0; i<str.length(); i++){
                answer += Integer.parseInt(String.valueOf(str.charAt(i)));
            }

            return answer;
        }
    }

}
