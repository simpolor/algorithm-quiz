package io.simpolor.quiz.programmers.level01;

import java.util.*;

public class Q028_V {

    /***
     * [카카오 인턴] 키패드 누르기
     *
     * ------------------------------
     * 문제 설명
     * ------------------------------
     * 스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.
     *
     * -----------
     * | 1  2  3 |
     * | 4  5  6 |
     * | 7  8  9 |
     * | *  0  # |
     * |  [통화]  |
     * -----------
     * [ kakao_phone1.png ]
     *
     * 이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
     * 맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
     *
     * 1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
     * 2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
     * 3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
     * 4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
     * 4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
     * 순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
     * 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
     *
     * ------------------------------
     * [제한사항]
     * ------------------------------
     * numbers 배열의 크기는 1 이상 1,000 이하입니다.
     * numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
     * hand는 "left" 또는 "right" 입니다.
     * "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
     * 왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
     *
     * ------------------------------
     * 입출력 예
     * ------------------------------
     * numbers	hand	result
     * [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
     * [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
     *
     * ------------------------------
     * 입출력 예에 대한 설명
     * ------------------------------
     * 입출력 예 #1
     *
     * 순서대로 눌러야 할 번호가 [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]이고, 오른손잡이입니다.
     *
     * 왼손 위치	오른손 위치	눌러야 할 숫자	사용한 손	설명
     * *	#	1	L	1은 왼손으로 누릅니다.
     * 1	#	3	R	3은 오른손으로 누릅니다.
     * 1	3	4	L	4는 왼손으로 누릅니다.
     * 4	3	5	L	왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다.
     * 5	3	8	L	왼손 거리는 1, 오른손 거리는 3이므로 왼손으로 8을 누릅니다.
     * 8	3	2	R	왼손 거리는 2, 오른손 거리는 1이므로 오른손으로 2를 누릅니다.
     * 8	2	1	L	1은 왼손으로 누릅니다.
     * 1	2	4	L	4는 왼손으로 누릅니다.
     * 4	2	5	R	왼손 거리와 오른손 거리가 1로 같으므로, 오른손으로 5를 누릅니다.
     * 4	5	9	R	9는 오른손으로 누릅니다.
     * 4	9	5	L	왼손 거리는 1, 오른손 거리는 2이므로 왼손으로 5를 누릅니다.
     * 5	9	-	-
     * 따라서 "LRLLLRLLRRL"를 return 합니다.
     *
     * 입출력 예 #2
     *
     * 왼손잡이가 [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]를 순서대로 누르면 사용한 손은 "LRLLRRLLLRR"이 됩니다.
     *
     * 입출력 예 #3
     *
     * 오른손잡이가 [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]를 순서대로 누르면 사용한 손은 "LLRLLRLLRL"이 됩니다.
     *
     */
    public static void main(String[] args){

        int[] numbers = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "right";

        Solution solution = new Solution();
        String result = solution.solution(numbers, hand);

        System.out.println(result);
    }

    public static class Solution {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            int left_x, left_y;
            int right_x, right_y;
            left_x = 0;
            left_y = 3;
            right_x = 2;
            right_y = 3;

