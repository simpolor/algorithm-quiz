package io.simpolor.quiz.programmers.Dynamic;

import java.util.Arrays;

/***
 * 도둑질
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 도둑이 어느 마을을 털 계획을 하고 있습니다. 이 마을의 모든 집들은 아래 그림과 같이 동그랗게 배치되어 있습니다.
 *
 *      집
 *  집       집
 *
 *    집   집
 *
 * 각 집들은 서로 인접한 집들과 방범장치가 연결되어 있기 때문에 인접한 두 집을 털면 경보가 울립니다.
 *
 * 각 집에 있는 돈이 담긴 배열 money가 주어질 때,
 * 도둑이 훔칠 수 있는 돈의 최댓값을 return 하도록 solution 함수를 작성하세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 이 마을에 있는 집은 3개 이상 1,000,000개 이하입니다.
 * money 배열의 각 원소는 0 이상 1,000 이하인 정수입니다.
 *
 */
public class DYNAMIC006 {

    public static void main(String[] args) {

        int[] money = new int[]{3, 2, 5};

        Solution solution = new Solution();
        int result = solution.solution(money);

        System.out.println(result);
    }

    public static class Solution1 {
        public int solution(int[] money) {
            int[][] pick = new int[2][money.length];

            pick[0][0] = money[0];
            pick[0][1] = money[0];
            pick[1][0] = 0;
            pick[1][1] = money[1];

            for(int i=2; i<money.length; i++) {
                pick[0][i] = Math.max(pick[0][i-2] + money[i], pick[0][i-1]);
                pick[1][i] = Math.max(pick[1][i-2] + money[i], pick[1][i-1]);
            }

            return Math.max(pick[0][pick[0].length-2], pick[1][pick[1].length-1]);
        }
    }

    public static class Solution {
        public int solution(int[] money) {
            int answer = 0;
            int[] dp = new int[money.length];
            dp[0] = dp[1] = money[0];
            for(int i = 2; i < money.length - 1; i++) {
                dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
            }
            answer = dp[money.length - 2];
            dp[0] = 0;
            dp[1] = money[1];
            for(int i = 2; i < money.length; i++) {
                dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
            }
            answer = Math.max(answer, dp[money.length - 1]);
            return answer;
        }
    }

    public static class Solution2 {
        public int solution(int[] money) {
            int n = money.length;
            int max[][] = new int[n][3];

            max[1][0] = money[1];
            max[1][1] = money[0];
            max[1][2] = 0;

            max[2][0] = money[2];
            max[2][1] = money[0];
            max[2][2] = money[1];

            for (int i = 3; i < n; i++) {
                max[i][0] = money[i] + max[i - 1][2];
                max[i][1] = Math.max(money[i - 1] + max[i - 2][1], max[i-1][1]);
                max[i][2] = Math.max(max[i-1][0], max[i-1][2]);
            }

            return (int) Math.max(max[n - 1][0], Math.max(max[n - 1][1], max[n - 1][2]));
        }
    }

    public static class Solution3 {
        public int solution(int[] money) {
            int answer = 0;
            int[] dp1 = new int[1000000];
            int[] dp2 = new int[1000000];

            dp1[0] = money[0];
            dp1[1] = dp1[0];
            dp2[1] = money[1];

            for(int i = 2; i < money.length - 1; i++) {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
            }
            int e = money.length - 1;
            dp1[e] = dp1[e - 1];
            dp2[e] = Math.max(dp2[e - 1], dp2[e - 2] + money[e]);
            answer = Math.max(dp1[e], dp2[e]);

            return answer;
        }
    }

    public static class Solution4 {
        public int solution(int[] money) {
            int answer = 0;

            int[] dp_front = new int[money.length-1];
            int[] dp_back = new int[money.length];

            for(int i=0,j=1;i<money.length-1;i++,j++){
                if(i==0){
                    dp_front[i] = money[i];
                    dp_back[i] = money[j];
                }else if(i==1){
                    dp_front[i] = Math.max(dp_front[i-1], money[i]);
                    dp_back[i] = Math.max(dp_back[i-1], money[j]);
                }else{
                    dp_front[i] = Math.max(dp_front[i-2]+money[i], dp_front[i-1]);
                    dp_back[i] = Math.max(dp_back[i-2]+money[j], dp_back[i-1]);
                }
            }

            answer = Math.max(dp_front[money.length-2], dp_back[money.length-2]);

            return answer;
        }
    }

    public static class Solution5 {
        public int solution(int[] money) {

            int length = money.length;

            if (length == 3) {
                return Math.max(Math.max(money[0], money[1]), money[2]);
            }

            int[] DP1 = new int[length];
            int[] DP2 = new int[length];

            DP1[0] = money[0];
            DP1[1] = money[0];

            DP2[1] = money[1];

            for (int i = 2; i < length; i++) {
                DP1[i] = Math.max(DP1[i - 1], DP1[i - 2] + money[i]);
                DP2[i] = Math.max(DP2[i - 1], DP2[i - 2] + money[i]);
            }


            return Math.max(DP1[length - 2], DP2[length - 1]);
        }
    }



}
