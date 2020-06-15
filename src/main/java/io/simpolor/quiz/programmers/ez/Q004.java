package io.simpolor.quiz.programmers.ez;

import java.util.Arrays;

/***
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
 * 배열의 맨 앞에 최대공약수,
 * 그다음 최소공배수를 넣어 반환하면 됩니다.
 *
 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 *
 * 제한 사항
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
public class Q004 {

    public static void main(String[] args) {

        int n = 3;
        int m = 12;

        Solution solution = new Solution();
        int[] result = solution.solution(n, m);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public int[] solution(int n, int m) {
            int[] answer = new int[2];

            // 두 수의 크기 정렬
            int big, small;
            if( n > m){
                big = n; small = m;
            }else{
                big = m; small = n;
            }

            answer[0] = gcd(big,small);
            answer[1] = big * small / answer[0];

            return answer;
        }

        public int gcd(int a,int b){
            if(a % b == 0) {
                return b;
            }

            return gcd(b,a%b);
        }
    }

    public static class Solution1 {
        public int[] solution(int n, int m) {

            int[] answer = new int[2];

            int temp = 1;
            int gcd= n * m;

            while(temp!=0){
                temp= m % n;
                m = n;
                n = temp;
            }
            answer[0] = m;
            answer[1]= gcd / m;

            return answer;
        }
    }
}
