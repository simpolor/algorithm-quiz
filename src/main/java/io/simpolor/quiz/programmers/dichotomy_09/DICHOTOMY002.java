package io.simpolor.quiz.programmers.dichotomy_09;

import java.util.Arrays;

/***
 * 입국심사
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * n명이 입국심사를 위해 줄을 서서 기다리고 있습니다.
 * 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
 *
 * 처음에 모든 심사대는 비어있습니다.
 * 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다.
 * 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다.
 * 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
 *
 * 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
 *
 * 입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때,
 * 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
 * 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
 * 심사관은 1명 이상 100,000명 이하입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * n	times	return
 * 6	[7, 10]	28
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 가장 첫 두 사람은 바로 심사를 받으러 갑니다.
 * 7분이 되었을 때, 첫 번째 심사대가 비고 3번째 사람이 심사를 받습니다.
 * 10분이 되었을 때, 두 번째 심사대가 비고 4번째 사람이 심사를 받습니다.
 * 14분이 되었을 때, 첫 번째 심사대가 비고 5번째 사람이 심사를 받습니다.
 * 20분이 되었을 때, 두 번째 심사대가 비지만 6번째 사람이 그곳에서 심사를 받지 않고 1분을 더 기다린 후에 첫 번째 심사대에서 심사를 받으면 28분에 모든 사람의 심사가 끝납니다.
 *
 *
 * 출처
 *
 * ※ 공지 - 2019년 9월 4일 문제에 새로운 테스트 케이스를 추가하였습니다. 도움을 주신 weaver9651 님께 감사드립니다.
 *
 */
public class DICHOTOMY002 {

    public static void main(String[] args) {

        int n = 6;
        int[] times = new int[]{7, 10};


        Solution solution = new Solution();
        int result = solution.solution(n, times);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int n, int[] times) {
            Arrays.sort(times);
            return (int) find((long) n, times, (long) times.length, times[0], (long) ((long) times[0] * (long) n));
        }

        public long find(long n, int[] times, long nExamination, long from, long to) {
            long minTime;
            long tmp = n;
            if (from == to) {
                return from;
            }
            else {
                minTime = (from + to) / 2;// + ((from + to) % 2 == 1? 1 : 0);
                for (int i = 0; i < nExamination; i++) {
                    tmp -=  minTime / (long) times[i];
                }
                if (tmp > 0) {
                    return find(n, times, nExamination, minTime + 1, to);
                }
                else {
                    return find(n, times, nExamination, from, minTime);
                }
            }
        }
    }

    public static class Solution1 {
        public int solution(int n, int[] times) {
            int answer = 0;
            int max = 0;
            for(int i = 0; i < times.length; i++) {
                if(max < times[i]) {
                    max = times[i];
                }
            }
            long start = 1, end = (long)max * n;

            while(start < end) {
                long mid = (start + end) / 2;
                long t = 0;
                for(int i = 0; i < times.length; i++) {
                    t += mid / times[i];
                }
                if(t >= n) {
                    end = mid;
                }else {
                    start = mid + 1;
                }
            }
            answer = (int)end;
            return answer;
        }
    }

    public static class Solution2 {
        public static int solution(int n, int[] times) {
            long a = 1;
            long b = Integer.MAX_VALUE;
            b *= 100000;

            long answer = 0;

            while(a<=b){
                long c = (a+b)/2;

                long sum = 0; // 가능한 인원
                for(int i=0; i<times.length; i++){
                    sum += c/times[i];
                }

                if(sum >= n){
                    answer = c;
                    b = c-1;
                }else{
                    a = c+1;
                }
            }

            return (int)answer;
        }
    }

    public static class Solution3 {
        public int solution(int n, int[] times) {

            long answer = 0;
            int gates = times.length;
            Arrays.sort(times);
            long limit = times[gates - 1];

            // Binary Search
            long right = n * limit;
            long left = 1;
            answer = n * limit;
            while (left <= right) {
                long mid = (left + right) / 2;
                long count = 0;
                for (int i = 0; i < gates; i++)
                    count += mid / times[i];

                if (count < n) {
                    left = mid + 1;
                } else {
                    if (mid < answer)
                        answer = mid;
                    right = mid - 1;
                }
            }

            return (int)answer;
        }
    }

    public static class Solution4 {
        public long solution(int n, int[] times) {
            long answer=0;
            long mid=0, result;
            long start=1, end=(long)times[times.length-1]*n;


            while(start <= end){
                mid = (start+end)/2;
                answer=0;
                for(int i=0;i<times.length;i++){
                    answer += mid/times[i];
                }
                if(answer > n)
                    end = mid-1;
                else if(answer < n)
                    start= mid+1;
                else
                    break;
            }

            while(true){
                answer=0;
                for(int i=0;i<times.length;i++){
                    answer += (mid-1)/times[i];
                }
                if(answer == n)
                    mid -= 1;
                else
                    break;
            }

            return mid;
        }
    }

    public static class Solution5 {
        public long solution(int n, int[] times) {
            Arrays.sort(times);//시간 오름차순으로 정렬해줌
            long min = 1; // 최소시간은 1분
            long max = (long)times[times.length-1]*n; //최악의 경우 60분
            long mid = 0; //아직 설정하지않은 중간 값
            long sum = 0; //몇명이나 심사할 수 있는지 (mid시간에 몇명 심사가능?)

            long answer = max; // 최소시간을 저장해야함.

            while(min<=max) { // 최소값이 최대값보다 작을때,
                sum = 0;
                mid = (min+max)/2; // 가운대 값을 구해줌
                for(int time : times) { // 가운대 값으로 심사할 수 있는 사람의 수를 sum에 담는다.
                    sum += mid/time;
                }
                if(sum>=n) { // 7>=6
                    if(mid<answer) { //시간을 줄인다. 시간을 더 줄일 수 있으므로 (최소값을 구하는 문제)
                        answer = mid;
                    }
                    max=mid-1;
                }
                else {
                    min=mid+1;
                }
            }
            return answer;

        }
    }


}
