package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Scanner;

// 미로 탐색에 대한 경우의 수
// 0 0 0 0 0 0 0
// 0 1 1 1 1 1 0
// 0 0 0 1 0 0 0
// 1 1 0 1 0 1 1
// 1 1 0 0 0 0 1
// 1 1 0 1 1 0 0
// 1 0 0 0 0 0 0
public class Q76_미로탐색 {

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static int[][] board;
    public static int answer;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        board = new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                board[i][j] = scanner.nextInt();
            }
        }
        board[1][1] = 1;
        DFS(1, 1 );
        System.out.println(answer);
    }

    public static void DFS(int x, int y){
        if(x == 7 && y == 7){
            answer++;
        }else{
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7 && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }
    }
}
