package io.simpolor.quiz.programmers.level01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Q020 {

    /***
     * 약수의 합
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.
     *
     * ------------------------------
     * 제한 사항
     * ------------------------------
     * n은 0 이상 3000이하인 정수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * n	return
     * 12	28
     * 5	6
     *
     * ------------------------------
     * 입출력 예 설명
     * ------------------------------
     * 입출력 예 #1
     * 12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.
     *
     * 입출력 예 #2
     * 5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.
     *
     */
    public static void main(String[] args){

        // int n = 12;
        int n = 5;

        Solution solution = new Solution();
        int result = solution.solution(n);

        System.out.println(result);
    }


    public static class Solution {
        public int solution(int n) {

            int answer = 0;

            for(int i=1; i<=n; i++){
                if(n % i == 0){
                    answer += i;
                }
            }

            return answer;
        }
    }

    public static class Solution1 {
        public int solution(int n) {
            int answer = 0;
            if(n == 0)
                return 0;

            for(int i = 1; i*i <= n; i++) {
                if(n%i == 0) {
                    if(i != n/i)
                        answer = answer + i + n / i;
                    else if(i == n/i)
                        answer = answer + i;
                }
            }

            return answer;
        }
    }

    public static class Solution2 {
        public int solution(int n) {
            return (int) (IntStream.rangeClosed(1, n / 2)
                    .filter(number -> n % number == 0)
                    .sum() + n);
        }
    }

    public static class Solution3 {
        public int solution(int n) {
            List<Integer> list = new ArrayList<>();
            for(int i=1; i<=n; i++){
                if(n%i==0) list.add(i);
            }

            return list.stream().reduce(0, Integer::sum);

        }
    }

}
