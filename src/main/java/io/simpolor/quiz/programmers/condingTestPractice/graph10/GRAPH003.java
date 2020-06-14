package io.simpolor.quiz.programmers.condingTestPractice.graph10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/***
 * 사이클 제거
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * n개의 노드로 구성된 그래프에서 하나의 노드만을 제거해서 사이클이 없도록 만들고 싶습니다.
 *
 * 노드의 개수 n, 노드간의 연결 edges가 매개변수로 주어질 때,
 * 노드를 딱 하나 제거해서 그래프를 사이클이 없도록 만들 수 있다면 해당 노드의 번호를 return 하도록 solution 함수를 완성하세요.
 *
 * 단, 그런 노드가 없다면 0을 return하고, 여러 개라면 노드의 번호의 합을 return하세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 노드 번호는 1 부터 시작합니다.
 * 주어진 그래프에 반드시 하나 이상의 사이클은 있습니다.
 * 노드간의 연결에는 방향이 없습니다.
 * 주어지는 노드의 수는 2개 이상 5,000개 이하입니다.
 * 연결의 수는 1개 이상 n(n + 1)/2개 이하입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 *
 * n	edges	result
 * 4,	[[1,2],[1,3],[2,3],[2,4],[3,4]],	5
 * 8,	[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7],[7,8],[8,1],[2,7],[3,6]],	0
 *
 * ------------------------------
 * 입출력 예 설명
 *------------------------------
 * 예제 #1
 *
 * 아래 그림과 같이 표현할 수 있으며 2번 또는 3번 노드를 제거하면 사이클이 없어지므로 2+3인 5를 리턴하면 됩니다.
 *
 * Screen Shot 2018-09-06 at 2.14.37 PM.png
 *      (2)
 *    /  |  ＼
 * (1)   |    (4)
 *    ＼ |  ／
 *      (3)
 * 예제 #2
 *
 * 아래 그림과 같이 표현할 수 있으며 어떤 노드를 제거하더라도 사이클이 남아있으므로 0을 리턴하면 됩니다.
 *
 * Screen Shot 2018-09-06 at 1.58.59 PM.png
 *    (1) --- (2)
 *   /       /   ＼
 * (8)    /       (3)
 *  |  /        /  |
 * (7)       /    (4)
 *   ＼   /        /
 *     (6) --- (5)
 */
public class GRAPH003 {

    public static void main(String[] args) {

        int n = 4;
        int[][] results = new int[][]{{1,2},{1,3},{2,3},{2,4},{3,4}};


        Solution solution = new Solution();
        int result = solution.solution(n, results);

        System.out.println(result);
    }

    public static class Solution {
        int N, M, C;
        int[] visited;
        int[] parant_edge, weak_edge, strong_edge;
        LinkedList<Integer>[] adj, child;

        public int solution(int n, int[][] edges) {
            int answer = 0;
            visited = new int[n + 1];
            parant_edge = new int[n + 1];
            weak_edge = new int[n + 1];
            strong_edge = new int[n + 1];
            adj = new LinkedList[n + 1];
            child = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new LinkedList<>();
                child[i] = new LinkedList<>();
            }
            N = n;
            M = edges.length;
            for (int i = 0; i < M; i++) {
                adj[edges[i][0]].add(edges[i][1]);
                adj[edges[i][1]].add(edges[i][0]);
            }
            visited[1] = 1;
            dfs(1, 0);
            for (int i = 1; i <= n; i++) {
                boolean flag = false;
                for (int j = 0; j < child[i].size(); j++) {
                    int v = child[i].get(j);
                    if (strong_edge[v] > 0 || weak_edge[v] - parant_edge[v] > 1) {
                        flag = true;
                        break;
                    }
                }
                if (flag || M - (N - 1) - weak_edge[i] != 0) continue;
                answer += i;
            }
            return answer;
        }

