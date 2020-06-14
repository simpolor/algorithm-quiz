package io.simpolor.quiz.programmers.condingTestPractice.greedy06;

import java.util.*;

/***
 * 섬 연결하기
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때,
 * 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
 *
 * 다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다.
 * 예를 들어 A 섬과 B 섬 사이에 다리가 있고,
 * B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 섬의 개수 n은 1 이상 100 이하입니다.
 * costs의 길이는 ((n-1) * n) / 2이하입니다.
 *
 * 임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고,
 * costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
 * 같은 연결은 두 번 주어지지 않습니다.
 *
 * 또한 순서가 바뀌더라도 같은 연결로 봅니다.
 * 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
 * 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다.
 *
 * 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
 * 연결할 수 없는 섬은 주어지지 않습니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * n	costs	return
 * 4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
 *
 * ------------------------------
 * 입출력 예 설명
 *------------------------------
 * costs를 그림으로 표현하면 다음과 같으며, 이때 초록색 경로로 연결하는 것이 가장 적은 비용으로 모두를 통행할 수 있도록 만드는 방법입니다.
 *
 *        1
 * ( O ) --- ( 1 )
 *   |      /  |
 * 2 |   5/    | 1
 *   |  /      |
 * ( 2 ) --- ( 3 )
 *        8
 */
public class GREEDY006 {

