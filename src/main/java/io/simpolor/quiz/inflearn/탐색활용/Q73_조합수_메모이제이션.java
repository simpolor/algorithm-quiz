package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Scanner;

// 조합의 경우의 수 ( 피보나치 수열? )
// 예를 들면 5명 중에서 3명을 뽑는 경우 수는
// 4명에서 2명 뽑는 경우의 수와 ( 예를 들 경우 5가 무조건 참여했다는 경우 그렇기때문애 2명만 뽑음 )
// 4명에서 3명 뽑는 경우의 수를 더하면 동일하다. ( 5가 무조건 참여하지 않았다는 경우, 5가 참여하지 않았기 때문에 3명 뽑음 )
// 그렇게 DFS가 반복됨 갈래가 2갈래로 나눠짐
// 종료 시점은 r==0이거나, n==r인 경우 1을 리턴
public class Q73_조합수_메모이제이션 {

    public static int n, r;
    public static int[][] dy = new int[35][35]; // 메모제이션

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        r = scanner.nextInt();

        System.out.println(DFS(n, r));
    }

    public static int DFS(int n, int r){

        if(dy[n][r]>0){
            return dy[n][r];
        }

        if(n==r || r==0){
            return 1;
        }else{
            return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }
}
