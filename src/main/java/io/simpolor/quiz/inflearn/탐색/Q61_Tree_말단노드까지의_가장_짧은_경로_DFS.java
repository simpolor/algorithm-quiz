package io.simpolor.quiz.inflearn.탐색;

// 힌쪽 자식이 있으면 DFS로 풀기 힘든 문제
// 자신이 두짝이 꼭 있어야함
public class Q61_Tree_말단노드까지의_가장_짧은_경로_DFS {

    public static void main(String[] args) {

        int level = 0;

        Node node = new Node(1);
        node.lt = new Node(2);
        node.rt = new Node(3);
        node.lt.lt = new Node(4);
        node.lt.rt = new Node(5);

        solution(level, node);
        int answer = solution(0, node);
        System.out.println(answer);
    }

    // 레벨을 구하는 함수.. 그림을 그려보면 바로 이해가됨
    // 결국 말단 노드의 레벨을 리턴 받고 min 값을 리턴 받으므로 작은 값을 받는다.
    public static int solution(int level, Node node){

        if(node.lt == null && node.rt == null){
            return level;
        }
        return Math.min(solution(level + 1, node.lt), solution(level+1, node.rt));
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
