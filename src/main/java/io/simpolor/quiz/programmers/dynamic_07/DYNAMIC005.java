package io.simpolor.quiz.programmers.dynamic_07;

/***
 * 카드 게임
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 카드게임이 있다. 게임에 사용하는 각 카드에는 양의 정수 하나가 적혀있고 같은 숫자가 적힌 카드는 여러 장 있을 수 있다.
 * 게임방법은 우선 짝수개의 카드를 무작위로 섞은 뒤 같은 개수의 두 더미로 나누어 하나는 왼쪽에 다른 하나는 오른쪽에 둔다.
 *
 * 각 더미의 제일 위에 있는 카드끼리 서로 비교하며 게임을 한다.
 * 게임 규칙은 다음과 같다.
 *
 * 지금부터 왼쪽 더미의 제일 위 카드를 왼쪽 카드로, 오른쪽 더미의 제일 위 카드를 오른쪽 카드로 부르겠다.
 *
 * 1. 언제든지 왼쪽 카드만 통에 버릴 수도 있고 왼쪽 카드와 오른쪽 카드를 둘 다 통에 버릴 수도 있다. 이때 얻는 점수는 없다.
 * 2. 오른쪽 카드에 적힌 수가 왼쪽 카드에 적힌 수보다 작은 경우에는 오른쪽 카드만 통에 버릴 수도 있다. 오른쪽 카드만 버리는 경우에는 오른쪽 카드에 적힌 수만큼 점수를 얻는다.
 * 3. (1)과 (2)의 규칙에 따라 게임을 진행하다가 어느 쪽 더미든 남은 카드가 없다면 게임이 끝나며 그때까지 얻은 점수의 합이 최종 점수가 된다.
 *
 * 왼쪽 더미의 카드에 적힌 정수가 담긴 배열 left와 오른쪽 더미의 카드에 적힌 정수가 담긴 배열 right가 매개변수로 주어질 때, 얻을 수 있는 최종 점수의 최대값을 return 하도록 solution 함수를 작성하시오.
 *
 * ------------------------------
 * 제한 사항
 * ------------------------------
 * 한 더미에는 1장 이상 2,000장 이하의 카드가 있다.
 * 각 카드에 적힌 정수는 1 이상 2,000 이하이다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * left	right	return
 * [3, 2, 5]	[2, 4, 1]	7
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * 먼저 오른쪽 카드를 버려서 2점을 획득한다.
 * 그 뒤 왼쪽 카드를 두 장 버리고 오른쪽 카드를 버려서 4점을 획득한다.
 * 마지막으로 오른쪽 카드를 버려서 1점을 획득한다.
 * 총 얻을 수 있는 점수는 7점이다.
 *
 */
public class DYNAMIC005 {

    public static void main(String[] args) {

        int[] left = new int[]{3, 2, 5};
        int[] right = new int[]{2, 4, 1};
        Solution solution = new Solution();
        int result = solution.solution(left, right);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int[] left, int[] right) {
            int answer = 0;
            int[][] dp = new int[left.length + 1][right.length + 1];

            for(int i = 1; i < left.length + 1; i++) {
                for(int j = 1; j < right.length + 1; j++) {
                    if(left[left.length - i] > right[right.length - j]) {
                        dp[i][j] = Math.max(dp[i][j - 1] + right[right.length - j], Math.max(dp[i - 1][j], dp[i - 1][j - 1]));
                    }else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                }
            }
            answer = dp[left.length][right.length];
            return answer;
        }
    }

    public static class Solution1 {
        public int solution(int[] left, int[] right) {
            int nl = left.length;
            int nr = right.length;
            int[][] answer = new int[nl + 1][nr + 1];

            for (int i = 0; i <= nl; i++) {
                answer[i][0] = 0;
            }
            for (int i = 0; i <= nr; i++) {
                answer[0][i] = 0;
            }

            for (int i = 1; i <= nl; i++) {
                for (int j = 1; j <= nl; j++) {
                    answer[i][j] = Math.max(answer[i - 1][j], answer[i - 1][j - 1]);
                    if (left[i - 1] > right[j - 1]) {
                        answer[i][j] = Math.max(answer[i][j], answer[i][j - 1] + right[j - 1]);
                    }
                }
            }

            return answer[nl][nr];
        }
    }


    public static class Solution2 {
        public int solution(int[] left, int[] right) {
            int answer = maxValue(left, right);
            return answer;
        }

        public static int maxValue(int[] left, int[] right) {
            int size = left.length;
            int[][] value = new int[size][size+1];

            // 최상단행
            value[0][0] = 0;
            if ( left[0] > right[0] )
                value[0][1] = right[0];
            else {
                value[0][1] = 0;
            }
            for ( int c = 2; c < size+1; c++ ) {
                if ( value[0][c-1] == 0 ) {
                    value[0][c] = 0;
                } else {
                    if ( left[0] > right[c-1] ) {
                        value[0][c] = value[0][c-1] + right[c-1];
                    } else {
                        value[0][c] = 0;
                    }
                }
            }
            // 좌측열
            for ( int r = 0; r < size; r++ ) {
                value[r][0] = 0;
            }
            // 중앙
            for ( int c = 1 ; c < size+1; c++ ) {
                for ( int r = 1; r < size; r++ ) {
                    int cost = 0;
                    if ( left[r] > right[c-1] ) {
                        cost = value[r][c-1] + right[c-1];
                    } else {
                        cost = 0;
                    }
                    value[r][c] = max(value[r-1][c], value[r-1][c-1], cost);
                }
            }

            int max = 0;
            for ( int r = 0; r < size; r++ ) {
                for ( int c = 0; c < size+1; c++ ) {
                    if ( max < value[r][c] )
                        max = value[r][c];
                }
            }
            return max;
        }

        public static int max(int a, int b, int c) {
            int[] num = {a, b, c};
            int max = a;
            for ( int i = 0; i < 3; i++ ) {
                if ( max < num[i] )
                    max = num[i];
            }
            return max;
        }
    }

    public static class Solution3 {
        public int solution(int[] left, int[] right) {

            int answer = 0;
            int len = left.length;

            int[] l = new int[len + 2];
            for (int i = 1; i <= len; i++) l[i] = left[i - 1];
            int[] r = new int[len + 2];
            for (int i = 1; i <= len; i++) r[i] = right[i - 1];

            int[][] d = new int[len + 1][len + 2];  // [len + 2] : handling last right card
            for (int i = 0; i <= len + 1; i++)
                d[0][i] = -1;

            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= len + 1; j++) {
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - 1]);
                    if (d[i][j - 1] != -1 && l[i] > r[j - 1]) {
                        d[i][j] = Math.max(d[i][j], d[i][j - 1] + r[j - 1]);
                    }
                }
            }

            for (int i = 1; i <= len + 1; i++)
                if (answer < d[len][i])
                    answer = d[len][i];

            return answer;
        }
    }

    public static class Solution4 {
        public int solution(int[] left, int[] right) {
            int[][] memo = new int[left.length][right.length];

            for(int i = 0; i < memo.length; i++){
                for(int j = 0; j < memo.length; j++){
                    int value1 = i >= 1 ? memo[i-1][j] : 0;
                    int value2 = i >= 1 && j >= 1 ? memo[i-1][j-1] : 0;
                    int value3 = j >= 1 ? memo[i][j-1] : 0;
                    memo[i][j] = Math.max(value1, value2);
                    if(left[i] > right[j]) memo[i][j] = Math.max(memo[i][j], value3 + right[j]);
                }
            }
            return memo[memo.length-1][memo.length-1];
        }
    }



}
