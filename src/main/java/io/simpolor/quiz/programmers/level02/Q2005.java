package io.simpolor.quiz.programmers.level02;

import java.util.*;

/***
 * 다리를 지나는 트럭
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
 * 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
 * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
 *
 * 예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다.
 * 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
 *
 * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
 * 0	[]	[]	[7,4,5,6]
 * 1~2	[]	[7]	[4,5,6]
 * 3	[7]	[4]	[5,6]
 * 4	[7]	[4,5]	[6]
 * 5	[7,4]	[5]	[6]
 * 6~7	[7,4,5]	[6]	[]
 * 8	[7,4,5,6]	[]	[]
 *
 * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
 *
 * solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다.
 * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 *
 * ------------------------------
 * 제한 조건
 * ------------------------------
 * bridge_length는 1 이상 10,000 이하입니다.
 * weight는 1 이상 10,000 이하입니다.
 * truck_weights의 길이는 1 이상 10,000 이하입니다.
 * 모든 트럭의 무게는 1 이상 weight 이하입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * bridge_length	weight	truck_weights	return
 * 2	10	[7,4,5,6]	8
 * 100	100	[10]	101
 * 100	100	[10,10,10,10,10,10,10,10,10,10]	110
 * 출처
 *
 * ※ 공지 - 2020년 4월 06일 테스트케이스가 추가되었습니다.
 *
 */
public class Q2005 {

    public static void main(String[] args){

        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = new int[]{7,4,5,6};

        /*int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = new int[]{10};*/

        /*int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = new int[]{10,10,10,10,10,10,10,10,10,10};*/

        Solution solution = new Solution();
        int result = solution.solution(bridge_length, weight, truck_weights);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int bridgeLength, int weight, int[] truckWeights) {

            // 트럭을 큐를 넣는다.
            Queue<Truck> moveQueue = new LinkedList<>();
            Queue<Truck> waitQueue = new LinkedList<>();
            for(int truck : truckWeights){
                waitQueue.add(new Truck(truck));
            }

            // 큐가 빌때까지 반복
            int second = 0;
            int sum = 0;
            while(!waitQueue.isEmpty() || !moveQueue.isEmpty() ){
                second++;

                // moveQueue 가 비어있을 경우, waitQueue 의 첫번째 개체를 가지고 다리 위에 넣음
                if(moveQueue.isEmpty()){
                    Truck truck = waitQueue.poll();
                    sum += truck.weight;
                    moveQueue.add(truck);
                    continue;
                }

                // moveQueue 에 대기중인 큐를 한칸씩 앞으로 이동
                for (Truck truck : moveQueue) {
                    truck.move();
                }

                // 큐의 첫번째 들어온 값의 길이와 다리길이를 비교하여 제거 및 sum에 값 감소
                if (moveQueue.peek().index > bridgeLength) {
                    Truck truck = moveQueue.poll();
                    sum -= truck.weight;
                }

                // waitQueue 가 비어있지 않고 sum과 waitQueue 첫번째 값의 무게가 weight 보다 작을 경우 moveQueue 로 이동
                if (!waitQueue.isEmpty() && (sum + waitQueue.peek().weight) <= weight) {
                    Truck truck = waitQueue.poll();
                    sum += truck.weight;
                    moveQueue.add(truck);
                }
            }

            return second;
        }

        class Truck{
            int weight;
            int index;

            Truck(int weight){
                this.weight = weight;
                this.index = 1;
            }

            public void move(){
                index++;
            }
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
            Stack<Integer> truckStack = new Stack<>();
            Map<Integer, Integer> bridgeMap = new HashMap<>();

            for (int i = truck_weights.length-1; i >= 0; i--)
                truckStack.push(truck_weights[i]);

            int answer = 0;
            int sum = 0;
            while(true) {
                answer++;

                if (bridgeMap.containsKey(answer))
                    bridgeMap.remove(answer);

                sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();

                if (!truckStack.isEmpty())
                    if (sum + truckStack.peek() <= weight)
                        bridgeMap.put(answer + bridge_length, truckStack.pop());

                if (bridgeMap.isEmpty() && truckStack.isEmpty())
                    break;


            }
            return answer;
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
            int answer = 0;
            ArrayList<Integer> passed = new ArrayList<Integer>();
            ArrayList<Integer> pass = new ArrayList<Integer>();
            int tr = 0;
            int w = 0;
            ArrayList<Integer> p = new ArrayList<Integer>();
            while(passed.size() != truck_weights.length){
                answer++;

                if(!p.isEmpty()){
                    if(p.get(0) == answer){
                        passed.add(pass.get(0));
                        pass.remove(0);
                        p.remove(0);
                        int tmp = 0;
                        for(int i = 0; i < pass.size(); i++){  //weight 계산

                            tmp += pass.get(i);

                        }
                        w = tmp;

                    }
                }
                if(pass.size() == 0){
                    w = 0;
                }

                if(tr < truck_weights.length){  //pass에 넣음
                    if(w + truck_weights[tr] <= weight){
                        pass.add(truck_weights[tr]);
                        p.add(answer + bridge_length);
                        w = w + truck_weights[tr];
                        tr++;

                    }
                }
            }

