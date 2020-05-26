package io.simpolor.quiz.programmers.dynamic;

import java.util.Arrays;

/***
 * 등굣길
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 계속되는 폭우로 일부 지역이 물에 잠겼습니다.
 * 물에 잠기지 않은 지역을 통해 학교를 가려고 합니다.
 * 집에서 학교까지 가는 길은 m x n 크기의 격자모양으로 나타낼 수 있습니다.
 *
 * 아래 그림은 m = 4, n = 3 인 경우입니다.
 *
 * 집 ㅁ ㅁ ㅁ
 * ㅁ ㅁ ㅁ ㅁ
 * ㅁ ㅁ ㅁ 학교
 *
 *
 * 가장 왼쪽 위, 즉 집이 있는 곳의 좌표는 (1, 1)로 나타내고 가장 오른쪽 아래, 즉 학교가 있는 곳의 좌표는 (m, n)으로 나타냅니다.
 *
 * 격자의 크기 m, n과 물이 잠긴 지역의 좌표를 담은 2차원 배열 puddles이 매개변수로 주어집니다.
 *
 * 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 격자의 크기 m, n은 1 이상 100 이하인 자연수입니다.
 * m과 n이 모두 1인 경우는 입력으로 주어지지 않습니다.
 * 물에 잠긴 지역은 0개 이상 10개 이하입니다.
 * 집과 학교가 물에 잠긴 경우는 입력으로 주어지지 않습니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * m	n	puddles	return
 * 4	3	[[2, 2]]	4
 *
 * 입출력 예 설명
 * 집 ㅁ ㅁ ㅁ
 * ㅁ 물 ㅁ ㅁ
 * ㅁ ㅁ ㅁ 학교
 *
 */
public class DYNAMIC004 {

    public static void main(String[] args) {

        int m = 4;
        int n = 3;
        int[][] puddles = new int[][]{{2, 2}};
        Solution solution = new Solution();
        int result = solution.solution(m, n, puddles);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[m+1][n+1];
            for(int i=0;i<puddles.length;i++){
                dp[puddles[i][0]][puddles[i][1]]=-1;
            }
            dp[1][1]=1;
            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    if(dp[i][j]==-1){
                        dp[i][j]=0;
                        continue;
                    }
                    if(i!=1)    dp[i][j]+=dp[i-1][j]%1000000007;
                    if(j!=1)    dp[i][j]+=dp[i][j-1]%1000000007;
                }
            }
            return dp[m][n]%1000000007;
        }
    }

    public static class Solution1 {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int mod = 1000000007;
            int[][] arr = new int[n][m];

            for(int i = 0; i < puddles.length; i++) {
                arr[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
            }
            for(int i = 0; i < m; i++) {
                if(arr[0][i] == -1) {
                    break;
                }
                arr[0][i] = 1;
            }
            for(int i = 0; i < n; i++) {
                if(arr[i][0] == -1) {
                    break;
                }
                arr[i][0] = 1;
            }
            for(int i = 1; i < n; i++) {
                for(int j = 1; j < m; j++) {
                    if(arr[i][j] == -1) {
                        continue;
                    }
                    if(arr[i - 1][j] != -1 && arr[i][j - 1] != -1) {
                        arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % mod;
                    }else if(arr[i - 1][j] != -1) {
                        arr[i][j] = arr[i - 1][j];
                    }else if(arr[i][j - 1] != -1) {
                        arr[i][j] = arr[i][j - 1];
                    }
                }
            }
            answer = arr[n - 1][m - 1];
            return answer;
        }
    }

    public static class Solution2 {
        public int solution(int m, int n, int[][] puddles) {
            int[][] map= new int[n+1][m+1];
            map[1][1] = 1; //starting point
            map= puddle(map, puddles);
            return dp(map, m, n);
        }

        public int[][] puddle(int[][] map, int[][] puddles){
            for(int i=0; i<puddles.length;i++)
                map[puddles[i][1]][puddles[i][0]]= -1;
            return map;
        }

        public int dp(int[][] map, int m, int n){
            for (int j=1; j<=n; j++){
                for(int k=1; k<=m;k++){
                    if (j == 1 && k == 1)       //(1,1)은 1로 만들어두고, 0이 되지 않도록
                        continue;
                    if (map[j][k] == -1){ //웅덩이는 0으로 만들어 다음 덧셈 때 영향끼치지 않게
                        map[j][k] = 0;
                        continue;
                    }
                    map[j][k] = (map[j][k-1] + map[j-1][k]) %1000000007;
                    //[a,b] = [a-1,b] + [a,b-1] 공식
                }
            }
            return map[n][m]; // result
        }
    }

    public static class Solution3 {
        public int solution(int m, int n, int[][] puddles) {
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i], 1);
            }

            for (int[] pud : puddles) {
                int r = pud[0] - 1;
                int c = pud[1] - 1;
                dp[r][c] = 0;

                if (r == 0) {
                    for (int j = c + 1; j < n; j++) {
                        dp[0][j] = 0;
                    }
                }

                if (c == 0) {
                    for (int i = r; i < m; i++) {
                        dp[i][0] = 0;
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (dp[i][j] == 0) {
                        continue;
                    }

                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                }
            }

            return dp[m - 1][n - 1];
        }
    }






}
