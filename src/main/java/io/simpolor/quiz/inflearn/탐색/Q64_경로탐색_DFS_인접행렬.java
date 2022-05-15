package io.simpolor.quiz.inflearn.탐색;

import java.util.Scanner;

/**
 * 그래프에서 경로라는건 한번 방문한 노드는 다시 방문하면 안된다. ( 그래프 이론 )
 * 중복된 노드가 없어야한다.
 * 방문한 노드는 체크해둬야한다.
 * 체크 변수가 필요 ( 스택를 되돌아갈때 체크 풀어야함 )
 * 탐색은 뿌리가 뻗는 형식으로 계속 탐색함
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
 *
 * 그래프는 그림을 그리고하는 방법이 괜찮아 보인다.
 */
public class Q64_경로탐색_DFS_인접행렬 {

    public static int n, m, answer=0;
    public static int[][] graph;
    public static int[] check;

    public static void DFS(int v){
        if(v == n){
           answer++;
        }else{
            for(int i=1; i<=n; i++){
                if(graph[v][i] == 1 && check[i] ==0){
                    check[i] = 1;
                    DFS(i);
                    check[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new int[n+1][n+1];
        check = new int[n+1];
        for(int i=0; i<m; i++){ // 간석
            graph[scanner.nextInt()][scanner.nextInt()] = 1;
        }
        check[1] = 1;
        DFS(1); // 시작을 뜻함
        System.out.println(answer);
    }
}
