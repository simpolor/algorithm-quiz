package io.simpolor.quiz.inflearn.탐색활용;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q80_섬나라_아일랜드_BFS {

    public static int n, answer = 0;
    public static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    public static Queue<Point> queue = new LinkedList<>();


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
                if(board[i][j]==1){
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }

    }

    public static void BFS(int x, int y, int[][] board){
        queue.add(new Point(x, y));
        while (!queue.isEmpty()){
            Point tmp = queue.poll();
            for(int i=0; i<8; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 & ny<n && board[nx][ny]==1){
                    board[nx][ny] = 0;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public static class Point {
        public int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
