package io.simpolor.quiz.programmers.level02;

import java.util.*;

/***
 * 프린터
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다.
 * 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
 * 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
 * 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
 *
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 *
 * 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
 *
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다.
 * 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
 *
 * 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와
 * 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
 * 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
 * location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * priorities	location	return
 * [2, 1, 3, 2]	2	1
 * [1, 1, 9, 1, 1, 1]	0	5
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 예제 #1
 *
 * 문제에 나온 예와 같습니다.
 *
 * 예제 #2
 *
 * 6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.
 *
 */
public class Q_프린터 {

    public static void main(String[] args){

        int[] priorities = new int[]{2, 1, 3, 2};
        int location = 2;

        /*int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;*/

        Solution3 solution = new Solution3();
        int result = solution.solution(priorities, location);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int[] priorities, int location) {

            // 순서와 중요도를 저장하는 큐를 생성
            Queue<print> queue = new LinkedList<>();
            for(int i=0; i<priorities.length; i++){
                queue.add(new print(i, priorities[i]));
            }

            // 중요도 높은 순으로 가장 앞으로 가도록 정렬하여 리스트 생성
            List<print> result = new ArrayList<>();
            while (!queue.isEmpty()){

                print poll = queue.poll();

                // 현제 개체보다 다음 개체의 중요도를 비교
                boolean check = false;
                for(print q : queue){
                    if(q.priority > poll.priority){
                        check = true;
                        break;
                    }
                }

                // 다음 개체의 중요도가 현재 개체의 중요도보다 높은 경우 현재 개체를 맨 마지막으로 이동
                if(check){
                    queue.add(poll);
                }else{
                    result.add(poll);
                }
            }

            // 정렬된 리스트의 Print의 index와 location 같은지 비교하여 출력
            int answer = 1;
            for(print p : result){
                if(p.index == location){
                    break;
                }
                answer++;
            }

            return answer;
        }

        class print{
            int index;
            int priority;

            print(int index, int priority){
                this.index = index;
                this.priority = priority;
            }
        }
    }

    // location을 줄이는 방법
    public static class Solution1 {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            int l = location;

            Queue<Integer> que = new LinkedList<Integer>();
            for(int i : priorities){
                que.add(i);
            }

            Arrays.sort(priorities);
            int size = priorities.length-1;



            while(!que.isEmpty()){
                Integer i = que.poll();
                if(i == priorities[size - answer]){
                    answer++;
                    l--;
                    if(l <0)
                        break;
                }else{
                    que.add(i);
                    l--;
                    if(l<0)
                        l=que.size()-1;
                }
            }

            return answer;
        }
    }

    public static class Solution2 {
        public int solution(int[] priorities, int location) {
            List<Integer> list = new ArrayList<>();
            for (int priority : priorities) {
                list.add(priority);
            }

            int turn = 1;
            while (!list.isEmpty()) {
                final Integer j = list.get(0);
                if (list.stream().anyMatch(v -> j < v)) {
                    list.add(list.remove(0));
                } else {
                    if (location == 0) {
                        return turn;
                    }
                    list.remove(0);
                    turn++;
                }

                if (location > 0) {
                    location--;
                } else {
                    location = list.size() - 1;
                }
            }

            throw new IllegalArgumentException();
        }
    }

    // 멋진 코드
    public static class Solution3 {
        public int solution(int[] priorities, int location) {
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : priorities) {
                q.add(i);
            }
            int ans = 0;
            while (!q.isEmpty()) {

                for (int i = 0; i < priorities.length; i++) {
                    if (q.peek() == priorities[i]) {
                        q.poll();
                        ans++;
                        if (location == i) {
                            q.clear();
                            break;
                        }
                    }
                }
            }
            return ans;
        }
    }

    public static class Solution4 {
        public int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<Integer> qu = new LinkedList<Integer>();

            for(int num : priorities)
                qu.add(num);

            Arrays.sort(priorities);
            System.out.println(qu);
            while(!qu.isEmpty()){
                if(qu.peek() == Collections.max(qu)){
                    qu.poll();
                    ++answer;
                    --location;
                    if(location < 0)
                        break;
                } else{
                    qu.add(qu.poll());
                    location = location == 0 ? qu.size() - 1 : --location;
                }
            }
            return answer;
        }
    }

    public static class Solution5 {
        public int solution(int[] priorities, int location) {
            int answer = 0;

            Queue<Integer> queue = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < priorities.length; i++) {
                queue.add(priorities[i]);
                list.add(priorities[i]);
            }

            int count = 0;

            while (!queue.isEmpty()) {
                list.sort(Collections.reverseOrder());
                if (queue.element().equals(list.get(0))) {
                    queue.poll();
                    list.remove(0);
                    location--;
                    count++;
                    if (location == -1) {
                        answer = count;
                        break;
                    }
                } else {
                    int temp = queue.element();
                    queue.poll();
                    queue.offer(temp);
                    location--;
                    if (location == -1) {
                        location = queue.size()-1;
                    }
                }

            }


            return answer;
        }
    }


}
