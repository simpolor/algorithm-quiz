package io.simpolor.quiz.inflearn.탐색;

import java.util.*;

/**
 * 그래프 최단거리 (BFS)
 * 노드 탐색 (레벨)
 *
 * 문제 ( 1번 정점에서 각 정점으로 가는 최소 간선 출력 )
 * 1 - 2 - 5
 * |   |   |
 * 3 - 4 - 6
 *
 * 입력예제
 * 6 9
 * 1 3
 * 1 4
 * 2 1
 * 2 5
 * 3 4
 * 4 5
 * 4 6
 * 6 2
 * 6 5
 *
 * 출력예제
 * 6
 */
public class Q66_그래프_최단거리_BFS {

    public static int n, m;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] check, distant;

    public static void BFS(int v){

        Queue<Integer> queue = new LinkedList<>();

        check[v] = 1;
        distant[v] = 0;
        queue.offer(v);
        while (!queue.isEmpty()){
            int cv = queue.poll(); // 현재 커서 값을 빼면서 가져옴
            for(int nv : graph.get(cv)){ // 여기서 각 배열에 인접하는 노드를 출력
                if(check[nv] == 0){
                    check[nv] = 1; // 인접한 변수에 체크
                    queue.offer(nv); // 인접하고 체크가 안된 노드를 다시 이동할 수 있게 추가
                    distant[nv] = distant[cv]+1; // 거리에 레벨을 추가
                }
            }
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<ArrayList<Integer>>(); // 리스트이긴 때문에 0부터 시작할 수 밖에 없다. 0은 버린다.
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        check = new int[n+1];
        distant = new int[n+1]; // 최단 거리수
        for(int i=0; i<m; i++){ // 간석
            graph.get(scanner.nextInt()).add(scanner.nextInt());
        }
        // check[1] = 1; // 본문에서 선언
        BFS(1); // 시작을 뜻함
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+distant[i]);
        }
    }
}
