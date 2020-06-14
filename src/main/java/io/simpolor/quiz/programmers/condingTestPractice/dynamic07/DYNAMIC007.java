package io.simpolor.quiz.programmers.condingTestPractice.dynamic07;

import java.util.Arrays;

/***
 * 서울에서 경산까지
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 서울에서 경산까지 여행을 하면서 모금 활동을 하려 합니다.
 * 여행은 서울에서 출발해 다른 도시를 정해진 순서대로 딱 한 번 방문한 후 경산으로 도착할 예정입니다.
 * 도시를 이동할 때에는 도보 혹은 자전거를 이용합니다.
 * 이때 도보 이동에 걸리는 시간, 도보 이동 시 얻을 모금액, 자전거 이동에 걸리는 시간, 자전거 이동 시 얻을 모금액이 정해져 있습니다.
 * K시간 이내로 여행할 때 모을 수 있는 최대 모금액을 알아보려 합니다.
 *
 * 예를 들어 여행 루트가 다음과 같고 K = 1,650 일 때
 *
 *    도보로 이동     도보로 이동     도보로 이동
 *   시간 : 500분   시간 : 800분   시간 : 700분
 *   모금 : 200원   모금 : 370원   모금 : 250원
 * 서울 -------> 도시A -------> 도시B -------> 경산
 *    자전거 이동     자전거 이동     자전거 이동
 *   시간 : 200분   시간 : 300분   시간 : 300분
 *   모금 : 100원   모금 : 120원   모금 : 90원
 *
 * 1, 2번 구간은 도보로, 3번 구간은 자전거로 이동해 모금액을 660으로 하는 것이 가장 좋은 방법입니다. 이때, 1,600시간이 소요됩니다.
 *
 * solution 함수의 매개변수로 각 도시를 이동할 때 이동 수단별로 걸리는 시간과 모금액을 담은 2차원 배열 travel과 제한시간 K가 주어집니다.
 * 제한시간 안에 서울에서 경산까지 여행을 하며 모을 수 있는 최대 모금액을 return 하도록 solution 함수를 작성하세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * travel 배열의 각 행은 순서대로 [도보 이동에 걸리는 시간, 도보 이동 시 얻을 모금액, 자전거 이동에 걸리는 시간, 자전거 이동 시 얻을 모금액]입니다.
 * travel 배열 행의 개수는 3 이상 100 이하인 정수입니다.
 * travel 배열에서 시간을 나타내는 숫자(각 행의 첫 번째, 세 번째 숫자)는 10,000 이하의 자연수, 모금액을 나타내는 숫자(각 행의 두 번째, 네 번째 숫자)는 1,000,000 이하의 자연수입니다.
 * K는 0보다 크고 100,000보다 작거나 같은 자연수입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * K	travel	return
 * 1650	[[500, 200, 200, 100], [800, 370, 300, 120], [700, 250, 300, 90]]	660
 * 3000	[[1000, 2000, 300, 700], [1100, 1900, 400, 900], [900, 1800, 400, 700], [1200, 2300, 500, 1200]]	5900
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 입출력 예#1
 * 앞서 설명한 예와 같습니다.
 *
 * 입출력 예#2
 * 1, 4번 구간은 도보로 이동하고 2, 3번 구간은 자전거로 이동하여 모금액을 5,900원으로 하는 것이 가장 좋은 방법입니다. 이때 걸리는 시간은 3,000시간입니다.
 *
 */
public class DYNAMIC007 {

    public static void main(String[] args) {

        int k = 1650;
        int[][] travel = new int[][]{{500, 200, 200, 100}, {800, 370, 300, 120}, {700, 250, 300, 90}};

        Solution solution = new Solution();
        int result = solution.solution(k, travel);

        System.out.println(result);
    }

    public static class Solution {
        static int[][] dp;
        static int solution(int K, int[][] travel) {
            int answer = 0;
            dp = new int[travel.length + 1][K + 1];
            answer = solve(travel, 0, 0, K);

            return answer;
        }

