package io.simpolor.quiz.programmers.condingTestPractice.dichotomy09;

import java.util.*;

/***
 * 징검다리
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 출발지점부터 distance만큼 떨어진 곳에 도착지점이 있습니다. 그리고 그사이에는 바위들이 놓여있습니다.
 * 바위 중 몇 개를 제거하려고 합니다.
 *
 * 예를 들어, 도착지점이 25만큼 떨어져 있고, 바위가 [2, 14, 11, 21, 17] 지점에 놓여있을 때
 * 바위 2개를 제거하면 출발지점, 도착지점, 바위 간의 거리가 아래와 같습니다.
 *
 * 제거한 바위의 위치,	각 바위 사이의 거리,	거리의 최솟값
 * [21, 17],	[2, 9, 3, 11],	2
 * [2, 21],	    [11, 3, 3, 8],	3
 * [2, 11],	    [14, 3, 4, 4],	3
 * [11, 21],	[2, 12, 3, 8],	2
 * [2, 14],	    [11, 6, 4, 4],	4
 *
 * 위에서 구한 거리의 최솟값 중에 가장 큰 값은 4입니다.
 *
 * 출발지점부터 도착지점까지의 거리 distance,
 * 바위들이 있는 위치를 담은 배열 rocks,
 * 제거할 바위의 수 n이 매개변수로 주어질 때,
 * 바위를 n개 제거한 뒤 각 지점 사이의 거리의 최솟값 중에 가장 큰 값을 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 도착지점까지의 거리 distance는 1 이상 1,000,000,000 이하입니다.
 * 바위는 1개 이상 50,000개 이하가 있습니다.
 * n 은 1 이상 바위의 개수 이하입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * distance	rocks	n	return
 * 25	[2, 14, 11, 21, 17]	2	4
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 문제에 나온 예와 같습니다.
 *
 */
public class DICHOTOMY003 {

    public static void main(String[] args) {

        int distance = 6;
        int[] rocks = new int[]{7, 10};
        int n = 6;


        Solution solution = new Solution();
        int result = solution.solution(distance, rocks, n);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int distance, int[] rocks, int n) {
            int answer = 0;
            Arrays.sort(rocks);

            int s = 1, e = distance, mid;
            while(s <= e) {
                mid = (s + e) /2;
                int cur = 0;
                int hits = 0;
                for(int i = 0; i < rocks.length; i++) {
                    if(rocks[i] - cur < mid) {
                        hits++;
                    }
                    else {
                        cur = rocks[i];
                    }
                }
                if(hits > n) {
                    e = mid-1;
                }
                else {
                    s = mid+1;
                }
            }
            answer = e;
            return answer;
        }
    }

    public static class Solution1 {
        public int solution(int distance, int[] rocks, int n) {
            LinkedList<Integer> list = new LinkedList<>();
            int nRocks = rocks.length;

            Arrays.sort(rocks);
            int s = 0;
            for(int i = 0; i < nRocks; i++) {
                list.add(rocks[i] - s);
                s = rocks[i];
            }
            list.add(distance - rocks[nRocks - 1]);

            return find(list, 0, distance, n);
        }

        public int find(LinkedList<Integer> numbers, int from, int to, int n) {
            if (from == to) return from;

            int mid = (from + to) / 2 + (((from + to) % 2 == 1)? 1 : 0);
            int count = 0;

            LinkedList<Integer> list = new LinkedList<>();
            list.addAll(numbers);

            Iterator<Integer> iterator = list.iterator();

            Integer e, nextE;
            int i = 0;
            boolean ok = true;
            while(iterator.hasNext()) {
                e = iterator.next();
                if (e < mid) {
                    if (iterator.hasNext()) {
                        nextE = iterator.next();
                        list.set(i, (e + nextE));
                        list.remove(i + 1);
                        count++;
                        if (count > n) {
                            ok = false;
                            break;
                        }
                        iterator = list.listIterator(i);
                    }
                    else {
                        ok = false;
                        break;
                    }
                }
                else i++;
            }

            if (ok) return find(numbers, mid, to, n);
            else return find(numbers, from, mid - 1, n);
        }
    }

    public static class Solution2 {
        public int solution(int distance, int[] rocks, int n) {
            int answer = 0;
            Arrays.sort(rocks);

            int start = 0, end = distance;
            while(start < end) {
                int mid = (start + end + 1) / 2;
                int remove = 0, temp = 0;
                for(int i = 0; i < rocks.length; i++) {
                    if(rocks[i] - temp < mid) {
                        remove++;
                    }else {
                        temp = rocks[i];
                    }
                }
                if(remove > n) {
                    end = mid - 1;
                }else {
                    start = mid;
                }
            }
            return answer = start;
        }
    }

    public static class Solution3 {
        public int solution(int distance, int[] rocks, int n) {
            Arrays.sort(rocks);
            int left = 0;
            int right = distance * 2;
            int answer = 0;
            while (left <= right) {
                int targetDistance = (left + right) / 2;
                int lastLocation = 0;
                int putRocksCount = 0;
                for (int i = 0; i < rocks.length; i++) {
                    if (i == rocks.length - 1) {
                        int currentDistance = rocks[i] - lastLocation;
                        if ((currentDistance >= targetDistance) && (distance - rocks[i]) >= targetDistance) {
                            putRocksCount++;
                        }
                    } else {
                        int currentDistance = rocks[i] - lastLocation;
                        if (currentDistance >= targetDistance) {
                            putRocksCount++;
                            lastLocation = rocks[i];
                        }
                    }
                }
                if (putRocksCount < (rocks.length - n)) {
                    right = targetDistance - 1;
                } else {
                    answer = Math.max(answer, targetDistance);
                    left = targetDistance + 1;
                }
            }
            return answer;
        }
    }

    public static class Solution4 {
        public int solution(int distance, int[] rocks, int n) {
            int max = 0;
            Arrays.sort(rocks);

            int left = 1, right = distance, mid = 0;
            while(left <= right) {
                int cnt = 0, prev = 0, min = distance;
                mid = (left + right) / 2;

                for(int i = 0; i < rocks.length; i++) {
                    if(rocks[i] - prev <= mid ) cnt++;
                    else {
                        min = Math.min(min, rocks[i] - prev);
                        prev = rocks[i];
                    }
                }
                if(distance - prev <= mid) cnt++;
                else min = Math.min(min, distance - prev);

                if(cnt <= n) {
                    max = Math.max(max, min);
                    left = mid + 1;
                }else right = mid - 1;
            }

            return max;
        }
    }




}
