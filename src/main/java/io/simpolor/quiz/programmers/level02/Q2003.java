package io.simpolor.quiz.programmers.level02;

import java.util.*;

/***
 * 기능개발
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다.
 * 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 *
 * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
 * 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 *
 * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
 * 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 *
 * ------------------------------
 * 제한 사항
 * ------------------------------
 * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 * 작업 진도는 100 미만의 자연수입니다.
 * 작업 속도는 100 이하의 자연수입니다.
 * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
 * 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
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
 * 1. 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
 * 2. 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다.
 *    하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
 * 3. 세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
 *
 * 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
 *
 * ※ 공지 - 2020년 7월 14일 테스트케이스가 추가되었습니다.
 *
 */
public class Q2003 {

    public static void main(String[] args){

        int[] progresses = new int[]{93,30,55};
        int[] speeds = new int[]{1,30,5};

        Solution solution = new Solution();
        int[] result = solution.solution(progresses, speeds);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            int[] release = new int[progresses.length];

            for(int i=0; i<progresses.length; i++){
                int progress = progresses[i];
                int speed = speeds[i];
                int cnt = 0;

                for(int j=progress; j<100; j+=speed){
                    cnt++;
                }
                release[i] = cnt;
            }

            List list = new ArrayList();
            for(int i=0; i<release.length; i++){
                int cnt = 1;
                for(int j=i+1; j<release.length; j++){
                    if(release[i] >= release[j]){
                        cnt++;
                    }else{
                        break;
                    }
                }

                // 중복 건너띄는 작업
                i = i + cnt - 1;

                list.add(cnt);
            }

            int[] answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = (Integer) list.get(i);
            }

            return answer;
        }
    }

    public static class Solution1 {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] dayOfend = new int[100];
            int day = -1;
            for(int i=0; i<progresses.length; i++) {
                while(progresses[i] + (day * speeds[i]) < 100) {
                    day++;
                }
                dayOfend[day]++;
            }
            return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
        }
    }

    public static class Solution2 {
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

    public static class Solution3 {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            Queue<Integer> q = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();

            for(int i = 0; i < progresses.length; i++){
                if((100 - progresses[i]) % speeds[i] == 0){
                    q.offer((100 - progresses[i]) / speeds[i]);
                }
                else{
                    q.offer(((100 - progresses[i]) / speeds[i]) + 1);
                }
            }

            int precnt = q.poll();
            int works = 1;
            while(!q.isEmpty()){
                int curcnt = q.poll();
                if(precnt >= curcnt){
                    works++;
                }
                else{
                    list.add(works);
                    works = 1;
                    precnt = curcnt;
                }
            }
            list.add(works);

            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    public static class Solution4 {
        public int[] solution(int[] progresses, int[] speeds) {
            int[] answer = {};
            List<Integer> results = new ArrayList<>();

            int offset = 0;
            int days = 0;
            int cnt = 0;
            while (true) {
                cnt = 0;
                for (int i = offset; i < speeds.length; i++) {
                    if (progresses[i] + (speeds[i] * (days + 1)) < 100) {
                        break;
                    }
                    cnt++;
                }
                if (cnt > 0) {
                    results.add(cnt);
                    offset += cnt;
                }
                days++;
                if (offset >= speeds.length) {
                    break;
                }
            }

            answer = new int[results.size()];
            for (int i = 0; i < results.size(); i++) {
                answer[i] = results.get(i);
            }
            return answer;
        }
    }


}
