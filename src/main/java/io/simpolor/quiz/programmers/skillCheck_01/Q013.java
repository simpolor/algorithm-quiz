package io.simpolor.quiz.programmers.skillCheck_01;

/***
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고,
 * n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 *
 * ------------------------------
 * 제한 사항
 * ------------------------------
 * n은 1이상, 50000000000000 이하인 양의 정수입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * n	return
 * 121	144
 * 3	-1
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 입출력 예#1
 * 121은 양의 정수 11의 제곱이므로, (11+1)를 제곱한 144를 리턴합니다.
 *
 * 입출력 예#2
 * 3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.
 *
 */
public class Q013 {

    public static void main(String[] args) {

        int n = 121;

        Solution solution = new Solution();
        long result = solution.solution(n);

        System.out.println(result);
    }

    public static class Solution {
        public long solution(long n) {

            double doubleSqrt = Math.sqrt(n);
            int intSqrt = (int)doubleSqrt;

            // pow 메소드에 두번째 인자값은 값은 지수를 뜻하며 같은 수를 2를 넣을 경우 두번 곱하여 제곱을 표현할 수 있습니다.
            return intSqrt == doubleSqrt ? (long)Math.pow(intSqrt+1, 2) : -1;
        }
    }

    public static class Solution1 {
        public long solution(long n) {

            if(n==1){
                return 4;
            }

            for(long i=2; i<n; i++){
                if(n/i == i && n % i == 0){
                    return (i+1)*(i+1);
                }
            }

            return -1;
        }
    }

    public static class Solution2 {
        public long solution(long n) {

            long answer = 0;

            for(long i=1; i<=n; i++){
                if(i*i == n){
                    answer = (i+1) * (i+1);
                    break;
                } else {
                    answer = -1;
                }
            }

            return answer;
        }
    }

}
