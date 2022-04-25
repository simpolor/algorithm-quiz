package io.simpolor.quiz.inflearn.탐색;

import java.util.Scanner;

// 깊이 우선 탐색
// 전위순회 1 2 4 5 3 6 7 : 부모가 기준 ( 부모 - 왼쪽 - 오른쪽 )
// 중위순회 4 2 5 1 6 3 7 : 왼쪽 기준 ( 왼쪽 - 부모 - 오른쪽 )
// 후위순위 4 5 2 6 7 3 1 : 오른쪽 기준 ( 왼쪽 - 오른쪽 - 부모 )
public class Q57_이진트리순회_DFS {

    public static void main(String[] args) {

        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();

        Node node = new Node(1);
        node.lt = new Node(2);
        node.rt = new Node(3);
        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);
        node.rt.lt = new Node(6);
        node.rt.rt = new Node(7);

        solution(node);
    }

    // 깊이 우선 탐색은 계속 자식까지 탐색함
    // lt, rt는 주소 값을 가진다.
    // 재귀를 이용한 탐색 ( 메소드 호출에 따라 순회가 달라짐 )
    // 스택 프레임을 잘 이해 해야함
    public static void solution(Node root){
        if(root == null){
            return;
        }else{
            // System.out.print(root.data + " "); // 전위 순회 출력
            solution(root.lt);
            // System.out.print(root.data + " "); // 중위 순회 출력
            solution(root.rt);
            // System.out.print(root.data + " "); // 후위 순회 출력
        }
    }

    public static class Node {
        int data;
        Node lt, rt;
        public Node(int value){
            data = value;
            lt = rt = null;
        }
    }
}
