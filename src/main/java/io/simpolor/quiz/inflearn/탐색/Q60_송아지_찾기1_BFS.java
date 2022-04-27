package io.simpolor.quiz.inflearn.탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BFS: 상태 트리 탐색
// BFS: 최단거리를 구하는 알고리즘
// 레벨당 +1, -1, +5에 트리를 가진다.
public class Q60_송아지_찾기1_BFS {

    public static int answer = 0;
    public static int[] distinct = {1, -1, 5};
    public static int[] check = new int[10001];
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int answer = solution(n, m);
        System.out.println(answer);
    }

    // 최소가 나오면 최단거리 알고리즘
    public static int solution(int n, int m){

        check[n] = 1; // ch는 방문 여부를 체크하여 큐에 넣기 위한 변수
        queue.offer(n);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int x = queue.poll();
                /*if(x == m){
                    return level;
                }*/
                for(int j=0; j<3; j++){
                    int nx = x + distinct[j];
                    if(nx == m){
                        return level+1; // 자식에서 검색하기때문에 +1로 해주므
                    }
                    if(nx >= 1 && nx <= 10000 && check[nx] == 0){
                        check[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