        static int solve(int[][] travel, int n, int time, int K) {
            if(n == travel.length) {
                return 0;
            }
            if(dp[n][time] != 0) {
                return dp[n][time];
            }
            if(time + travel[n][0] <= K) {
                dp[n][time] = solve(travel, n + 1, time + travel[n][0], K) + travel[n][1];
            }
            if(time + travel[n][2] <= K) {
                dp[n][time] = Math.max(dp[n][time], solve(travel, n + 1, time + travel[n][2], K) + travel[n][3]);
            }
            return dp[n][time];
        }
    }

    public static class Solution1 {
        public int solution(int K, int[][] travel) {
            int[][] result = new int[100][100000 + 1];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100001; j++) {
                    result[i][j] = -1;
                }
            }

            return find(travel, 0, travel.length, K, result);
        }

        public static int find(int[][]travel, int index, int n, int K, int[][] result) {
            if (index == n) return 0;
            if (result[index][K] >= 0) return result[index][K];

            result[index][K] = Math.max(
                    ((K - travel[index][0] >= 0)?
                            (index + 1 == n? 0 : find(travel, index + 1, n, K - travel[index][0], result)) + travel[index][1] : 0),
                    ((K - travel[index][2] >= 0)?
                            (index + 1 == n? 0 : find(travel, index + 1, n, K - travel[index][2], result)) + travel[index][3] : 0));
            return result[index][K];
        }
    }

    public static class Solution2 {
        public int solution(int K, int[][] travel) {
            int answer = 0;
            int n = travel.length;
            int[][] DP = new int[101][100001];
            boolean[][] visited = new boolean[101][100001];

            visited[0][0] = true;

            for (int i = 0; i < n; i++) {
                int w = travel[i][0];
                int wc = travel[i][1];
                int b = travel[i][2];
                int bc = travel[i][3];

                for (int j = 0; j <= K; j++) {
                    if (!visited[i][j]) continue;
                    if (j + w <= K) {
                        DP[i + 1][j + w] = max(DP[i + 1][j + w], DP[i][j] + wc);
                        visited[i + 1][j + w] = true;
                    }
                    if (j + b <= K) {
                        DP[i + 1][j + b] = max(DP[i + 1][j + b], DP[i][j] + bc);
                        visited[i + 1][j + b] = true;
                    }
                }
            }

            for (int i = 0; i <= K; i++) {
                answer = Math.max(answer, DP[n][i]);
            }

            return answer;
        }

        static int max(int a, int b) {
            return a > b ? a : b;
        }
    }

    public static class Solution3 {
        public static final int IMP = Integer.MIN_VALUE;
        public int n;
        public int[][] dp;
        public int[][] t;
        public int solution(int K, int[][] travel) {
            int answer = 0;
            n = travel.length;
            t = travel;
            dp = new int[n][K+1];

            for(int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            answer = func(0,K); ;
            return answer;
        }

        public int func(int idx, int min) {
            if (idx >= n) {
                return 0;
            }
            if(min <= 0) {
                return IMP;
            }

            if(dp[idx][min] != -1) {
                return dp[idx][min];
            }

            dp[idx][min] = IMP;
            if(min >= t[idx][0] && func(idx+1, min-t[idx][0]) != IMP) {
                dp[idx][min] = Math.max(dp[idx][min], func(idx+1, min-t[idx][0]) +t[idx][1]);
            }
            if(min >= t[idx][2] && func(idx+1, min-t[idx][2]) != IMP) {
                dp[idx][min] = Math.max(dp[idx][min], func(idx+1, min-t[idx][2]) + t[idx][3]);
            }
            return dp[idx][min];
        }
    }

    public static class Solution4 {

        int[][] timeAndMoney;
        int[][] memoize;
        int nCity;

        public int cost(int city, int time) {
            if (city == nCity)
                return 0;

            int result = 0;
            if (memoize[city][time] > 0) {
                return memoize[city][time];
            } else {
                if (time - timeAndMoney[city][0] >= 0) {
                    result = Math.max(result, cost(city + 1, time - timeAndMoney[city][0]) + timeAndMoney[city][1]);
                }

                if (time - timeAndMoney[city][2] >= 0) {
                    result = Math.max(result, cost(city + 1, time - timeAndMoney[city][2]) + timeAndMoney[city][3]);
                }

                memoize[city][time]=result;

                return result;
            }
        }

        public int solution(int K, int[][] travel) {
            this.timeAndMoney = travel;
            this.nCity = travel.length;
            this.memoize = new int[nCity][K + 1];

            return cost(0, K);
        }
    }

    public static class Solution5 {
        public int solution(int K, int[][] travel) {
            int[][] memo = new int[travel.length+1][K + 1];
            boolean[][] visited = new boolean[travel.length+1][K+1];
            visited[0][0] = true;

            for(int i = 0; i < travel.length; i++){
                int work_time = travel[i][0], work_cost = travel[i][1], bike_time = travel[i][2], bike_cost = travel[i][3];
                for(int j = 0; j <= K; j++){
                    if(visited[i][j] == false) continue;

                    if(j + work_time <= K){
                        memo[i+1][j + work_time] = Math.max(memo[i+1][j + work_time], memo[i][j] + work_cost);
                        visited[i+1][j + work_time] = true;
                    }
                    if(j + bike_time <= K){
                        memo[i+1][j + bike_time] = Math.max(memo[i+1][j + bike_time], memo[i][j] + bike_cost);
                        visited[i+1][j + bike_time] = true;
                    }
                }
            }
            int max = -1;
            for(int element : memo[memo.length - 1]) max = Math.max(max, element);
            return max;
        }
    }

    public static class Solution6 {
        public int solution(int K, int[][] travel) {
            int answer = 0;

            int n = travel.length;
            int[][] dp = new int[n + 1][K + 1];
            boolean[][] visit = new boolean[n + 1][K + 1];

            visit[0][0] = true;
            for (int i = 0; i < n; i++) {
                int wt = travel[i][0];
                int wc = travel[i][1];
                int bt = travel[i][2];
                int bc = travel[i][3];

                for (int j = 0; j <= K; j++) {
                    if(!visit[i][j]) continue;
                    if(j + wt <= K) {
                        dp[i + 1][j + wt] = dp[i][j] + wc;
                        visit[i + 1][j + wt] = true;
                    }
                    if(j + bt <= K) {
                        dp[i + 1][j + bt] = Math.max(dp[i + 1][j + bt], dp[i][j] + bc);
                        visit[i + 1][j + bt] = true;
                    }
                }
            }

            for (int i = 0; i <= K; i++) {
                answer = Math.max(answer, dp[n][i]);
            }

            return answer;
        }
    }

    public static class Solution7 {
        private static int[][] DP;
        private static int TIME;

        public static int solution (int K, int[][] travel) {
            TIME = K;
            DP = new int[K+1][travel.length + 1];

            return DFS(travel, 0, 0);
        }

        private static int DFS (int[][] travel, int time, int cnt) {
            // 만약 인덱스가 해당 인덱스의 범위 이내에 없다면 0을 리턴한다.
            if (cnt == travel.length) {
                return 0;
            }

            // 만약 모금액이 0원이 아니라면 해당 최대 모금액을 리턴하라.
            if (DP[time][cnt] != 0) {
                return DP[time][cnt];
            }

            // 만약 걸어가도 시간이 된다면
            if (time + travel[cnt][0] <= TIME) {
                DP[time][cnt] = DFS(travel, time + travel[cnt][0], cnt + 1) + travel[cnt][1];
            }

            if (time + travel[cnt][2] <= TIME) {
                DP[time][cnt] = Math.max(DP[time][cnt], DFS(travel, time + travel[cnt][2], cnt + 1) + travel[cnt][3]);
            }

            return DP[time][cnt];
        }
    }




}