        void dfs(int cur, int from) {
            for (int i = 0; i < adj[cur].size(); i++) {
                int node = adj[cur].get(i);
                if (from != node) {
                    if (visited[node] == 0) {
                        visited[node] = visited[cur] + 1;
                        child[cur].add(node);
                        int temp = strong_edge[node];
                        dfs(node, cur);
                        parant_edge[node] = strong_edge[cur] - temp;
                        strong_edge[cur] += strong_edge[node];
                        weak_edge[cur] += weak_edge[node];
                    } else if (visited[cur] > visited[node]) {
                        weak_edge[cur]++;
                        strong_edge[node]++;
                    }
                }
            }
        }
    }

    public static class Solution1 {
        static List<List<Integer>> adj;
        static List<List<Integer>> child;
        static int[] check;
        static int[] pe;
        static int[] we;
        static int[] se;
        static int solution(int n, int[][] edges) {
            int answer = 0;

            adj = new ArrayList<>();
            child = new ArrayList<>();
            for(int i = 0; i < n + 1; i++) {
                adj.add(new ArrayList<>());
                child.add(new ArrayList<>());
            }

            for(int i = 0; i < edges.length; i++) {
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
            }

            check = new int[n + 1];
            pe = new int[n + 1];
            we = new int[n + 1];
            se = new int[n + 1];

            check[1] = 1;
            dfs(1, 0);

            for(int i = 1; i < n + 1; i++) {
                int flag = 0;
                for(int j = 0; j < child.get(i).size(); j++) {
                    int v = child.get(i).get(j);
                    if(se[v] > 0 || we[v] - pe[v] > 1) {
                        flag = 1;
                        break;
                    }
                }

                if(flag > 0 || edges.length - (n - 1) - we[i] != 0) {
                    continue;
                }
                answer += i;
            }

            return answer;
        }

        static void dfs(int u, int pa) {
            for(int w : adj.get(u)) {
                if(pa != w) {
                    if(check[w] == 0) {
                        check[w] = check[u] + 1;
                        child.get(u).add(w);
                        int tmp = se[u];
                        dfs(w, u);
                        pe[w] = se[u] - tmp;
                        se[u] += se[w];
                        we[u] += we[w];
                    }else if(check[u] > check[w]) {
                        we[u]++;
                        se[w]++;
                    }
                }
            }
        }
    }

    public static class Solution2 {
        private static int[] check;
        private static int[] parents, subs, backs;
        private static ArrayList<Integer>[] connection, directChild;

        public int solution(int n, int[][] edges) {
            int answer = 0;
            check = new int[n+1];
            parents = new int[n+1]; subs = new int[n+1]; backs = new int[n+1];
            connection = new ArrayList[n+1]; directChild = new ArrayList[n+1];

            for(int i = 1; i <= n; i++) {
                connection[i] = new ArrayList<>();
                directChild[i] = new ArrayList<>();
            }

            for(int i = 0; i < edges.length; i++) {
                connection[edges[i][0]].add(edges[i][1]);
                connection[edges[i][1]].add(edges[i][0]);
            }

            check[1] = 1;
            MakeDfsTree(1, 0);

            for(int i = 1; i <= n; i++) {
                boolean delete = false;
                for(int j : directChild[i]) {
                    if(backs[j] > 0 || subs[j] - parents[j] > 1) {
                        delete = true;
                        break;
                    }
                }
                if(delete || edges.length - (n - 1) - subs[i] != 0) continue;
                answer+= i;
            }

            return answer;
        }

        public void MakeDfsTree(int cur, int from) {
            for(int node : connection[cur]) {
                if(from != node) {
                    if(check[node] == 0) {
                        check[node] = check[cur] + 1;
                        directChild[cur].add(node);
                        int temp = backs[cur];
                        MakeDfsTree(node, cur);
                        parents[node] = backs[cur] - temp;
                        subs[cur] += subs[node];
                        backs[cur] += backs[node];
                    }
                    else if(check[cur] > check[node]) {
                        subs[cur]++; backs[node]++;
                    }
                }
            }
        }
    }
}
