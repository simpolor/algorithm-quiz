package io.simpolor.quiz.inflearn.탐색;

import java.util.LinkedList;
import java.util.Queue;

// BFS는 넓이 우선탐색: 레벨탐색, 깊이 우선과 반대로 레벨부터 전부 탐색하면서 아래로 진행됨
public class Q59_이진트리_레벨탑색_BFS {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.lt = new Node(2);
        node.rt = new Node(3);
        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);
        node.rt.lt = new Node(6);
        node.rt.rt = new Node(7);

        solution(node);
    }

    // 큐를 이용해서, 단순히 한동작이 아니라, 출력순간 입력하는 방식도 사용
    // 레벨이 거리다.
    public static void solution(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            System.out.print(level + " : ");
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                System.out.print(node.data+ " ");

                // 큐에서 뽑아 내면서, lt, rt를 입력
                if(node.lt != null){
                    queue.offer(node.lt);
                }
                if(node.rt != null){
                    queue.offer(node.rt);
                }
            }
            level++; // 레벨은 큰의미가 없음 출력을 위한 용도, 다른 문제 풀때는 거리라고 생각하면된다.
            System.out.println();
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
