package io.simpolor.quiz.programmers.dichotomy;

import java.util.*;

/***
 * 예산
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 국가의 역할 중 하나는 여러 지방의 예산요청을 심사하여 국가의 예산을 분배하는 것입니다.
 * 국가예산의 총액은 미리 정해져 있어서 모든 예산요청을 배정해 주기는 어려울 수도 있습니다.
 * 그래서 정해진 총액 이하에서 가능한 한 최대의 총 예산을 다음과 같은 방법으로 배정합니다.
 *
 * 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정합니다.
 * 2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정합니다.
 *    상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정합니다.
 *
 * 예를 들어, 전체 국가예산이 485이고 4개 지방의 예산요청이 각각 120, 110, 140, 150일 때,
 * 상한액을 127로 잡으면 위의 요청들에 대해서 각각 120, 110, 127, 127을 배정하고 그 합이 484로 가능한 최대가 됩니다.
 *
 * 각 지방에서 요청하는 예산이 담긴 배열 budgets과 총 예산 M이 매개변수로 주어질 때,
 * 위의 조건을 모두 만족하는 상한액을 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한 사항
 * ------------------------------
 * 지방의 수는 3 이상 100,000 이하인 자연수입니다.
 * 각 지방에서 요청하는 예산은 1 이상 100,000 이하인 자연수입니다.
 * 총 예산은 지방의 수 이상 1,000,000,000 이하인 자연수입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * budgets	    M	    return
 * [120, 110, 140, 150],	485,	127
 *
 * 출처
 *
 * ※ 공지 - 2019년 3월 15일, 테스트케이스가 강화되었습니다.
 * 이번 업데이트로 인해 지방의 수가 최대 10,000개에서 100,000개로 늘어났으며, 이에 따라 테스트케이스가 수정되었습니다.
 * 이로 인해 이전에 통과하던 코드가 더 이상 통과하지 않을 수 있습니다.
 *
 */
public class DICHOTOMY001 {

    public static void main(String[] args) {

        int[] budgets = new int[]{120, 110, 140, 150};
        int M = 485;


        Solution solution = new Solution();
        int result = solution.solution(budgets, M);

        System.out.println(result);
    }

    public static class Solution
    {
        public int solution(int[] budgets, int M)
        {
            Arrays.sort(budgets);
            int start = 0, end = budgets[budgets.length - 1];
            while(start <= end)
            {
                int sum = 0;
                int mid = (start + end) / 2;
                for(int element : budgets)
                    sum = element > mid ? sum + mid : sum + element;
                if(sum > M) end = mid - 1;
                else
                    start = mid + 1;
            }
            return end;
        }
    }

    public static class Solution1 {
        public int solution(int[] budgets, int M) {
            Arrays.sort(budgets);

            int n = budgets.length;
            int budget = budgets[0];
            int totalBudget = budget * n;

            if (totalBudget > M)
                return M / n;

            for (int i = 1; i < budgets.length; i++) {
                n--;

                int diff = budgets[i] - budgets[i - 1];
                if (diff * n + totalBudget > M) {
                    budget += (M - totalBudget) / n;
                    break;
                }
                budget += diff;
                totalBudget += diff * n;
            }
            return budget;
        }
    }

    public static class Solution2 {
        public int solution(int[] budgets, int M) {
            int answer = 0;
            int start = 1, mid = 0, end = 0, totalBuget = 0;
            for(int i = 0; i < budgets.length; i++) {
                if(end < budgets[i]) {
                    end = budgets[i];
                }
            }
            while(start <= end) {
                mid = (start + end) / 2;
                totalBuget = totalBudget(budgets, mid);
                if(totalBuget == M) {
                    answer = M;
                    break;
                }else if(totalBuget > M) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
            answer = totalBuget > M ? mid - 1 : mid;
            return answer;
        }
        int totalBudget(int[] budgets, int M) {
            int sum = 0;
            for(int i = 0; i < budgets.length; i++) {
                if(budgets[i] < M) {
                    sum += budgets[i];
                }else {
                    sum += M;
                }
            }
            return sum;
        }
    }

    public static class Solution3 {
        public int solution(int[] budgets, int M) {
            int answer;
            int n = budgets.length;

            Arrays.sort(budgets);

            answer = find (budgets, n, M, 0, budgets[n - 1]);

            return answer;
        }

        public int find(int[] budgets, int n, int M, int min, int max) {
            int spend = M;
            if (min == max) {
                return max;
            }
            else {
                int limit = (min + max) / 2 + ((min + max) % 2 == 1? 1 : 0);
                for (int i = 0; i < n; i++) {
                    if (limit >= budgets[i]) {
                        spend -= budgets[i];
                    }
                    else {
                        spend -= (n - i) * limit;
                        break;
                    }
                }

                if (spend > 0) {
                    return find(budgets, n, M, limit, max);
                }
                else if (spend < 0) {
                    if (limit - 1 > min) {
                        return find(budgets, n, M, min, limit - 1);
                    }
                    else {
                        return find(budgets, n, M, min, min);
                    }
                }
                else {
                    return limit;
                }
            }
        }
    }

    public static class Solution4 {

        public int solution(int[] budgets, int M) {
            Arrays.sort(budgets);
            int start = 0, end = budgets[budgets.length - 1];
            while(start <= end)
            {
                int sum = 0;
                int mid = (start + end) / 2;
                for(int element : budgets)
                {
                    if(element > mid) sum += mid;
                    else
                        sum += element;
                }
                if(sum > M) end = mid - 1;
                else
                    start = mid + 1;
            }
            return end;
        }
    }

    public static class Solution5 {
        public int solution(int[] budgets, int M) {
            int answer = 0;
            Arrays.sort(budgets);
            for(int i=0;i<budgets.length;i++){
                if(M/(budgets.length-i)<budgets[i]){
                    answer = M/(budgets.length-i);
                    break;
                }
                M = M-budgets[i];
                answer = budgets[i];

            }
            return answer;
        }
    }






}
