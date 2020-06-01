package io.simpolor.quiz.programmers.stackAndQueue_02;

import java.util.*;

/***
 * 기능개발
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 *
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 *
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 *
 * ------------------------------
 * 제한 사항
 * ------------------------------
 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 * 작업 진도는 100 미만의 자연수입니다.
 * 작업 속도는 100 이하의 자연수입니다.
 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * progresses	speeds	return
 * [93,30,55]	[1,30,5]	[2,1]
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
 * 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
 * 세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
 *
 * 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
 */
public class STACTANDQUEUE003 {

    public static void main(String[] args) {

        int[] progresses = new int[]{93,30,55};
        int[] speeds = new int[]{1,30,5};

        Solution solution = new Solution();
        int[] result = solution.solution(progresses, speeds);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {

        public int[] solution(int[] progresses, int[] speeds) {

            int max = progresses.length;
            int day = 0;
            int[] days = new int[max];
            for (int i = 0; i < max; i++) {
                day = progresses[i];
                while (day < 100) {
                    days[i]++;
                    day += speeds[i];
                }
            }

            int skipDay = 0;
            ArrayList<Integer> integers = new ArrayList<>();
            day = days[0];
            int nextday = days[1];
            skipDay = 0;

            for (int i = 0; i < max; i++) {

                //뭘하든 넥스트 데이는 하루씩 밀림
                try {
                    nextday = days[i + 1];
                }catch (Exception e){
                    integers.add(skipDay+1);
                }

                if (day < nextday) {
                    //그럼 나혼자 갈께
                    integers.add(skipDay + 1);
                    day = nextday;
                    skipDay=0;
                    //i값이 그럼 day 를 가져야함
                }else {
                    skipDay++;
                }
                //묶어가자
            }
            int[] answer = new int[integers.size()];
            day = 0;
            for (int temp : integers) {
                answer[day] = temp;
                day++;
            }
            return answer;
        }
    }

    public static class Solution1 {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] dayOfend = new int[100];
            int day = -1;
            for(int i=0; i<progresses.length; i++) {
                while(progresses[i] + (day*speeds[i]) < 100) {
                    day++;
                }
                dayOfend[day]++;
            }
            return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
        }
    }

    public static class Solution2 {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> q = new LinkedList<>();
            List<Integer> answerList = new ArrayList<>();

            for (int i = 0; i < speeds.length; i++) {
                double remain = (100 - progresses[i]) / (double) speeds[i];
                int date = (int) Math.ceil(remain);

                if (!q.isEmpty() && q.peek() < date) {
                    answerList.add(q.size());
                    q.clear();
                }

                q.offer(date);
            }

            answerList.add(q.size());

            int[] answer = new int[answerList.size()];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = answerList.get(i);
            }

            return answer;
        }
    }

    public static class Solution3 {

        int progressesCount;
        int[] needDays;

        ArrayList<Integer> workCountStorage;

        public int[] solution(int[] progresses, int[] speeds) {

            //Init
            progressesCount = progresses.length;
            needDays = new int[progressesCount];
            workCountStorage = new ArrayList<>();


            //필요한 작업일 계산
            this.calcNeedDays(progresses, speeds);

            //this.viewAll(needDays, 0);


            //동시에 진행된 프로세스 계산
            for(int step=0; step<progressesCount;)
            {
                int stepNeedDay = needDays[step];

                //날짜 동시에 경과
                for(int remainStep=step; remainStep<progressesCount; remainStep++)
                {
                    needDays[remainStep] -= stepNeedDay;
                }

                //this.viewAll(needDays, step);

                //완료한 작업까지의 갯수
                int workCount = 1;
                for(;step+workCount<progressesCount; workCount++)
                {
                    if(needDays[step+workCount] > 0)
                    {
                        break;
                    }
                }

                System.out.println("workCount:"+workCount);

                //완료한 작업 갯수 저장
                workCountStorage.add(workCount);

                //작업 갯수만큼 step 증가
                step += workCount;

            }

            //int[] answer = {};
            int[] answer = Solution3.convertIntegers(workCountStorage);
            return answer;
        }

        private void calcNeedDays(int[] progresses, int[] speeds)
        {
            for(int i=0; i<progressesCount; i++)
            {
                double remainProgress = 100 - progresses[i];
                double fNeedDay = remainProgress / speeds[i];

                needDays[i] = (int)Math.ceil(fNeedDay);
            }
        }

        public static int[] convertIntegers(ArrayList<Integer> integers)
        {
            int size = integers.size();
            int[] ret = new int[size];
            for (int i=0; i<size; i++)
            {
                ret[i] = integers.get(i).intValue();
            }
            return ret;
        }

        private void viewAll(int[] array, int startIdx)
        {
            System.out.print("viewAll:");

            int arrayCount = array.length;
            for(int i=startIdx; i<arrayCount; i++)
            {
                System.out.print(array[i]+",");
            }

            System.out.println();
        }
    }

    public static class Solution4 {
        public int[] solution(int[] progresses, int[] speeds) {
            ArrayList<Integer> list = new ArrayList<>();

            int temp = 0;
            for (int i = 0; i < progresses.length; i++) {
                int current = (100 - progresses[i]) / speeds[i];
                if (temp < current) {
                    temp = current;
                    list.add(1);
                } else list.set(list.size() - 1, list.get(list.size() - 1) + 1);
            }

            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static class Solution5 {
        public int[] solution(int[] progresses, int[] speeds) {
            int taskCount = progresses.length;
            int[] neededDays = new int[taskCount];
            int[] tempDistributes = new int[taskCount];
            int[] distributes;

            for(int i = 0; i < taskCount; i++){
                int remainedProgress = 100 - progresses[i];
                int estimatedDays = remainedProgress / speeds[i];
                if(remainedProgress % speeds[i] != 0){
                    estimatedDays++;
                }

                neededDays[i] = estimatedDays;
            }

            int days = 0;
            int distributeCount = 0;
            int index = 0;
            int lastDistributedIndex = 0;

            for(int i = 0; i < taskCount; i++){
                for(int j = 0; j < taskCount; j++){
                    if(neededDays[j] == -1){
                        continue;
                    }

                    if(distributeCount == 0){
                        days = neededDays[j];
                        distributeCount++;
                        neededDays[j] = -1;
                        lastDistributedIndex = j;
                        continue;
                    }

                    if(days < neededDays[j]){
                        neededDays[j] = neededDays[j] - days;
                    } else {
                        int diff = j - lastDistributedIndex;
                        if(diff == 1){
                            distributeCount++;
                            neededDays[j] = -1;
                            lastDistributedIndex = j;
                        }else{
                            neededDays[j] = 0;
                        }
                    }
                }
                if(distributeCount != 0){
                    tempDistributes[index] = distributeCount;
                    index++;
                    distributeCount = 0;
                } else {
                    break;
                }
            }

            distributes = new int[index];
            for(int i = 0; i < distributes.length; i++){
                distributes[i] = tempDistributes[i];
            }

            int[] answer = distributes;
            return answer;
        }
    }

    public static class Solution6 {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer;

            int[] dayOfend = new int[100];
            int day = -1;
            for(int i=0; i<progresses.length; i++) {
                while(progresses[i] + (day*speeds[i]) < 100) {
                    day++;
                }
                dayOfend[day]++;
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i : dayOfend) {
                if(i!=0) {list.add(i);}
            }

            answer = new int[list.size()];
            for(int i=0; i<answer.length; i++) {
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

}
