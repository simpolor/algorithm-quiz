package io.simpolor.quiz.programmers.level02;

import java.util.Arrays;
import java.util.Stack;

/***
 * 주식가격
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
 * prices의 길이는 2 이상 100,000 이하입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * prices	return
 * [1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
 * 2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
 * 3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
 * 4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
 * 5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.
 *
 * ※ 공지 - 2019년 2월 28일 지문이 리뉴얼되었습니다.
 *
 * ------------------------------
 * 조건 설명
 * ------------------------------
 *
 * 1, 2, 3, 2, 3 <= 주식 값
 * 4, 3, 1, 1, 0 <= 주식 값이 떨어지지 않는 날
 *
 * 1 => 떨이지는 날이 없으므로 2, 3, 2, 3 => 총 4일간 유지
 * 2 => 역시 떨어지는 날이 없으므로  3, 2, 3 =>총 3일간 유지
 * 3 => 다음 날이 2 이므로 주식 값이 떨어지므로 => 총 1일간 유지 (이부분이 헷갈릴 수 있음)
 *         2,3 => 1일이고
 *         2,1  => 1일 임
 *         2,3,4 => 2일 이고
 *         2,2,1  => 2일 임
 *         즉 다음 날이 주식 값이 떨어지는 날도 1일로 포함 하는 조건 인데(헷갈리는 요소)
 * 2 => 다음 날이 3이고 더이상 없으므로 => 총 1일간 유지
 * 3 => 다음 날이 없으므로 => 0일간 유지
 *
 */
public class Q_주식가격 {

    public static void main(String[] args){

        int[] prices = new int[]{1, 2, 3, 2, 3};

        Solution solution = new Solution();
        int[] result = solution.solution(prices);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public int[] solution(int[] prices) {

            int len = prices.length;
            int[] answer = new int[len];

            for (int i = 0; i < len; i++) { // 0 부터 price.length 까지 반복
                for (int j = i + 1; j < len; j++) { // 1 부터 price.length 까지 반복
                    answer[i]++; // 현재 일을 기준으로 price.length 일까지 증가
                    if (prices[i] > prices[j]) { // 오늘 index 의 값과 다음날 index 값을 비교하여 오늘 값이 크면 break;
                        break;
                    }
                }
            }
            return answer;
        }
    }

    public static class Solution1 {
        public int[] solution(int[] prices) {
            Stack<Integer[]> stack = new Stack<>();
            int[] ret = new int[prices.length];

            for (int i = prices.length - 2; i >= 0; i--) {
                int day = 0;
                while (!stack.isEmpty() && stack.peek()[0] >= prices[i]) {
                    day += stack.pop()[1];
                }
                ret[i] = stack.push(new Integer[]{prices[i], day + 1})[1];
            }

            return ret;
        }
    }

    public static class Solution2 {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for(int i = 0; i < prices.length; i++)
            {
                for(int j=i+1; j < prices.length; j++)
                {
                    if(prices[i] > prices[j])
                    {
                        answer[i] = j-i;
                        break;
                    }
                    else
                        answer[i] = j-i;
                }
            }

            return answer;
        }
    }

    public static class Solution3 {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for(int i=0; i<prices.length; i++){
                int sec = 0;
                int nowPrice = prices[i];

                for(int k=i; k<prices.length; k++){
                    if((k+1)==prices.length) break;
                    if(nowPrice > prices[k]){
                        break;
                    }else{
                        sec++;
                    }
                }
                answer[i] = sec;
            }

            return answer;
        }
    }

    public static class Solution4 {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            for(int i=0; i<prices.length; i++){
                for(int j=i; j<prices.length; j++){
                    if(prices[i]>prices[j] || j==prices.length-1)
                        break;
                    answer[i]++;
                }
            }
            return answer;
        }
    }

    public static class Solution5 {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            for (int i = 0; i < answer.length-1; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[i] > prices[j] || j == prices.length - 1) {
                        answer[i] = j - i;
                        break;
                    }
                }
            }
            return answer;
        }
    }

}