    public static void main(String[] args) {

        int n = 4;
        int[][] costs = new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        Solution solution = new Solution();
        int result = solution.solution(n, costs);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int n, int[][] costs) {
            int[][] island = new int[n][n];

            for (int[] cost : costs) {
                if (cost.length > 0) {
                    island[cost[0]][cost[1]] = cost[2];
                    island[cost[1]][cost[0]] = cost[2];
                }
            }

            ArrayList<Integer> connected = new ArrayList<>();
            Iterator<Integer> it;
            connected.add(0);

            int sum = 0;
            while (connected.size() < n) {
                long min = -1;
                int minI = -1, minJ = -1;

                it = connected.iterator();
                while (it.hasNext()) {
                    int start = it.next();
                    for (int end = 0; end < n; end++) {
                        if (!connected.contains(end)) {
                            if (island[start][end] > 0) {
                                if (island[start][end] < min || min == -1) {
                                    min = island[start][end];
                                    minI = start;
                                    minJ = end;
                                }
                            }
                        }
                    }
                }
                sum += min;
                connected.add(minJ);
                island[minI][minJ] = 0;
                island[minJ][minI] = 0;
            }
            return sum;
        }
    }

    public static class Solution1 {
        static class Edge{
            int from;
            int to;
            int cost;
            Edge(int from,int to, int cost){
                this.from = from;
                this.to = to;
                this.cost = cost;
            }
        }
        public static int solution(int n, int[][] costs){
            num = new int[n];
            for(int i=0; i<n; i++){
                num[i] = i;
            }
            PriorityQueue<Edge> queue = new PriorityQueue<Edge>(new Comparator<Edge>() {
                public int compare(Edge o1, Edge o2) {
                    if(o1.cost < o2.cost){
                        return -1;
                    }
                    return 1;
                }
            });
            for(int i=0; i<costs.length; i++){
                int from = costs[i][0];
                int to = costs[i][1];
                int cost = costs[i][2];

                queue.offer(new Edge(from,to,cost));
            }

            Set<Integer> set = new HashSet<Integer>();

            int answer = 0;

            while(queue.size() != 0){
                Edge edge = queue.poll();
                int from = edge.from;
                int to = edge.to;
                int cost = edge.cost;

                if(!set.contains(from) && !set.contains(to)){
                    set.add(from);
                    set.add(to);
                    union(from,to);
                    answer += cost;
                }else if(set.contains(from) && !set.contains(to)){
                    set.add(to);
                    union(from,to);
                    answer += cost;
                }else if(!set.contains(from) && set.contains(to)){
                    set.add(from);
                    union(from,to);
                    answer += cost;
                }else{
                    if(find(from) == find(to)){
                        continue;
                    }else{
                        union(from,to);
                        answer += cost;
                    }
                }
            }
            return answer;
        }

        public static int[] num;
        public static int find(int n){
            LinkedList<Integer> stack = new LinkedList<Integer>();
            while(num[n] != n){
                stack.add(n);
                n = num[n];
            }
            while(stack.size() > 0){
                num[stack.poll()] = n;
            }
            return n;
        }

        public static void union(int a, int b){
            int fa = find(a);
            int fb = find(b);
            num[fa] = fb;
        }
    }

    public static class Solution2 {
        public int solution(int n, int[][] costs) {
            int answer = 0;
            int[][] map = new int[n][n];
            for(int i = 0; i < costs.length; i++) {
                map[costs[i][0]][costs[i][1]] = costs[i][2];
                map[costs[i][1]][costs[i][0]] = costs[i][2];
            }
            boolean[] connected = new boolean[n];
            connected[0] = true;
            answer = prim(map, connected, 0, 1);
            return answer;
        }

        public static int prim(int[][] map, boolean[] connected, int value, int count) {
            if (count == connected.length) return value;
            int to = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < connected.length; i++) {
                if (connected[i]) {
                    for (int j = 0; j < map.length; j++) {
                        if (!connected[j] && map[i][j] != 0 && min > map[i][j]) {
                            to = j;
                            min = map[i][j];
                        }
                    }
                }
            }
            connected[to] = true;
            value += min;
            count++;
            return prim(map, connected, value, count);
        }
    }

    public static class Solution3 {
        public int solution(int n, int[][] costs) {
            int a[] = new int[110];
            int i,j;
            int answer = 0;
            for(i=0;i<n;i++){
                a[i]=i;
            }
            int tmp,tmp1,tmp2;
            for(i=0;i<costs.length;i++){
                for(j=i;j<costs.length;j++){
                    if(costs[i][2]>costs[j][2]){
                        tmp=costs[i][0];
                        tmp1=costs[i][1];
                        tmp2=costs[i][2];
                        costs[i][0]=costs[j][0];
                        costs[i][1]=costs[j][1];
                        costs[i][2]=costs[j][2];
                        costs[j][0]=tmp;
                        costs[j][1]=tmp1;
                        costs[j][2]=tmp2;
                    }
                }
            }
            int b;
            for(i=0;i<costs.length;i++){
                if(a[costs[i][0]]!=a[costs[i][1]]){
                    answer=answer+costs[i][2];
                    b=a[costs[i][1]];
                    for(j=0;j<costs.length;j++){
                        if(a[j]==b)a[j]=a[costs[i][0]];
                    }
                }
            }
            return answer;
        }
    }

    public static class Solution4 {

        int[] Node;
        int N;

        public int solution(int n, int[][] costs) {

            init(n);
            Arrays.sort( costs, (int[] o1, int[] o2)->o1[2] - o2[2]);

            int answer = 0;
            int index = 0;
            while (index < costs.length) {
                if(!isConnected(costs[index][0],costs[index][1]))
                    answer += ConnectLine(costs,index);
                index++;
            }
            return answer;
        }
        public void init(int n) {
            this.N = n;
            Node = new int[N];
            for(int i = 0 ; i < N ; i ++) {
                Node[i] = i;
            }
        }
        public boolean isConnected(int x, int y) {
            if(Parents(x) != Parents(y))
                return false;
            return true;
        }
        public int Parents(int x) {
            if(Node[x] == x) return x;
            return Parents(Node[x]);

        }

        public int ConnectLine(int[][] costs, int index) {
            int x = costs[index][0];
            int y = costs[index][1];
            //if ( x < y ) swap(x,y);
            Node[Parents(y)] = Parents(x);
            return costs[index][2];
        }
        public void swap(int x, int y){
            int temp = x;
            y = x;
            x = temp;

        }

    }




}
