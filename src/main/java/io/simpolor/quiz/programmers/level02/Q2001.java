package io.simpolor.quiz.programmers.level02;

/***
 * 124 나라의 숫자
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
 *
 * 124 나라에는 자연수만 존재합니다.
 * 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
 * 예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
 *
 * 10진법	124 나라	10진법	124 나라
 * 1	1	6	14
 * 2	2	7	21
 * 3	4	8	22
 * 4	11	9	24
 * 5	12	10	41
 *
 * 자연수 n이 매개변수로 주어질 때,
 * n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * n은 500,000,000이하의 자연수 입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * n	result
 * 1	1
 * 2	2
 * 3	4
 * 4	11
 *
 */
public class Q2001 {

    public static void main(String[] args){

        // int n = 1;
        // int n = 2;
        // int n = 3;
        // int n = 4;
        // int n = 5;
        int n = 8;

        Solution solution = new Solution();
        String result = solution.solution(n);

        System.out.println(result);
    }

    public static class Solution {
        public String solution(int n) {

            String[] num = {"4","1","2"};
            String answer = "";

            while(n > 0){
                answer = num[n % 3] + answer;
                n = (n - 1) / 3;
            }
            return answer;
        }
    }

    public static class Solution1 {
        public String solution(int n) {
            String answer = "";
            int k = 0;

            while (n > 0) {
                k = n % 3; //나머지  - 자릿수 (낮은자리부터)
                n = n / 3; //몫        - 다음루프의 피제수

                if (k == 0) { // 나머지 0은 4이므로 따로 처리
                    n = n - 1; //자리올림을 안 하는 효과
                    k = 4;
                }
                answer = k + answer;
            }
            return answer;
        }
    }

    public static class Solution1_1 {
        public String solution(int n) {
            String answer = "";

            while(n > 0) {
                int x = n / 3;
                int y = n % 3;
                n /= 3;
                if (y == 0) {
                    n--;
                    y = 4;
                }

                answer = y + answer;
            }
            return answer;
        }
    }

    public static class Solution3 {
        public String solution(int n) {

            if (n > 3) {
                return solution((n - 1) / 3).concat(solution(n % 3));
            }

            String answer = "";
            if (n == 3 || n == 0) answer = "4";
            if (n == 2) answer = "2";
            if (n == 1) answer = "1";

            return answer;
        }
    }

    public static class Solution4 {
        public String solution(int n) {

            String[] arr = {"1", "2", "4"};
            String answer = "";

            while (n > 0) {
                answer = arr[(n - 1) % arr.length] + answer;
                n = (n - 1) / arr.length;
            }

            return answer;
        }
    }

    public static class Solution5 {

        public String solution(int n) {
            StringBuilder answer = new StringBuilder();
            int remainder = 0;

            while(n>0){
                remainder=n%3;
                n/=3;

                if(remainder == 0){
                    n-=1;
                    remainder=4;
                }

                answer.insert(0, remainder);
            }

            return answer.toString();
        }
    }
}
