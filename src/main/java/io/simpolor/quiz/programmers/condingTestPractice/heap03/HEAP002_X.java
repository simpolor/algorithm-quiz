package io.simpolor.quiz.programmers.condingTestPractice.heap03;

import java.util.*;

/***
 * 라면공장
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 라면 공장에서는 하루에 밀가루를 1톤씩 사용합니다.
 * 원래 밀가루를 공급받던 공장의 고장으로 앞으로 k일 이후에야 밀가루를 공급받을 수 있기 때문에 해외 공장에서 밀가루를 수입해야 합니다.
 *
 * 해외 공장에서는 향후 밀가루를 공급할 수 있는 날짜와 수량을 알려주었고,
 * 라면 공장에서는 운송비를 줄이기 위해 최소한의 횟수로 밀가루를 공급받고 싶습니다.
 *
 * 현재 공장에 남아있는 밀가루 수량 stock,
 * 밀가루 공급 일정(dates)과
 * 해당 시점에 공급 가능한 밀가루 수량(supplies),
 * 원래 공장으로부터 공급받을 수 있는 시점 k가 주어질 때,
 *
 * 밀가루가 떨어지지 않고 공장을 운영하기 위해서 [최소한 몇 번] 해외 공장으로부터 밀가루를 공급받아야 하는지를 return 하도록 solution 함수를 완성하세요.
 *
 * dates[i]에는 i번째 공급 가능일이 들어있으며, supplies[i]에는 dates[i] 날짜에 공급 가능한 밀가루 수량이 들어 있습니다.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 *
 * stock에 있는 밀가루는 오늘(0일 이후)부터 사용됩니다.
 * stock과 k는 2 이상 100,000 이하입니다.
 * dates의 각 원소는 1 이상 k 이하입니다.
 * supplies의 각 원소는 1 이상 1,000 이하입니다.
 * dates와 supplies의 길이는 1 이상 20,000 이하입니다.
 * k일 째에는 밀가루가 충분히 공급되기 때문에 k-1일에 사용할 수량까지만 확보하면 됩니다.
 * dates에 들어있는 날짜는 오름차순 정렬되어 있습니다.
 * dates에 들어있는 날짜에 공급되는 밀가루는 작업 시작 전 새벽에 공급되는 것을 기준으로 합니다.
 *
 * 예를 들어 9일째에 밀가루가 바닥나더라도, 10일째에 공급받으면 10일째에는 공장을 운영할 수 있습니다.
 * 밀가루가 바닥나는 경우는 주어지지 않습니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * stock,	dates,	supplies,	k,	result
 * 4,	[4,10,15],	[20,5,10],	30,	2
 *
 * 4일째 : 0톤 + 20톤
 * 10일째 : 14톤
 * 15일째 : 9톤 + 10톤 ( 24 - 15 = 9 )
 * 30일째 : 4톤 ( 19 - 15 = 4 )
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 현재 밀가루가 4톤 남아 있기 때문에 오늘과 1일 후~3일 후까지 사용하고 나면 모든 밀가루를 다 사용합니다. 따라서 4일 후에는 반드시 밀가루를 공급받아야 합니다.
 * 4일째 공급받고 나면 15일 이후 아침에는 9톤의 밀가루가 남아있게 되고, 이때 10톤을 더 공급받으면 19톤이 남아있게 됩니다. 15일 이후부터 29일 이후까지 필요한 밀가루는 15톤이므로 더 이상의 공급은 필요 없습니다.
 * 따라서 총 2회의 밀가루를 공급받으면 됩니다.
 *
 *
 *
 */
public class HEAP002_X {

    public static void main(String[] args) {

        int stock = 4;
        int[] dates = new int[]{4,10,15};
        int[] supplies = new int[]{20,5,10};
        int k = 30;

        Solution solution = new Solution();
        int result = solution.solution(stock, dates, supplies, k);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int stock, int[] dates, int[] supplies, int k) {

            int answer = 0;
            int limit = stock;
            int index = 0;

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 큰 수부터 큐에 넣도록 정렬 역순

            while(limit < k) { // 30일까지 반복

                // 반복을 date 수와 날짜가 limit 보다 큰 경우
                while(index < dates.length && dates[index] <= limit) {
                    pq.add(supplies[index]);
                    index++;
                }

                System.out.println("index : "+index);
                System.out.println("pq : "+pq);
                System.out.println("----------------");

                int max = pq.poll();
                limit += max;
                answer++;
                if(index < dates.length && limit < dates[index]) {
                    while(!pq.isEmpty() && limit < dates[index]) {
                        max = pq.poll();
                        limit += max;
                        answer++;
                    }
                }
            }

            return answer;
        }
    }

    public static class Solution1 {
        public int solution(int stock, int[] dates, int[] supplies, int k) {

            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            int idx =0;
            int temp = stock;
            while(true){
                k-=temp;
                if(k<1)break;
                while(idx<dates.length&&dates[idx]<=stock){
                    pq.add(supplies[idx++]);
                }
                if(pq.size()!=0){
                    temp= pq.remove();
                    stock +=temp;
                    ++answer;
                }
                else {
                    answer = -1;
                    break;
                }
            }

            return answer;
        }
    }

    public static class Solution2 {

        public int solution(int stock, int[] dates, int[] supplies, int k) {
            int s = 0, ans = 0;
            Queue<Integer> pq = new PriorityQueue<>();

            while (stock < k) {
                for (int i=s; i<dates.length; i++) {
                    if (dates[i] <= stock) pq.add(-supplies[i]);
                    else {s = i; break;}
                }

                ans++;
                stock -= pq.poll();
            }

            return ans;
        }
    }


}
