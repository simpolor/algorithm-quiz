package io.simpolor.quiz.programmers.dfsAndBfs;

import java.util.*;

/***
 * 타겟 넘버
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * n개의 음이 아닌 정수가 있습니다.
 * 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
 *
 * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
 * 각 숫자는 1 이상 50 이하인 자연수입니다.
 * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * numbers,	    target,	    return
 * [1, 1, 1, 1, 1],	    3,	    5,
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 문제에 나온 예와 같습니다.
 *
 */
public class DFSANDBFS001 {

    public static void main(String[] args) {

        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int target = 3;


        Solution solution = new Solution();
        int result = solution.solution(numbers, target);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int[] numbers, int target) {
            int answer = 0;
            answer = dfs(numbers, 0, 0, target);
            return answer;
        }
        int dfs(int[] numbers, int n, int sum, int target) {
            if(n == numbers.length) {
                if(sum == target) {
                    return 1;
                }
                return 0;
            }
            return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
        }
    }

    public static class Solution1 {
        static int ans, goal, n, num[], cache[];

        public int solution(int[] numbers, int target) {
            n = numbers.length;
            num = numbers;
            cache = new int[n];
            goal = target;

            dfs(0);

            return ans;
        }

        static void dfs (int depth) {
            if (depth == n) {
                int sum = 0;
                for (int a : cache) sum += a;
                if (sum == goal) ans++;
                return;
            }

            cache[depth] = - num[depth];
            dfs(depth + 1);
            cache[depth] = num[depth];
            dfs(depth + 1);
        }
    }

    public static class Solution2 {
        public int solution(int[] numbers, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            caseCalculate(map, numbers, 0, 1, 0);
            caseCalculate(map, numbers, 0, -1, 0);
            return map.get(target);
        }

        public void caseCalculate(Map<Integer, Integer> cases, int[] numbers, int idx, int isPlus, int sum){
            sum += numbers[idx] * isPlus;
            if(idx == numbers.length-1){
                if(cases.containsKey(sum)){
                    cases.put(sum, cases.get(sum)+1);
                }
                else{
                    cases.put(sum, 1);
                }
            }
            else{
                caseCalculate(cases, numbers, idx+1, 1, sum);
                caseCalculate(cases, numbers, idx+1, -1, sum);
            }
        }

    }

    public static class Solution3 {
        public int solution(int[] numbers, int target) {
            int answer = 0;
            answer=bfs(numbers[0],numbers,target);
            System.out.println(answer);
            return answer;
        }
        public static int bfs(int start,int[] v,int target) {
            Queue<Integer> q= new LinkedList<>();
            q.add(start);
            q.add(-start);
            int i=0,k=0,kk=2;
            while(q.size()!=Math.pow(2, v.length)) {
                int temp=q.poll();
                if(k==kk) {
                    i++;kk+=Math.pow(2, i+1);
                    //System.out.println("???"+i);
                }
                //System.out.print(temp+" ");
                q.add(temp+v[i+1]);
                q.add(temp-v[i+1]);
                k++;
            }
            int cnt=0;
            //System.out.println();
            while(!q.isEmpty()){
                int temp=q.poll();

                //System.out.print(temp+"!");
                if(temp==target)cnt++;
            }
            return cnt;
        }
    }

    public static class Solution4 {
        public int solution(int[] numbers, int target) {
            int n = numbers.length;
            int answer = find(0, n, numbers, 0, target);
            return answer;
        }

        public int find(int k, int n, int[] numbers, int num, int target) {
            if (k == n) {
                if (num == target) {
                    return 1;
                } else {
                    return 0;
                }
            }
            return find(k + 1, n, numbers, num + numbers[k], target)
                    + find(k + 1, n, numbers, num - numbers[k], target);
        }
    }

    public static class Solution5 {

        public int solution(int[] numbers, int target) {
            int answer = 0;

            Queue<Integer> bfs=new LinkedList<>();
            int cnt=0;

            bfs.add(numbers[0]);
            bfs.add(-numbers[0]);
            while(!bfs.isEmpty() ) {


                if(bfs.size()==Math.pow(2, numbers.length)  ) {
                    Iterator<Integer> it =bfs.iterator();
                    while(it.hasNext()) {
                        int data=it.next();
                        if(data==target)answer++;

                    }
                    break;

                }


                if(bfs.size()==Math.pow(2, cnt+1) ) {
                    cnt++;
                }

                int temp=bfs.poll();

                bfs.add(temp+numbers[cnt]);
                bfs.add(temp-numbers[cnt]);



            }

            return answer;
        }
    }

    public static class Solution6 {
        public int solution(int[] numbers, int target) {
            int answer = 0;
            int len = numbers.length;
            for(int i=1; i<Math.pow(2,len); i++) {
                int[] bit = new int[len];
                int n = i;
                int idx = len-1;
                while(n>1) {
                    bit[idx--] = n%2;
                    n = n/2;
                }
                bit[idx--] = 1;
                int cur = 0;
                for(int j=0; j<len; j++) {
                    int pm = 1;
                    if(bit[j] == 1)
                        pm = -1;
                    cur += pm*numbers[j];
                }
                if(cur == target)
                    answer++;
            }

            return answer;
        }
    }


    public static class Solution9 {
        public int solution(int[] numbers, int target) {
            int answer = 0;
            Node node = new Node(0);  // 초기 값 0부터 시작

            for(int i=0; i<numbers.length; i++)
            {
                node.setNode(node, numbers[i]);
            }

            answer = node.countValue(node, target);

            return answer;
        }

        class Node
        {
            private int value;
            private Node rightNode ;   //+ 노드
            private Node leftNode ;    //- 노드
            public Node()
            {
                value=0;
            }
            public Node(int value)
            {
                this.value =value;
                this.rightNode = null;
                this.leftNode = null;
            }
            /*
             * 다음 depth의 노드를 셋팅 한다.
             * 현재 노드가 leaf 노드면 다음 노드를 셋팅 한다.
             */
            public void setNode(Node node,int val)
            {
                if(!node.isTerminal())
                {
                    setNode(node.leftNode,val);
                    setNode(node.rightNode,val);
                }
                else
                {
                    node.rightNode = new Node(node.getValue() + val);
                    node.leftNode = new Node(node.getValue() - val);
                }
            }

            public boolean isTerminal()
            {
                return this.rightNode==null && this.leftNode==null ? true : false;
            }
            public int countValue(Node node,int value)
            {
                int cnt =0;

                if(!node.isTerminal())
                {
                    return countValue(node.leftNode,value) +countValue(node.rightNode,value);
                }
                else
                {
                    if(node.getValue() == value)
                    {
                        return 1;
                    }
                }

                return 0;

            }

            public void searchNode(Node node)
            {

            }
            public int getValue()
            {
                return this.value;
            }

        }
    }



}
