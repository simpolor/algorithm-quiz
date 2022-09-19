package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Scanner;

public class Q79_섬나라_아일랜드_DFS {

    public static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    public static int n, answer = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] board = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = scanner.nextInt();
            }
        }
        solution(board);
        System.out.println(answer);
    }

    public static void solution(int[][] board){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    answer++;
                    board[i][j] = 0;
                    DFS(i, j, board);
                }
            }
        }
    }

    public static void DFS(int x, int y, int[][] board){
        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && board[nx][ny]==1){
                board[nx][ny] = 0;
                DFS(nx, ny, board);
            }
        }
    }
}
