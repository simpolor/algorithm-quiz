package io.simpolor.quiz.programmers.level01;

public class Q025 {

    /***
     * 정수 제곱근 판별
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
     * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
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
     * ------------------------------
     * 입출력 예#2
     * ------------------------------
     * 3은 양의 정수의 제곱이 아니므로, -1을 리턴합니다.
     *
     */
    public static void main(String[] args){

        long n = 121;

        Solution solution = new Solution();
        long result = solution.solution(n);

        System.out.println(result);
    }

    public static class Solution {
        public long solution(long n) {

            Double sqrt = Math.sqrt(n); // n의 제곱근

            if(sqrt == sqrt.intValue()){
                return (long)Math.pow(sqrt + 1, 2); // a의 b승을 반환
            }

            return -1;
        }
    }

    public static class Solution1 {
        public long solution(long n) {

            if(n==1){
                return 4;
            }

            for(long i=2;i<n;i++){
                if(n/i == i && n%i ==0){
                    return (i+1)*(i+1);
                }
            }
            return -1;
        }
    }

    public static class Solution2 {
        public long solution(long num) {
            double sqrt = Math.sqrt(num);
            return (long) ((sqrt % 1) == 0 ? (sqrt + 1) * (sqrt + 1) : -1);
        }
    }

    public static class Solution3 {
        public long solution(long n) {
            long answer = 0;
            long sum =0;
            long i = 0;
            for(i = 1; sum<n;i++) {
                sum+=(i%2!=0)?i:0;
            }
            answer=(sum==n)?sum+i+1:-1;
            return answer;
        }
    }

    public static class Solution4 {
        public long solution(long n) {
            long answer = 0;
            for(double i = 1; i <= n; i++){
                if(n / i == i){
                    n = (long)(i + 1);
                    answer = (long)(n*n);
                    break;
                }
                else{
                    answer = -1;
                }
            }
            return answer;
        }
    }
}
