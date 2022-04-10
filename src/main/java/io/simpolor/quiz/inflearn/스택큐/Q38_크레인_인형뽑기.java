package io.simpolor.quiz.inflearn.스택큐;

import java.util.Scanner;
import java.util.Stack;

public class Q38_크레인_인형뽑기 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] boards = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                boards[i][j] = in.nextInt();
            }
        }
        int m = in.nextInt();
        int[] moves = new int[m];
        for(int i=0; i<m; i++){
            moves[i] = in.nextInt();
        }

        // 2차원 배열에서 행은 아래로, 열은 가로로 정렬됨, 아래를 보면 이해가 됨
        /*for(int[] x : boards){
            System.out.println(Arrays.toString(x));
        }*/

        int answer = solution(boards, moves);
        System.out.print(answer);
    }

    // 꺼낼때 동시에 2개가 터진다. 그러므로 +=2
    // 문제에 비해 코드는 단순하므로, 문제 이해가 아주 중요...
    public static int solution(int[][] boards, int[] moves){

        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for(int pos : moves){
            for(int i=0; i<boards.length; i++){
                if(boards[i][pos-1] != 0){
                    int tmp = boards[i][pos-1];
                    boards[i][pos-1] = 0;
                    if(!stack.isEmpty() && stack.peek() == tmp){
                        answer += 2;
                        stack.pop();
                    }else{
                        stack.push(tmp);
                    }
                    break; // 잊으면 안됨.
                }
            }
        }

        return answer;
    }
}
