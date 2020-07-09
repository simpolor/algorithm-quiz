package io.simpolor.quiz.programmers.level01;

public class Q016 {

    /***
     * 소수 찾기
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
     *
     * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
     * (1은 소수가 아닙니다.)
     *
     * ------------------------------
     * 제한 조건
     * ------------------------------
     * n은 2이상 1000000이하의 자연수입니다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * n	result
     * 10	4
     * 5	3
     *
     * ------------------------------
     * 입출력 예 설명
     * ------------------------------
     * 입출력 예 #1
     * 1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환
     *
     * 입출력 예 #2
     * 1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
     *
     */
    public static void main(String[] args){

        // int n = 10;
        int n = 5;

        Solution solution = new Solution();
        int result = solution.solution(n);

        System.out.println(result);
    }


    public static class Solution {
        public int solution(int n) {

            int answer = 0;

            boolean isPrime;
            for(int i=2; i<=n; i++){

                isPrime = true;
                for(int j=2; j<i; j++){
                    if(i % j == 0){
                        isPrime = false;
                        break;
                    }
                }

                if(isPrime){
                    answer++;
                }
            }

            return answer;
        }
    }

    public static class Solution1 {
        public int solution(int n) {
            int answer = 0;

            //int n_size = n.length;
            for(int i=2;i<=n ; i++){
                int get_n = i;

                int new_n =2;
                boolean isPrime = true;
                while(new_n <= Math.sqrt(get_n)){
                    if(get_n%new_n == 0){
                        isPrime =false;
                        break;
                    }
                    new_n++;
                }
                if(isPrime){
                    //System.out.println(get_n);
                    answer++;
                }
            }
            return answer;
        }
    }

    public static class Solution2 {
        public int solution(int n) {
            int answer = 1;
            if (n>2) answer++;
            int j;
            for(int i=4;i<=n;i++){
                int k = (int)(Math.floor(Math.sqrt(i)));
                for(j=2;j<=k;j++){
                    if(i%j==0) break;
                    if(k==j) answer++;
                }
            }
            return answer;
        }
    }

    public static class Solution3 {
        public int solution(int n) {
            int answer = 0;
            for(int i=2; i<=n; i++){
                boolean isP = true;
                for(int j=2; j*j<=i; j++) {
                    if(i % j == 0) {
                        isP = false;
                        break;
                    }
                }
                if(isP) {
                    answer = answer+1;
                }
            }
            return answer;
        }
    }

    public static class Solution4 {
        public int solution(int n) {
            int answer = n-1;
            boolean[] ans = new boolean[n+1];

            for(int i=2; (i*i)<=n; i++){
                if(!ans[i]){
                    for(int j = i*i; j<=n; j+=i) {
                        if (!ans[j]) {
                            ans[j] = true;
                            answer--;
                        }
                    }
                }
            }
            return answer;
        }
    }

    public static class Solution5 {
        public int solution(int n) {
            int answer = 0;
            for(int i=2; i <= n; i++){
                if(i==2||i==3){
                    answer++;
                } else {
                    int val = (int) Math.sqrt(i);
                    for(int j = 2; j <= val; j++){
                        if(i % j == 0) {
                            break;
                        } else if(j == val){
                            answer++;
                        }
                    }
                }
            }

            return answer;
        }
    }

    public static class Solution6 {
        public int solution(int n) {
            int answer = 1;
            if(n==2) return 1;
            for(int i=2;i<=n;i++){
                int clear = 1;
                for(int j=2;j<Math.sqrt(i)+1;j++){
                    if(i%j==0){
                        clear = 0;
                        break;
                    }
                }
                if(clear==1) answer++;
            }

            return answer;
        }
    }

}
