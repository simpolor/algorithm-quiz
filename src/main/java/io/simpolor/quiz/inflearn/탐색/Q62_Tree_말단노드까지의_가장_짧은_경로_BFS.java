package io.simpolor.quiz.inflearn.탐색;

import java.util.LinkedList;
import java.util.Queue;

// DFS는 재귀, BFS는 큐
public class Q62_Tree_말단노드까지의_가장_짧은_경로_BFS {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.lt = new Node(2);
        node.rt = new Node(3);
        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);

        solution(node);
        int answer = solution(node);
        System.out.println(answer);
    }

    public static int solution(Node root){

        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                if(node.lt == null && node.rt == null){
                    return level;
                }
                if(node.lt != null){
                    queue.offer(node.lt);
                }
                if(node.rt != null){
                    queue.offer(node.rt);
                }
            }
            level++;
        }

        return 0;
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
