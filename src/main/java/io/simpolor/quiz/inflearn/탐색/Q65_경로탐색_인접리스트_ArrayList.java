package io.simpolor.quiz.inflearn.탐색;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 인접행렬로 노드가 10만개씩 들어오게 될 경우 너무나 비효율 적이다.
 * 인접리스트는 1번부터 5번까지 만들어 놓는다.
 * 5가 들어올 경우 각각 리스트를 추가
 * 1 2-3-4 ArrayList
 * 2 1-3 ArrayList
 * 3 4 ArrayList
 * 4 2-5 ArrayList
 * 5 ArrayList
 *
 * 인접행렬
 * 1 - 2 - 5
 * |   |
 * 3 - 4
 *
 * 정점수
 * 1 2 3 4 5
 * 1 2 5
 * 1 3 4 2 5
 * 1 3 4 5
 * 1 4 2 5
 * 1 4 5
 * 총 6가지
 *
 * 입력예제
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 *
 * 출력예제
 * 6
 */
public class Q65_경로탐색_인접리스트_ArrayList {

    public static int n, m, answer=0;
    public static ArrayList<ArrayList<Integer>> graph;
    public static int[] check;

    public static void DFS(int v){
        if(v == n){
           answer++;
        }else{
            for(int nv : graph.get(v)){ // 배열 반복문
                if(check[nv] == 0){
                    check[nv] = 1;
                    DFS(nv);
                    check[nv] = 0;
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
        for(int i=0; i<m; i++){ // 간석
            graph.get(scanner.nextInt()).add(scanner.nextInt());
        }
        check[1] = 1;
        DFS(1); // 시작을 뜻함
        System.out.println(answer);
    }
}