            return answer;
        }
    }

    public static class Solution6 {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Integer> q = new LinkedList<>();
            int sum = 0;

            for(int i = 0; i < truck_weights.length; i++) {
                int curTruck = truck_weights[i];
                while(true) {
                    answer++;
                    if(q.isEmpty()){
                        q.add(curTruck);
                        sum+=curTruck;
                        break;
                    }
                    else if(q.size() == bridge_length) {
                        sum -= q.poll();
                        answer--;
                    }
                    else {
                        if(sum + curTruck > weight) {
                            q.add(0);
                        }
                        else {
                            sum += curTruck;
                            q.add(curTruck);
                            break;
                        }
                    }
                }
            }
            answer += bridge_length;
            return answer;
        }
    }


    public static class Solution7 {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int time = 0;
            int maxWeight = 0;
            Queue<Integer> birdge = new ArrayDeque<Integer>();

            for(int truck : truck_weights) {
                while(true) {
                    if(birdge.peek() == null) {
                        birdge.offer(truck);
                        maxWeight = truck;
                        time++;
                        break;
                    } else if(birdge.size() == bridge_length) {
                        maxWeight -= birdge.poll();
                    } else{
                        if(weight >= (maxWeight + truck)) {
                            birdge.offer(truck);
                            maxWeight += truck;
                            time++;
                            break;
                        } else {
                            birdge.offer(0);
                            time++;
                        }
                    }
                }
            }

            answer = time + bridge_length;

            return answer;
        }
    }

    public static class Solution8 {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int time = 0;
            int weightsum = 0;

            Queue<Integer> q = new LinkedList<>();

            for(int i=0; i<truck_weights.length; i++) {
                while(true) {
                    if(q.isEmpty()) {
                        q.add(truck_weights[i]);
                        weightsum += truck_weights[i];
                        time++;
                        break;
                    } else if(q.size() == bridge_length){
                        weightsum -= q.poll();
                    } else {
                        if(weightsum + truck_weights[i] > weight) {
                            q.add(0);
                            time++;
                        } else {
                            q.add(truck_weights[i]);
                            weightsum += truck_weights[i];
                            time++;
                            break;
                        }
                    }
                }
            }
            return time + bridge_length;
        }
    }

    public static class Solution9 {
        class Truck{
            int weight;
            int entry;

            Truck(int weight, int entry){
                this.weight = weight;
                this.entry = entry;
            }
        }

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Truck> waiting = new LinkedList<>();
            Queue<Truck> bridge = new LinkedList<>();
            int answer = 0;

            for(int i: truck_weights) {
                waiting.offer(new Truck(i,0));
            }


            int totalWeight = 0;

            while(!waiting.isEmpty() || !bridge.isEmpty()) {
                answer++;

                if(!bridge.isEmpty()) {
                    Truck t = bridge.peek();
                    if(answer - t.entry >= bridge_length) {
                        totalWeight -= t.weight;
                        bridge.poll();
                    }
                }

                if(!waiting.isEmpty()) {
                    if(totalWeight + waiting.peek().weight <= weight) {
                        Truck t = waiting.poll();
                        totalWeight += t.weight;

                        bridge.offer(new Truck(t.weight,answer));
                    }
                }
            }
            return answer;
        }
    }

    public static class Solution10 {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            List<Integer> truckDone = new ArrayList<>();
            List<Truck> truckPass = new ArrayList<>();
            for (int i = 0; i < truck_weights.length; i++) {
                truckPass.add(new Truck(i, 0, truck_weights[i]));
            }

            int weightSum = 0;
            while (truckDone.size() < truck_weights.length) {
                answer++;
                truckPass.removeIf(t -> t.done);
                for (int i = 0; i < truckPass.size(); i++) {
                    if (truckPass.get(i).curr_position > 0){
                        truckPass.get(i).curr_position++;
                        if (truckPass.get(i).curr_position > bridge_length) {
                            weightSum -= truckPass.get(i).weights;
                            truckDone.add(truckPass.get(i).id);
                            truckPass.get(i).done = true;
                        }
                    } else if (truckPass.get(i).curr_position == 0 && ((weightSum + truckPass.get(i).weights <= weight) || weightSum == 0)) {
                        truckPass.get(i).curr_position++;
                        weightSum += truckPass.get(i).weights;
                        break;
                    } else {
                        break;
                    }
                }
            }
            return answer;
        }

        class Truck {
            public int id;
            public int curr_position;
            public int weights;
            public boolean done;
            public Truck(int id, int curr_position, int weights){
                this.id = id;
                this.curr_position = curr_position;
                this.weights = weights;
                this.done = false;
            }
        }
    }

    public static class Solution11 {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<Integer> q = new LinkedList<Integer>(); //다리
            int cnt = 0; //다리 위 트럭의 무게

            for(int i:truck_weights){
                while(true){
                    if(q.isEmpty()) { //다리 위에 트럭이 하나도 없을 때
                        q.add(i);
                        cnt+=i;
                        break;
                    } else if(q.size() == bridge_length) { //다리 위트럭이 간 거리와 다리 길이가 같을 때
                        //q.poll(); //다리 큐에서 트럭 제거
                        cnt -= q.poll(); //다리 위 트럭 무게에서 트럭 무게 제거
                    }else{
                        if(cnt+i > weight){  //다리 위의 트럭 무게와 뒤에 들어올 트럭 무게의 합이 최대 무게를 넘는지 비교
                            answer++;
                            q.add(0); //넘으면 다리에 트럭 넣지 않음.
                        }else {
                            q.add(i);
                            cnt+=i;
                            answer++;
                            break;
                        }
                    }
                }
            }
            //System.out.println(answer+bridge_length);
            return answer+bridge_length+1;
        }
    }



}
