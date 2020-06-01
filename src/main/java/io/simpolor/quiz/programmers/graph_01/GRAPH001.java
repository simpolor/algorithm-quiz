package io.simpolor.quiz.programmers.graph_01;

import java.util.*;

/***
 * 가장 먼 노드
 *
 * ------------------------------
 * 문제 설명
 *  ------------------------------
 * n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다.
 * 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다.
 * 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
 *
 * 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때,
 * 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 *  ------------------------------
 * 노드의 개수 n은 2 이상 20,000 이하입니다.
 * 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
 * vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
 *
 *  ------------------------------
 * 입출력 예
 *  ------------------------------
 * n,	vertex,	return
 * 6,	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]],	3
 *
 *  ------------------------------
 * 입출력 예 설명
 *  ------------------------------
 * 예제의 그래프를 표현하면 아래 그림과 같고, 1번 노드에서 가장 멀리 떨어진 노드는 4,5,6번 노드입니다.
 *
 * image.png
 *
 * (1)---(2)---(5)
 *  |   / |
 *  | /   |
 * (3)---(4)
 *  |
 *  |
 * (6)
 */
public class GRAPH001 {

    public static void main(String[] args) {

        int n = 6;
        int[][] edge = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};


        Solution solution = new Solution();
        int result = solution.solution(n, edge);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int n, int[][] edge) {
            ArrayList<Integer>[] path = new ArrayList[n];
            ArrayList<Integer> bfs = new ArrayList<Integer>();
            int answer = 0;
            int[] dist = new int[n];
            dist[0] = 1;
            int max = 0;

            for(int i = 0; i < edge.length; i++) {
                int num1 = edge[i][0] - 1;
                int num2 = edge[i][1] - 1;
                if(path[num1] == null)
                    path[num1] = new ArrayList<Integer>();
                if(path[num2] == null)
                    path[num2] = new ArrayList<Integer>();
                path[num1].add(num2);
                path[num2].add(num1);
            }

            bfs.add(0);
            while(!bfs.isEmpty()) {
                int idx = bfs.get(0);
                bfs.remove(0);
                while(!path[idx].isEmpty()) {
                    int num = path[idx].get(0);
                    path[idx].remove(0);
                    bfs.add(num);
                    if(dist[num] == 0) {
                        dist[num] = dist[idx] + 1;
                        max = dist[num];
                    }
                }
            }
            for(int i = 0; i < n; i++) {
                if(dist[i] == max)
                    answer++;
            }

            return answer;
        }
    }

    public static class Solution4 {
        public int solution(int n, int[][] edge) {
            int[] dist = new int[n+1];
            boolean[][] map = new boolean[n+1][n+1];
            for(int i =0; i<edge.length; i++){
                map[edge[i][1]][edge[i][0]] = map[edge[i][0]][edge[i][1]]= true;
            }

            LinkedList<Integer> que = new LinkedList<Integer>();
            que.add(1);

            while(!que.isEmpty()){
                int temp = que.pollFirst();
                for(int i = 2; i<n+1; i++){
                    if(map[temp][i]&&dist[i]==0){
                        que.addLast(i);
                        dist[i] = dist[temp]+1;
                    }
                }
            }

            Arrays.sort(dist);
            int i = dist.length-1;
            for(; i>0; --i){
                if(dist[i]!=dist[i-1]){
                    break;
                }
            }

            return dist.length-i;
        }
    }

    public static class Solution1 {
        public int solution(int n, int[][] edge) {
            int answer = 0;
            int[] visited = new int[n];
            Queue<Integer> queue = new LinkedList<Integer>();
            int[] distance = new int[n];

            queue.offer(1);
            visited[0] = 0;
            distance[0] = 0;
            while(!queue.isEmpty())
            {
                int element = queue.poll();
                visited[element - 1] = 1;
                for(int[] one_edge : edge)
                {
                    if(one_edge[0] == element && visited[one_edge[1] - 1] == 0)
                    {
                        queue.offer(one_edge[1]);
                        visited[one_edge[1] - 1] = 1;
                        distance[one_edge[1] - 1] = distance[one_edge[0] - 1] + 1;
                    }
                    if(one_edge[1] == element && visited[one_edge[0] - 1] == 0)
                    {
                        queue.offer(one_edge[0]);
                        visited[one_edge[0] - 1] = 1;
                        distance[one_edge[0] - 1] = distance[one_edge[1] - 1] + 1;
                    }
                }
                visited[element - 1] = 2;
            }
            int max_dist = -1;
            for(int element : distance) max_dist = Math.max(max_dist, element);
            for(int element : distance) if(element == max_dist) answer++;
            return answer;
        }
    }

    public static class Solution2 {
        public int solution(int n, int[][] edge) {
            boolean[][] hasRoot = new boolean[n][n];

            for (int[] d : edge) {
                int p1 = d[0] - 1;
                int p2 = d[1] - 1;

                hasRoot[p1][p2] = hasRoot[p2][p1] = true;
            }

            int startNode = 0;

            Queue<Integer> pq = new LinkedList<>();
            pq.offer(startNode);

            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            dist[startNode] = 0;

            while (!pq.isEmpty()) {
                int cur = pq.poll();

                for (int i = 0; i < n; i++) {
                    if (!hasRoot[cur][i] || dist[i] <= dist[cur] + 1) {
                        continue;
                    }

                    dist[i] = dist[cur] + 1;
                    pq.offer(i);
                }
            }

            long max = 0;
            int answer = 0;

            for (int i = 0; i < n; i++) {
                if (max < dist[i]) {
                    answer = 1;
                    max = dist[i];
                } else if (max == dist[i]) {
                    answer++;
                }
            }

            return answer;
        }
    }

    public static class Solution3 {
        public int solution(int n, int[][] edge) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            boolean[] check;
            int[] count;
            int answer = 0;
            check = new boolean[edge.length + 1];
            count = new int[edge.length + 1];
            for(int i = 0; i < edge.length + 1; i++) {
                check[i] = false;
                count[i] = 0;
                graph.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < edge.length; i++) {
                graph.get(edge[i][0]).add(edge[i][1]);
                graph.get(edge[i][1]).add(edge[i][0]);
            }
            Queue<Integer> que = new LinkedList<Integer>();
            que.add(1);
            check[1] = true;
            count[1] = 1;

            while(!que.isEmpty()) {
                int temp = que.poll();
                for(int i = 0; i < graph.get(temp).size(); i++) {
                    if(check[graph.get(temp).get(i)] == false) {
                        check[graph.get(temp).get(i)] = true;
                        count[graph.get(temp).get(i)] = count[temp]+1;
                        que.offer(graph.get(temp).get(i));
                    }
                }
            }
            int max = 0;
            for(int i = 0; i < count.length; i++)
                max = max >= count[i]? max : count[i];

            for(int i = 0; i < count.length; i++)
                if(count[i] == max) answer++;

            return answer;
        }
    }

    public static class Solution5 {
        class Node {
            int data;
            HashSet<Node> nextNode;
            Node(int data) {
                this.data = data;
                nextNode = new HashSet<>();
            }
            @Override
            public String toString() {
                return Integer.toString(data);
            }
        }

        Node[] nodes;
        boolean[] visit;
        Queue<Node> queue1, queue2;
        int[] step;

        public int bfs(boolean queueSwitch) {
            if(queueSwitch) {
                while(!queue1.isEmpty()) {
                    Node n = queue1.poll();

                    for(Node i : n.nextNode) {
                        if(!visit[i.data]) {
                            queue2.add(i);
                            visit[i.data] = true;
                        }
                    }
                }
            } else {
                while(!queue2.isEmpty()) {
                    Node n = queue2.poll();

                    for(Node i : n.nextNode) {
                        if(!visit[i.data]) {
                            queue1.add(i);
                            visit[i.data] = true;
                        }
                    }
                }
            }
            return queueSwitch ? queue2.size() : queue1.size();
        }

        public int solution(int n, int[][] edge) {
            int answer = 0;

            nodes = new Node[n+1];
            visit = new boolean[n+1];
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();

            for(int i=1; i<=n; i++)
                nodes[i] = new Node(i);
            for(int[] arr : edge) {
                nodes[arr[0]].nextNode.add(nodes[arr[1]]);
                nodes[arr[1]].nextNode.add(nodes[arr[0]]);
            }

            boolean queueSwitch = true;
            queue1.add(nodes[1]);
            visit[1] = true;
            while(true) {
                answer = queueSwitch ? queue1.size() : queue2.size();
                int result = bfs(queueSwitch);
                if(result == 0)
                    break;

                System.out.println(queue1.toString());
                System.out.println(queue2.toString());
                queueSwitch = !queueSwitch;
            }

            return answer;
        }
    }

    public static class Solution6 {
        public int solution(int n, int[][] edge) {
            int answer = 0;
            ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n+1]; //그래프를 표현할 변수
            int[] distance = new int[n+1]; //1번 노드에서 각각의 노드까지의 distance를 저장할 변수
            int max = 0; //최대거리를 저장할 변수
            Queue<Integer> q = new LinkedList<Integer>(); //BFS 알고리즘의 큐
            boolean check[] = new boolean[n+1]; //방문했던 노드는 true로

            for(int i=1; i<=n; i++){
                g[i] = new ArrayList<>();
            }
            for(int i=0; i<edge.length; i++){
                g[edge[i][0]].add(edge[i][1]); //그래프의 정보를 ArrayList에 저장
                g[edge[i][1]].add(edge[i][0]); //양방향으로 넣어줘야함
            }

            q.add(1); check[1]=true; distance[1] = 0;
            while (!q.isEmpty()) {
                int x = q.remove();
                for(int i : g[x]){
                    if(check[i]==false){
                        q.add(i);
                        check[i]=true;
                        distance[i] += distance[x] + 1;
                        if(distance[i]>max)
                            max = distance[i];
                    }
                }
            }

            for(int i : distance){
                if(i==max)
                    answer++;
            }

            return answer;
        }
    }





}
