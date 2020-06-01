package io.simpolor.quiz.programmers.greedy_06;

import java.util.*;

/***
 * 저울
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 하나의 양팔 저울을 이용하여 물건의 무게를 측정하려고 합니다.
 * 이 저울의 양팔의 끝에는 물건이나 추를 올려놓는 접시가 달려 있고,
 * 양팔의 길이는 같습니다.
 *
 * 또한, 저울의 한쪽에는 저울추들만 놓을 수 있고,
 * 다른 쪽에는 무게를 측정하려는 물건만 올려놓을 수 있습니다.
 *
 * ----A----
 * |   |   |
 * o   |   pp
 *     A
 *   ㅁㅁㅁㅁ  p p p p
 *
 * 저울추가 담긴 배열 weight가 매개변수로 주어질 때,
 * 이 추들로 측정할 수 없는 양의 정수 무게 중 최솟값을 return 하도록 solution 함수를 작성해주세요.
 *
 * 예를 들어, 무게가 각각 [3, 1, 6, 2, 7, 30, 1]인 7개의 저울추를 주어졌을 때,
 * 이 추들로 측정할 수 없는 양의 정수 무게 중 최솟값은 21입니다.
 *
 * ------------------------------
 * 제한 사항
 * ------------------------------
 * 저울추의 개수는 1개 이상 10,000개 이하입니다.
 * 각 추의 무게는 1 이상 1,000,000 이하입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * weight	return
 * [3, 1, 6, 2, 7, 30, 1]	21
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 문제에 나온 예와 같습니다.
 */
public class GREEDY007 {

    public static void main(String[] args) {

        int[] weight = new int[]{3, 1, 6, 2, 7, 30, 1};

        Solution solution = new Solution();
        int result = solution.solution(weight);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int[] weight) {
            Arrays.sort(weight);

            int ans = 1;
            for (int e : weight) {
                if (ans < e)
                    break;
                ans += e;
            }

            return ans;
        }
    }

    public static class Solution1 {
        public int solution(int[] weight) {
            int answer = 0, add = 0, size = weight.length;
            int [] addedWeights = new int[size];

            Arrays.sort(weight);
            for (int i = 0; i < size; i++) {
                add += weight[i];
                addedWeights[i] = add;
            }

            for (int i = 0; i < size - 1; i++) {
                if (weight[i + 1] > addedWeights[i] + 1) {
                    return addedWeights[i] + 1;
                }
            }
            return addedWeights[size - 1] + 1;
        }
    }

    public static class Solution2 {
        public int solution(int[] weight) {
            int e = 0;
            Arrays.sort(weight);

            for(int i=0; i<weight.length; i++){
                int num = weight[i];
                if(e+1 < num){
                    return e+1;
                }else{
                    e = e+num;
                }
            }

            return e+1;
        }
    }

    public static class Solution3 {
        public int solution(int[] weight) {
            int n = weight.length;
            Arrays.sort(weight);
            int currentMax;
            int answer;

            if (weight[0] != 1) return 1;
            else {
                currentMax = 1;
                answer = 2;
            }
            for (int i = 1; i < n; i++) {
                if (1 + answer <= weight[i]) {
                    return answer;
                }
                else {
                    currentMax += weight[i];
                    answer += weight[i];
                }
            }

            return answer;
        }
    }

    public static class Solution4 {
        public int solution(int[] weight) {
            int answer = 0;
            int i,j,tmp;
            Arrays.sort(weight);
            int sum=0;
            for(i=0;i<weight.length;i++){
                if(weight[i]>sum+1){
                    answer=sum+1;
                    break;
                }
                else sum=sum+weight[i];
                if(i==weight.length-1){
                    answer=sum+1;
                    break;
                }
            }
            return answer;
        }
    }




}
