package io.simpolor.quiz.inflearn.탐색활용;

import java.util.Scanner;

// 지금까지는 두가닥으로 이진트리 형태의 이진트리가 뻗어나감
// 중복 순열은 여러가닥으로 뻗어나감
// 3 2, 3범위 2배열
// 1 1, 1 2, 1 3
// 2 1, 2 2. 2 3
// 3 1, 3 2, 3 3
// DFS(0) 1    2    3
// DFS(1)123  123  123
// if L == m는 return 후 출력
public class Q70_중복순열 {

    public static int n, m;
    public static int[] pm;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        pm = new int[m];
        DFS(0);
    }

    public static void DFS(int level){

        if(level == m){
            for(int x: pm){ // 오버라이트로 1 1, 1 2, 1 3, 2 1, 2 2....이런씩
                System.out.print(x + " ");
            }
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                pm[level] = i; // 레벨에 i 값을 입력한다.
                DFS(level+1);
            }
        }
    }
}
