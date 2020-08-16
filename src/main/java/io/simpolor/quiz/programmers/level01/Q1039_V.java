package io.simpolor.quiz.programmers.level01;

import java.util.*;

public class Q1039_V {

    /***
     * 실패율
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 실패율
     * failture_rate1.png
     *
     * 슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다.
     * 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다.
     * 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
     *
     * 이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다.
     * 역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다.
     * 오렐리를 위해 실패율을 구하는 코드를 완성하라.
     *
     * - 실패율은 다음과 같이 정의한다.
     *   + 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
     *
     * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
     * 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
     *
     * ------------------------------
     * 제한사항
     * ------------------------------
     * - 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
     * - stages의 길이는 1 이상 200,000 이하이다.
     * - stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
     *   + 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
     *   + 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
     * - 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
     * - 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * N	stages	result
     * 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
     * 4	[4,4,4,4,4]	[4,1,2,3]
     *
     * ------------------------------
     * 입출력 예 설명
     * ------------------------------
     * 입출력 예 #1
     * 1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.
     * 1 번 스테이지 실패율 : 1/8
     *
     * 2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.
     * 2 번 스테이지 실패율 : 3/7
     *
     * 마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
     * 3 번 스테이지 실패율 : 2/4
     * 4 번 스테이지 실패율 : 1/2
     * 5 번 스테이지 실패율 : 0/1
     *
     * 각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.
     * [3,4,2,1,5]
     *
     * 입출력 예 #2
     *
     * 모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.
     * [4,1,2,3]
     *
     */
    public static void main(String[] args){

        int N = 5;
        int[] stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};

        Solution solution = new Solution();
        int[] result = solution.solution(N, stages);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public int[] solution(int N, int[] stages) {

            int[] answer = new int[N];



            for(int i=0; i<N; i++){
                for(int j=0; j<stages.length; j++){

                }
            }

            return answer;
        }
    }

    public static class Solution1 {
        public int[] solution(int N, int[] stages){
            int[] answer = {};
            answer = new int[N];

            List<item> list = new LinkedList<item>();

            for(int i = 1; i <= N; i++){
                int stagePeople = 0;
                int challengePeople = 0;
                for(int j = 0; j < stages.length; j++){
                    if(i <= stages[j]){
                        stagePeople++;
                        if( i == stages[j]){
                            challengePeople++;
                        }
                    }
                }

                double fail = (double)challengePeople / (double)stagePeople;
                list.add(new item(i, fail));
            }

            Collections.sort(list, new Comparator<item>(){
                @Override
                public int compare(item i1, item i2){
                    System.out.println(i1.index + " vs " + i2.index);
                    if(i1.fail > i2.fail){
                        return -1;
                    } else if(i1.fail < i2.fail){
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i).index;
            }
            return answer;
        }

        class item {
            public int index;
            public double fail;
            public item(int i, double f){
                this.index = i;
                this.fail = f;
            }
        }
    }

    public static class Solution2 {
        public int[] solution(int N, int[] stages) {
            double[][] array = new double[N][2];
            int[] answer = new int[N];
            int player;
            int nonclear_stage;

            for(int i = 1; i <= N; i++) {
                player = 0;
                nonclear_stage = 0;
                for(int j = 0; j < stages.length; j++) {
                    if(i <= stages[j]) {
                        player++;
                    }
                    if(i == stages[j]) {
                        nonclear_stage++;
                    }
                }
                array[i - 1][0] = i;
                array[i - 1][1] = (double) nonclear_stage / player;
            }

            double emp1, emp2;

            int sw = 0;
            for(int i = 1; i <= array.length - 1; i++) {
                for(int j = 0; j <= ((array.length - 1) - i); j++) {
                    if(array[j][1] < array[j + 1][1]) {
                        emp1 = array[j][0];
                        emp2 = array[j][1];
                        array[j][0] = array[j + 1][0];
                        array[j][1] = array[j + 1][1];
                        array[j + 1][0] = emp1;
                        array[j + 1][1] = emp2;
                        sw = 1;
                    }
                }
                if(sw == 0) {
                    break;
                }
            }

            for(int i = 0; i <array.length; i++) {
                answer[i] = (int) array[i][0];
            }
            return answer;
        }
    }

    public static class Solution3 {
        public int[] solution(int n, int[] stages) {
            int[] answer = new int[n];
            double[][] fail = new double[n][2];
            Queue<Integer> q = new LinkedList<>();

            Arrays.sort(stages);
            for (int i = 0; i < stages.length; i++) {
                q.add(stages[i]);
            }

            for (int i = 0; i < n; i++) {
                int user = q.size();
                int step = i + 1;
                int failUser = 0;
                while (!q.isEmpty() && q.peek() == step) {
                    q.poll();
                    failUser++;
                }
                fail[i][0] = step;
                fail[i][1] = user!=0 ? (double) failUser / user : 0;
            }

            Arrays.sort(fail, (o1, o2) -> {
                if (o1[1] == o2[1]) return -1;
                else return Double.compare(o1[1], o2[1]);
            });

            for (int i = 0; i < fail.length; i++) {
                answer[fail.length - i - 1] = (int) fail[i][0];
            }

            System.out.println(Arrays.toString(answer));
            return answer;
        }
    }

    public static class Solution4 {
        public int[] solution(int N, int[] stages) {
            int[] answer = new int[N];
            int[] arr = new int[N];
            double[] arr2 = new double[N];
            int people = stages.length;

            Arrays.sort(stages);

            for(int i = 0; i < stages.length; i++) {
                if(stages[i] <= N) arr[stages[i] - 1]++;
            }
//      System.out.println(Arrays.toString(arr));

            arr2[0] = (double)arr[0] / people;
            people -= arr[0];
            for(int i = 1; i < N; i++) {
                if(people != 0) {
                    arr2[i] = (double)arr[i] / people;
                    people -= arr[i];
                } else {
                    arr2[i] = 0.0;
                }
            }

//      System.out.println(Arrays.toString(arr2));

            double max = arr2[0];
            int index = 0;
            for(int i = 0; i < N; i++) {
                max = arr2[0];
                index = 0;
                for(int j = 1; j < N; j++) {
                    if(max < arr2[j]) {
                        index = j;
                        max = arr2[j];
                    }
                }
                answer[i] = index + 1;
                arr2[index] = -1;
            }
            return answer;
        }
    }

}
