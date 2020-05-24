package io.simpolor.quiz.programmers.stackAndQueue;

import java.util.*;

/***
 * 프린터
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
 * 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
 *
 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
 * 3. 그렇지 않으면 J를 인쇄합니다.
 * 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
 *
 * 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
 *
 * 현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
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
 */
public class STACTANDQUEUE004 {

    public static void main(String[] args) {

        int[] priorities = new int[]{2, 1, 3, 2};
        int location = 2;

        Solution solution = new Solution();
        int result = solution.solution(priorities, location);

        System.out.println(result);
    }

    public static class Solution {
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

    public static class Solution1 {

        public int solution(int[] priorities, int location) {

            int answer = 0; // 응답
            int l = location; // 위치

            // 반복문을 위한 큐
            Queue<Integer> que = new LinkedList<>();
            for(int i : priorities){
                que.add(i);
            }

            // 정렬을 이용하여 priorities를 오름차순 정렬
            Arrays.sort(priorities);
            int size = priorities.length-1;

            while(!que.isEmpty()){

                // 큐에 담았던 값을 가져옴
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
                        l = que.size()-1;
                }
            }

            return answer;
        }
    }


    public static class Solution2 {
        public int solution(int[] priorities, int location) {
            int answer = 0;

            int max = 0;
            int len = priorities.length;
            // for (int i : priorities) {
            //  System.out.print(i + " ");
            // }
            // System.out.println();

            while (true) {
                answer++;

                // System.out.println("location : "+location);

                max = 0;
                int maxIndex = 0;
                // max 찾기
                for (int i = 0; i < len; i++) {
                    if (max < priorities[i]) {
                        max = priorities[i];
                        maxIndex = i;
                    }
                }

                // 처음값이 최대값이 아니라면 회전하기 - location 값 변경

                if (maxIndex != 0) {
                    int[] tempArr = new int[maxIndex];

                    for (int i = 0; i < maxIndex; i++) {
                        tempArr[i] = priorities[i];
                    }

                    // for (int i : tempArr) {
                    //  System.out.print(i + " ");
                    // }
                    // System.out.println();

                    int j;
                    for (j = 0; j+maxIndex < len; j++) {
                        priorities[j] = priorities[j+maxIndex];
                    }

                    for (int i = 0; i < maxIndex; i++) {
                        priorities[j++] = tempArr[i];
                    }

                    location -= maxIndex;

                    if (location < 0) {
                        location += len;
                    }

                }

                // pop!!

                if (location == 0)
                    break;

                // for (int i : priorities) {
                // System.out.print(i + " ");
                // }
                // System.out.println();

                for (int i = 1; i < len; i++) {
                    priorities[i - 1] = priorities[i];
                }
                // for (int i = 1; i < len; i++) {
                //  System.out.print(priorities[i] + " ");
                // }
                // System.out.println();
                location--;
                len--;
            }

            return answer;
        }
    }

    public static class Solution3 {
        public int solution(int[] priorities, int location) {
            if (priorities.length == 1) {
                return 1;
            }
            int answer = 1;
            LinkedList<Paper> papers = new LinkedList<>();
            for (int i = 0; i < priorities.length; i++) {
                papers.addLast(new Paper(i, priorities[i]));
            }

            while (true) {
                Paper paper = papers.removeFirst();
                for (Paper item : papers) {
                    if (paper.priority < item.priority) {
                        papers.addLast(paper);
                        paper = null;
                        break;
                    }
                }
                if (paper != null) {
                    if (paper.item == location) {
                        return answer;
                    } else {
                        answer++;
                    }
                }
            }
        }


        class Paper {
            int item;
            int priority;

            public Paper(int item, int priority) {
                this.item = item;
                this.priority = priority;
            }
        }
    }

    public static class Solution4 {

        public static int solution(int[] priorities, int location) {
            int answer = 0;
            Queue<Integer> que = new LinkedList<>();

            // priorities배열을 큐에 넣음
            for (Integer i : priorities) {
                que.offer(i);
            }

            int size = que.size();

            Loop:while (true) {
                // 가장 큰 숫자 판별용 카운트
                for (Integer j : que) {
                    if (que.peek() < j) {
                        if (location == 0) {
                            que.offer(que.poll());
                            location = que.size() - 1;
                        } else {
                            que.offer(que.poll());
                            location--;
                        }
                        continue Loop;
                    }
                }
                que.poll();
                // 얻고자하는 위치가 0이 됐을 때 초기 사이즈와 현재 사이즈를 빼서 순서구함
                if (location == 0) {
                    answer = size - que.size();
                    break;
                }
                location--;
            }
            return answer;
        }
    }

    public static class Solution5 {

        public int solution(int[] priorities, int location) {
            int[] sortedPrts = priorities.clone();
            Arrays.sort(sortedPrts);

            int spIdx=sortedPrts.length-1;
            LinkedList<Integer> prtIdxs = new LinkedList<>();
            for (int i=0; i<priorities.length; i++) {
                prtIdxs.addLast(i);
            }

            int cnt = 0;
            while (!prtIdxs.isEmpty()) {
                int prtIdx = prtIdxs.getFirst();
                if (priorities[prtIdx] >= sortedPrts[spIdx]) {
                    prtIdxs.removeFirst();
                    spIdx--;

                    cnt++;
                    if (prtIdx == location) {
                        break;
                    }

                } else {
                    prtIdxs.addLast(prtIdxs.removeFirst());
                }
            }

            return cnt;
        }

    }

    public static class Solution6 {
        public int solution(int[] priorities, int location) {
            int answer = 0;

            Queue<Integer> q = new LinkedList<>();
            PriorityQueue<Integer> bq = new PriorityQueue<>(
                    new Comparator<Integer> () {
                        public int compare(Integer a, Integer b) {
                            return b - a;
                        }
                    }
            );

            for(int i=0; i<priorities.length; i++){
                q.add(priorities[i]);
                bq.add(priorities[i]);
            }
            while(!q.isEmpty()){
                if(q.peek() == bq.peek()) {
                    q.poll();
                    bq.poll();
                    answer++;
                    if(location == 0){
                        return answer;
                    }
                } else {
                    q.add(q.poll());
                }
                if(location > 0){
                    location--;
                } else {
                    location = q.size()-1;
                }

            }
            return answer;
        }
    }


}
