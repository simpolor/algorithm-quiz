package io.simpolor.quiz.programmers.condingTestPractice.stackAndQueue02;

import java.util.*;

/***
 * 다리를 지나는 트럭
 *
 * ------------------------------
 * 문제 설명
 *------------------------------
 * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
 * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
 *
 * 예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 *
 * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
 * 0	[]	[]	[7,4,5,6]
 * 1~2	[]	[7]	[4,5,6]
 * 3	[7]	[4]	[5,6]
 * 4	[7]	[4,5]	[6]
 * 5	[7,4]	[5]	[6]
 * 6~7	[7,4,5]	[6]	[]
 * 8	[7,4,5,6]	[]	[]
 * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
 *
 * solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 *
 *------------------------------
 * 제한 조건
 *------------------------------
 * bridge_length는 1 이상 10,000 이하입니다.
 * weight는 1 이상 10,000 이하입니다.
 * truck_weights의 길이는 1 이상 10,000 이하입니다.
 * 모든 트럭의 무게는 1 이상 weight 이하입니다.
 *
 *------------------------------
 * 입출력 예
 * ------------------------------
 * bridge_length	weight	truck_weights	return
 * 2	10	[7,4,5,6]	8
 * 100	100	[10]	101
 * 100	100	[10,10,10,10,10,10,10,10,10,10]	110
 */
public class STACTANDQUEUE002 {

    public static void main(String[] args) {

        int bridgeLength = 2;
        int weight = 10;
        int[] truckWeight = new int[]{7,4,5,6};

        Solution solution = new Solution();
        int result = solution.solution(bridgeLength, weight, truckWeight);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int bridgeLength, int weight, int[] truckWeights) {

            Stack<Integer> truckStack = new Stack<>();
            Map<Integer, Integer> bridgeMap = new HashMap<>();

            for (int i = truckWeights.length-1; i >= 0; i--)
                truckStack.push(truckWeights[i]);

            int answer = 0;
            int sum = 0;
            while(true) {
                answer++;

                if (bridgeMap.containsKey(answer))
                    bridgeMap.remove(answer);

                sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();

                if (!truckStack.isEmpty())
                    if (sum + truckStack.peek() <= weight)
                        bridgeMap.put(answer + bridgeLength, truckStack.pop());

                if (bridgeMap.isEmpty() && truckStack.isEmpty())
                    break;


            }
            return answer;
        }
    }

    public static class Solution1 {
        class Truck {
            int weight;
            int move;

            public Truck(int weight) {
                this.weight = weight;
                this.move = 1;
            }

            public void moving() {
                move++;
            }
        }

        public int solution(int bridgeLength, int weight, int[] truckWeights) {
            Queue<Truck> waitQ = new LinkedList<>();
            Queue<Truck> moveQ = new LinkedList<>();

            for (int t : truckWeights) {
                waitQ.offer(new Truck(t));
            }

            int answer = 0;
            int curWeight = 0;

            while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
                answer++;

                if (moveQ.isEmpty()) {
                    Truck t = waitQ.poll();
                    curWeight += t.weight;
                    moveQ.offer(t);
                    continue;
                }

                for (Truck t : moveQ) {
                    t.moving();
                }

                if (moveQ.peek().move > bridgeLength) {
                    Truck t = moveQ.poll();
                    curWeight -= t.weight;
                }

                if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                    Truck t = waitQ.poll();
                    curWeight += t.weight;
                    moveQ.offer(t);
                }
            }

            return answer;
        }
    }

    public static class Solution2 {

        public int solution(int bridge_length, int weight, int[] truck_weights) {

            Queue<Integer> queue = new LinkedList<>();

            int count = 0;
            int time = 0;

            for(int i = 0; i < bridge_length; i++) {
                queue.add(0);
            }

            int temp;
            int ind = 0;
            while(true) {
                time++;
                temp = queue.poll();
                if(temp != 0) count++;
                if(count == truck_weights.length) {
                    return time;
                } else if(ind<truck_weights.length) {
                    if(Weight(queue) + truck_weights[ind] > weight) {
                        queue.add(0);
                    } else {
                        queue.add(truck_weights[ind]);
                        ind++;
                    }
                }

            }
        }

        private int Weight(Queue<Integer> queue) {
            int sum = 0;
            for(Integer i : queue) {
                sum = sum + i;
            }
            return sum;
        }
    }

    public static class Solution3 {

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int count = 0;
            int n = truck_weights.length;
            int i = 0;
            int sum = 0;
            int[] time = new int[n];
            Arrays.fill(time, bridge_length);
            Queue<Integer> q = new LinkedList<Integer>();
            while(count < n){
                answer++;
                int size = q.size();
                for(int m = 0; m < size; m++){
                    int temp = q.poll();
                    time[temp] -= 1;
                    if(time[temp] > 0)
                        q.add(temp);
                    else{
                        count++;
                        sum -= truck_weights[temp];
                    }
                }
                if(i<n){
                    if(truck_weights[i] + sum <= weight){
                        q.add(i);
                        sum += truck_weights[i];
                        i++;
                    }
                }
            }
            return answer;
        }
    }

    public static class Solution4 {

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int sum = 0, i = 0;
            Queue<Integer> q = new LinkedList<>();
            for (int j = 0; j < bridge_length; j++) {
                q.offer(0);
            }
            while (!q.isEmpty()) {
                int popped = q.poll();
                sum -= popped;
                if (i < truck_weights.length) {
                    if (sum + truck_weights[i] <= weight) {
                        q.offer(truck_weights[i]);
                        sum += truck_weights[i];
                        i++;
                    } else {
                        q.offer(0);
                    }
                }
                answer++;
            }
            return answer;
        }
    }

    public static class Solution5 {

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Integer> trucks = new LinkedList<>();
            Queue<Integer> waitingQ = new LinkedList<>();
            Queue<Integer> countQ = new LinkedList<>();

            int curruntWeight = 0;
            int count = 0;

            for(int i = 0; i < truck_weights.length; i++){
                trucks.add(truck_weights[i]);
            }


            while(!trucks.isEmpty()){

                if(waitingQ.size() <= bridge_length && curruntWeight + trucks.peek() <= weight){
                    curruntWeight += trucks.peek();
                    waitingQ.add(trucks.poll());
                    countQ.add(0);
                }

                int cycle = countQ.size();

                for(int c = 0; c < cycle; c++)
                    countQ.add(countQ.poll()+1);

                if(countQ.peek() == bridge_length){
                    countQ.poll();
                    curruntWeight -= waitingQ.poll();
                }

                count++;
            }

            if (!countQ.isEmpty()){
                int before = countQ.poll();
                count += bridge_length - before + 1;

                while(!countQ.isEmpty()){
                    int tmp = before - countQ.peek();
                    count += tmp;
                    before = countQ.poll();
                }
            }

            return count;
        }
    }

    public static class Solution6 {

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int size = truck_weights.length, idx = 0;
            int current = 0;
            Queue<Integer> bridge = new LinkedList<>();

            do {
                if (bridge.size() == bridge_length)
                    current -= bridge.poll();
                if (idx < size && current + truck_weights[idx] <= weight) {
                    bridge.add(truck_weights[idx]);
                    current += truck_weights[idx++];
                }
                else
                    bridge.add(0);
                answer++;
            }while(current != 0);

            return answer;
        }
    }

}