            for(int i = 0; i<numbers.length; i++){
                if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                    answer += "L";
                    left_x = (numbers[i]-1)%3;
                    left_y = (numbers[i]-1)/3;
                }
                else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                    answer += "R";
                    right_x = (numbers[i]-1)%3;
                    right_y = (numbers[i]-1)/3;
                }
                else {
                    if(numbers[i] == 0){
                        if(Math.abs(1-left_x) + 3 - left_y > Math.abs(1-right_x) + 3 - right_y){
                            right_x = 1;
                            right_y = 3;
                            answer += "R";
                        }
                        else if(Math.abs(1-left_x) + 3 - left_y < Math.abs(1-right_x) + 3 - right_y){
                            left_x = 1;
                            left_y = 3;
                            answer += "L";
                        }
                        else {
                            if(hand.equals("right")){
                                right_x = 1;
                                right_y = 3;
                                answer += "R";
                            }
                            else {
                                left_x = 1;
                                left_y = 3;
                                answer += "L";
                            }
                        }
                    }
                    else {
                        if(Math.abs((numbers[i]-1)%3-left_x) + Math.abs((numbers[i]-1)/3 - left_y) > Math.abs((numbers[i]-1)%3-right_x) + Math.abs((numbers[i]-1)/3 - right_y)){
                            right_x = (numbers[i]-1)%3;
                            right_y = (numbers[i]-1)/3;
                            answer += "R";
                        }
                        else if(Math.abs((numbers[i]-1)%3-left_x) + Math.abs((numbers[i]-1)/3 - left_y) < Math.abs((numbers[i]-1)%3-right_x) + Math.abs((numbers[i]-1)/3 - right_y)){
                            left_x = (numbers[i]-1)%3;
                            left_y = (numbers[i]-1)/3;
                            answer += "L";
                        }
                        else {
                            if(hand.equals("right")){
                                right_x = (numbers[i]-1)%3;
                                right_y = (numbers[i]-1)/3;
                                answer += "R";
                            }
                            else {
                                left_x = (numbers[i]-1)%3;
                                left_y = (numbers[i]-1)/3;
                                answer += "L";
                            }
                        }
                    }
                }
            }
            return answer;
        }
    }

    public static class Solution1 {
        int tempL = 10;
        int tempR = 12;
        String myhand;
        public String solution(int[] numbers, String hand) {
            myhand = ((hand.equals("right"))? "R": "L");
            String answer = "";
            for(int i=0 ; i< numbers.length ; i++) {
                switch(numbers[i]) {
                    case 1: case 4: case 7:
                        answer += "L";
                        tempL = numbers[i];
                        break;
                    case 3: case 6: case 9:
                        answer += "R";
                        tempR = numbers[i];
                        break;
                    default:
                        String tempHand = checkHand(numbers[i]);
                        if(tempHand.equals("R"))
                            tempR = numbers[i] + ((numbers[i] == 0)? 11:0);
                        else tempL = numbers[i] + ((numbers[i] == 0)? 11:0);
                        answer += tempHand;
                        break;
                }
            }
            return answer;
        }

        private String checkHand(int tempNum) {
            int leftDistance = 0;
            int rightDistance = 0;
            if(tempNum == 0) tempNum = 11;

            leftDistance = Math.abs((tempNum-1)/3 - (tempL-1)/3) + Math.abs((tempNum-1)%3 - (tempL-1)%3);
            rightDistance = Math.abs((tempNum-1)/3 - (tempR-1)/3) + Math.abs((tempNum-1)%3 - (tempR-1)%3);
            System.out.println(tempNum + ": " + leftDistance + ", " + rightDistance);
            return ((leftDistance == rightDistance)? myhand: (leftDistance > rightDistance)? "R": "L");

        }
    }

    public static class Solution2 {
        private static final String LEFT = "L";
        private static final String RIGHT = "R";
        private static final int[][] KEYPAD = new int[][] {
                {3, 1}, {0, 0}, {0, 1}, {0, 2}
                , {1, 0}, {1, 1}, {1, 2}
                , {2, 0}, {2, 1}, {2, 2}
        };

        public String solution(int[] numbers, String hand) {
            int[] leftXY = {3,0};
            int[] rightXY = {3,2};

            StringBuilder sb = new StringBuilder();
            for (int i : numbers) {
                switch (i) {
                    case 1:
                    case 4:
                    case 7:
                        leftXY = KEYPAD[i];
                        sb.append(LEFT);
                        break;
                    case 3:
                    case 6:
                    case 9:
                        rightXY = KEYPAD[i];
                        sb.append(RIGHT);
                        break;
                    case 2 :
                    case 5:
                    case 8:
                    case 0:
                        String finger = getSuitablefinger(leftXY, rightXY, i, hand);
                        sb.append(finger);

                        if (finger.equalsIgnoreCase(LEFT)) {
                            leftXY = KEYPAD[i];
                        } else {
                            rightXY = KEYPAD[i];
                        }

                        break;
                }
            }

            return sb.toString();
        }

        private int getDifference(int[] xy, int[] keypad) {
            return Math.abs(xy[0] - keypad[0]) + Math.abs(xy[1] - keypad[1]);
        }

        private String getSuitablefinger(int[] leftXY, int[] rightXY, int number, String hand) {
            int leftDifference = getDifference(leftXY, KEYPAD[number]);
            int rightDifference = getDifference(rightXY, KEYPAD[number]);

            String finger;
            if (leftDifference > rightDifference) {
                finger = RIGHT;
            } else if (leftDifference < rightDifference) {
                finger = LEFT;
            } else {
                finger = ("right".equals(hand) ? RIGHT : LEFT);
            }

            return finger;
        }
    }

    public static class Solution3 {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            int[] right = {3,2}, left = {3,0};
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] % 3 == 0){
                    if(numbers[i] == 0){
                        if(mid(left[0], left[1],right[0],right[1],numbers[i],hand).equals("right")){
                            answer += "R";
                            right[0] = 3;
                            right[1] = 1;
                        }else{
                            answer += "L";
                            left[0] = 3;
                            left[1] = 1;
                        }
                    }else{
                        answer += "R";
                        right[0] = numbers[i]/3 - 1;
                        right[1] = 2;
                    }
                }else if(numbers[i] % 3 == 1){
                    answer += "L";
                    left[0] = numbers[i]/3;
                    left[1] = 0;
                }else{
                    if(mid(left[0], left[1],right[0],right[1],numbers[i],hand).equals("right")){
                        answer += "R";
                        right[0] = numbers[i]/3;
                        right[1] = 1;
                    }else{
                        answer += "L";
                        left[0] = numbers[i]/3;
                        left[1] = 1;
                    }
                }
            }
            return answer;
        }
        public String mid(int lx, int ly, int rx, int ry, int num, String hand){
            int numX = 0, l = 0, r = 0;
            if(num == 0) numX=3;
            else numX = num/3;
            l = Math.abs(numX-lx) + Math.abs(ly - 1);
            r = Math.abs(numX-rx) + Math.abs(ry - 1);
            if(l == r) return hand;
            else if(l > r) return "right";
            else return "left";
        }
    }

    public static class Solution4 {
        public String solution(int[] numbers, String hand) {
            HashMap<Integer, int[]> side = new HashMap<Integer, int []>();
            HashMap<Integer, int[]> center = new HashMap<Integer, int []>();

            center.put(0, new int []{3,1});
            for(int i = 0, j = 1, k = 0; i < 3; i++, j+=3)
            {
                side.put(j, new int [] {i, k});
                center.put(j+1, new int[] {i, k+1});
                side.put(j+2, new int[] {i, k+2});
            }

            int leftRow = 3;
            int leftCol = 0;

            int rightRow = 3;
            int rightCol = 2;
            int rightTemp, leftTemp;
            StringBuilder sb = new StringBuilder();
            int [] temp;
            for(int i = 0; i < numbers.length; i++)
            {
                if(center.containsKey(numbers[i]))
                {
                    temp = center.get(numbers[i]);
                    rightTemp = Math.abs(temp[0]-rightRow)+Math.abs(temp[1]-rightCol);
                    leftTemp = Math.abs(temp[0]-leftRow)+Math.abs(temp[1]-leftCol);
                    if(rightTemp == leftTemp)
                    {
                        if(hand.equals("right"))
                        {
                            sb.append("R");
                            rightRow = temp[0];
                            rightCol = temp[1];
                        }
                        else
                        {
                            sb.append("L");
                            leftRow = temp[0];
                            leftCol = temp[1];
                        }
                    }
                    else if(rightTemp < leftTemp)
                    {
                        sb.append("R");
                        rightRow = temp[0];
                        rightCol = temp[1];
                    }
                    else
                    {
                        sb.append("L");
                        leftRow = temp[0];
                        leftCol = temp[1];
                    }
                }
                else
                {
                    if(numbers[i]%3 == 0)
                    {
                        sb.append("R");
                        temp = side.get(numbers[i]);
                        rightRow = temp[0];
                        rightCol = temp[1];
                    }
                    else
                    {
                        sb.append("L");
                        temp = side.get(numbers[i]);
                        leftRow = temp[0];
                        leftCol = temp[1];
                    }
                }
            }
            return sb.toString();
        }
    }

    public static class Solution5 {
        public static String solution(int[] numbers, String hand) {
            StringBuilder sb = new StringBuilder();

            // 각 손의 초기 위치
            pair leftH = cal("*");
            pair rightH = cal("#");

            for(int i : numbers) {
                // 왼손
                if(i == 1 || i == 4 || i == 7) {
                    sb.append("L");
                    leftH = cal(String.valueOf(i));
                }
                // 오른손
                else if(i == 3 || i == 6 || i == 9) {
                    sb.append("R");
                    rightH = cal(String.valueOf(i));
                }
                else {
                    pair num = cal(String.valueOf(i));
                    int rightDis = Math.abs(num.x - rightH.x) + Math.abs(num.y - rightH.y);
                    int leftDis = Math.abs(num.x - leftH.x) + Math.abs(num.y - leftH.y);

                    if(rightDis < leftDis || (leftDis == rightDis && hand.equals("right"))) {
                        sb.append("R");
                        rightH = num;
                    }
                    else if(leftDis < rightDis || (leftDis == rightDis && hand.equals("left"))) {
                        sb.append("L");
                        leftH = num;
                    }
                }
            }
            return sb.toString();
        }
        static pair cal(String num) {
            if(num.equals("0")) return new pair(3, 1);
            else if(num.equals("1")) return new pair(0, 0);
            else if(num.equals("2")) return new pair(0, 1);
            else if(num.equals("3")) return new pair(0, 2);
            else if(num.equals("4")) return new pair(1, 0);
            else if(num.equals("5")) return new pair(1, 1);
            else if(num.equals("6")) return new pair(1, 2);
            else if(num.equals("7")) return new pair(2, 0);
            else if(num.equals("8")) return new pair(2, 1);
            else if(num.equals("9")) return new pair(2, 2);
            else if(num.equals("*")) return new pair(3, 0);
            else return new pair(3,2);
        }
        static class pair {
            int x, y;

            pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }

    public static class Solution6 {
        public String solution(int[] numbers, String hand) {
            String answer = "";
            StringBuilder sb = new StringBuilder();

            List<Integer> left = Arrays.asList(1, 4, 7);
            List<Integer> mid = Arrays.asList(2, 5, 8, 0);
            List<Integer> right = Arrays.asList(3, 6, 9);
            int left_hand = 3;
            int right_hand = 3;
            int mid_hand = 4;
            String left_string = "L";
            String Right_stirng = "R";

            for (int i = 0; i < numbers.length; i++) {

                if (left.contains(numbers[i])) {
                    left_hand = left.indexOf(numbers[i]);
                    left_string = "L";
                    // answer = answer + "L";
                    sb.append("L");
                    // System.out.println(i + " numbers[i],left_hand,mid_hand,right_hand,answer => "
                    // +numbers[i]+","+left_hand+","+mid_hand+","+right_hand+","+answer);
                    //continue;
                } else if (right.contains(numbers[i])) {
                    right_hand = right.indexOf(numbers[i]);
                    Right_stirng = "R";
                    // answer = answer + "R";
                    sb.append("R");
                    // System.out.println(i + " numbers[i],left_hand,mid_hand,right_hand,answer => "
                    // +numbers[i]+","+left_hand+","+mid_hand+","+right_hand+","+answer);
                    //continue;
                } else {
                    mid_hand = mid.indexOf(numbers[i]);
                    int left_dist = Math.abs(mid_hand - left_hand);
                    int right_dist = Math.abs(mid_hand - right_hand);

                    // 왼쪽이나 오른쪽에서 중간으로 갔을때를 별도로 계산 하지 않아서 일부가 오류가 발생함
                    // 중간으로 간 경우를 별도로 계산 함
                    if (left_string.equals("M")) {
                        left_dist = left_dist -1;
                    }
                    if (Right_stirng.equals("M")) {
                        right_dist = right_dist -1;
                    }
                    // System.out.println(i + " numbers[i],left_dist,right_dist =>
                    // "+numbers[i]+","+left_dist+","+right_dist);
                    if (left_dist < right_dist) {
                        left_hand = mid.indexOf(numbers[i]);
                        // answer = answer + "L";
                        sb.append("L");
                        left_string = "M";
                    } else if (left_dist > right_dist) {
                        right_hand = mid.indexOf(numbers[i]);
                        // answer = answer + "R";
                        sb.append("R");
                        Right_stirng = "M";
                    } else {
                        if (hand.equals("left")) {
                            left_hand = mid.indexOf(numbers[i]);
                            // answer = answer + "L";
                            sb.append("L");
                            left_string = "M";
                        } else {   //else if (hand == "right") {
                            right_hand = mid.indexOf(numbers[i]);
                            // answer = answer + "R";
                            sb.append("R");
                            Right_stirng = "M";
                        }
                    }
                    System.out.println(sb.toString());
                }

            }
            //System.out.println(sb.toString());
            answer = sb.toString();
            //answer = "LRLLLRLLRRL";
//      if (answer.equals(sb.toString())) {
//          System.out.println(sb.toString());
//          System.out.println(answer);
//      }

            return answer;
        }
    }




}
