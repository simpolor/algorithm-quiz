package io.simpolor.quiz.programmers.level01;

import java.util.Arrays;

public class Q1029 {

    /***
     * 최대공약수와 최소공배수
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
     * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
     * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
     *
     * ------------------------------
     * 제한 사항
     * ------------------------------
     * 두 수는 1이상 1000000이하의 자연수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * n	m	return
     * 3	12	[3, 12]
     * 2	5	[1, 10]
     *
     * ------------------------------
     * 입출력 예 설명
     * ------------------------------
     * 입출력 예 #1
     * 위의 설명과 같습니다.
     *
     * 입출력 예 #2
     * 자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
     *
     */
    public static void main(String[] args){

        int n = 2;
        int m = 5;

        Solution solution = new Solution();
        int[] result = solution.solution(n, m);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public int[] solution(int a, int b) {

            int[] answer = new int[2];

            int gob = a * b; // 최대 공배수에 두 값을 곱함

            int temp = 1; // 임시값 세팅
            while(temp != 0){
                temp = b % a; // 나머지를 구함
                b = a; // b에 a 값을 대입
                a = temp; // a에 나머지값을 대입
                // System.out.printf("%d, %d, %d%n", temp, a, b);
            }
            answer[0] = b;
            answer[1]= gob / b;

            return answer;
        }
    }

    public static class Solution1 {
        public int[] solution(int a, int b) {
            int[] answer = new int[2];
            int big,small;
            if(a>b){
                big = a;
                small = b;
            }else {
                big = b;
                small = a;
            }
            int gcd = gcd(big, small);
            answer[0] = gcd;
            answer[1] = a*b / gcd;
            return answer;
        }
        public static int gcd(int big, int small) {
            int r = big%small;
            if(r == 0) {
                return small;
            }
            return gcd(small, r);
        }
    }

    public static class Solution2 {
        public int[] solution(int n, int m) {
            int[] answer = new int[2];
            int max, min;
            if (n>m){
                max = n;
                min = m;
            }else{
                max = m;
                min = n;
            }
            int temp=min, maxTemp=max, minTemp=min;
            while (true){
                if (maxTemp%temp == 0) {
                    answer[0]=temp;
                    break;
                }else {
                    minTemp = temp;
                    temp=maxTemp%temp;
                    maxTemp = minTemp;
                }
            }
            answer[1] = max*min/answer[0];
            return answer;
        }
    }

    public static class Solution3 {
        public int[] solution(int n, int m) {
            int[] answer = new int [2];

            int tmp = 0;

            if(m < n) {
                tmp = n;
                n = m;
                m = tmp;
            }

            if(n % m == 0) {     // 약수일 경우
                answer[0] = n;
                answer[1] = m;
            } else {
                for(int i = 1; i <= m; i++) {
                    if(n % i == 0 && m % i == 0) {
                        answer[0] = i;
                        answer[1] = (n*m) / i;
                    }
                }
            }

            return answer;
        }
    }

    public static class Solution4 {
        public int findGcd(int a, int b){
            while(b!=0){
                int temp = a%b;
                a = b;
                b = temp;
            }
            return a;
        }
        public int[] solution(int n, int m) {
            int[] answer = new int[2];
            int gcd = findGcd(n, m);
            int lcm = (n*m) / gcd;
            answer[0] = gcd;
            answer[1] = lcm;
            return answer;
        }
    }

}
