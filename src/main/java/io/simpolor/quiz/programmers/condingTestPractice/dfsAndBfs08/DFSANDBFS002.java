package io.simpolor.quiz.programmers.condingTestPractice.dfsAndBfs08;

import java.util.*;

/***
 * 네트워크
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다.
 * 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
 * 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
 *
 * 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
 *
 * 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
 * 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
 * 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
 * i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
 * computer[i][i]는 항상 1입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * n	computers	return
 * 3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
 * 3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 예제 #1
 * 아래와 같이 2개의 네트워크가 있습니다.
 *    ( 1 )
 *     /
 *    /
 * ( 2 )    ( 3 )
 *
 * 예제 #2
 * 아래와 같이 1개의 네트워크가 있습니다.
 *    ( 1 )
 *     /
 *    /
 * ( 2 )----( 3 )
 *
 */
public class DFSANDBFS002 {

    public static void main(String[] args) {

        int n = 3;
        int[][] computers = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        Solution solution = new Solution();
        int result = solution.solution(n, computers);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] chk = new boolean[n];
            for(int i = 0; i < n; i++) {
                if(!chk[i]) {
                    dfs(computers, chk, i);
                    answer++;
                }
            }
            return answer;
        }
        void dfs(int[][] computers, boolean[] chk, int start) {
            chk[start] = true;
            for(int i = 0; i < computers.length; i++) {
                if(computers[start][i] == 1 && !chk[i]) {
                    dfs(computers, chk, i);
                }
            }
        }
    }

    public static class Solution1 {
        boolean visited[];
        int[][] data;

        public int solution(int n, int[][] computers) {
            int answer = 0;
            visited = new boolean[n];
            data = computers;

            for(int i=0; i<n; i++) {
                if(!visited[i]) {
                    answer++;
                    dfs(i);
                }
            }
            return answer;
        }

        void dfs(int index) {
            if(visited[index]) {return;}
            visited[index] = true;

            for(int i=0; i<data[index].length; i++) {
                if(data[index][i] == 1) {
                    dfs(i);
                }
            }

        }
    }

    public static class Solution2 {
        public int solution(int n, int[][] computers) {
            Stack<Integer> stk = new Stack<Integer>();
            boolean[] b = new boolean[n];
            int ret = 0;

            for (int i = 0; i < n; i++) {
                if (b[i]) continue;

                ret++;
                stk.push(i);
                boolean flag = true;
                b[i] = true;

                while (!stk.isEmpty()) {
                    flag = true;
                    int cur = stk.peek();

                    for (int j = 0; j < n; j++) {
                        if (b[j] || computers[cur][j] == 0) continue;

                        flag = false;
                        stk.push(j);
                        b[j] = true;
                        break;
                    }

                    if (flag) stk.pop();
                }
            }

            return ret;
        }
    }

    public static class Solution3 {
        static boolean[][] check;
        static int[][] network;
        static void connect(int row, int col) {
            for(int i=1; i<network.length; i++) {
                if(network[row][i]==1 && check[row][i]==false) {
                    check[row][i] = true;
                    check[i][row] = true;
                    connect(i, row);
                }
            }
        }
        public int solution(int n, int[][] computers) {
            int answer = 0;
            network = new int[n+1][n+1];
            check = new boolean[n+1][n+1];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(computers[i][j]==1) {
                        network[i+1][j+1] = 1;
                    } else check[i+1][j+1] = true;
                }
            }

            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(check[i][j]==false) {
                        connect(i,j);
                        answer++;
                    }
                }
            }
            return answer;
        }
    }

    public static class Solution4 {
        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean inNetwork[] = new boolean[n];
            int startIndex = 0;

            LinkedList<Integer> queue = new LinkedList<>();
            int node;
            while(startIndex < n) {
                answer++;
                queue.addLast(startIndex);
                inNetwork[startIndex] = true;

                while(!queue.isEmpty()) {
                    node = queue.poll();

                    for (int i = 0; i < n; i++) {
                        if (!inNetwork[i] && computers[node][i] == 1) {
                            queue.addLast(i);
                            inNetwork[i] = true;
                        }
                    }
                }
                startIndex++;
                while((startIndex < n) && inNetwork[startIndex]) startIndex++;
            }

            return answer;
        }
    }

    public static class Solution5 {
        public static int solution(int n, int[][] computers) {
            int answer = 0;

            int visited[]  = new int[n];

            for(int i=0;i<n;i++) {

                ArrayList<Integer> q = new ArrayList<>();

                if(visited[i] == 1) continue;

                q.add(i);
                visited[i] = 1;
                answer++;

                while(!q.isEmpty()) {
                    int std = q.remove(0);
                    for(int j=0;j<n;j++) {
                        if(computers[std][j] == 0) continue;
                        if(visited[j] == 1) continue;
                        q.add(j);
                        visited[j] = 1;
                    }
                }

            }


            return answer;
        }
    }

    public static class Solution6 {

        private static boolean[][] visit;

        public int solution(int n, int[][] computers) {
            int answer = 0;
            visit = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(computers[i][j] != 0 && !visit[i][j]) {
                        dfs(n, computers, i, j);
                        answer++;
                    }
                }
            }

            return answer;
        }

        public void dfs(final int n, final int[][] computers, final int x, final int y) {
            if(visit[x][y] || visit[y][x]) return;
            visit[x][y] = true;
            visit[y][x] = true;
            for(int i = 0; i < n; i++) {
                if(computers[y][i] == 1 && !visit[y][i]) dfs(n, computers, y, i);
            }
        }
    }








}