package io.simpolor.quiz.programmers.Dynamic;

import java.util.Arrays;

/***
 * 정수 삼각형
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 *         7
 *        3 8
 *       8 1 0
 *      2 7 7 4
 *     4 5 2 6 5
 *
 *
 * 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다.
 * 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다.
 * 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
 *
 * 삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * 삼각형의 높이는 1 이상 500 이하입니다.
 * 삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * triangle	result
 * [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	30
 *
 * 출처
 *
 */
public class DYNAMIC003 {

    public static void main(String[] args) {

        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        Solution solution = new Solution();
        int result = solution.solution(triangle);

        System.out.println(result);
    }

    public static class Solution {
        public int solution(int[][] triangle) {
            for (int i = 1; i < triangle.length; i++) {
                triangle[i][0] += triangle[i-1][0];
                triangle[i][i] += triangle[i-1][i-1];
                for (int j = 1; j < i; j++)
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }

            return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
        }
    }

    public static class Solution1 {
        public int solution(int[][] triangle) {
            int l=triangle.length;
            int[][] dp=new int[l][];

            for(int i=0;i<l;i++){
                dp[i]=new int[i+1];
            }

            for(int j=0;j<l;j++){
                for(int i=0;i<=j;i++){
                    if(j==0){
                        dp[j][i]=triangle[0][0];
                    }
                    else if(i==0){
                        dp[j][i]=dp[j-1][i]+triangle[j][i];
                    }
                    else if(i==j){
                        dp[j][i]=dp[j-1][i-1]+triangle[j][i];
                    }
                    else{
                        dp[j][i]=Math.max(dp[j-1][i-1],dp[j-1][i])+triangle[j][i];
                    }
                }
            }

            int max = dp[l-1][0];
            for(int k=1; k<l ; k++){
                if(dp[l-1][k] >= max){
                    max = dp[l-1][k];
                }
            }

            return max;
        }
    }

    public static class Solution2 {
        public int solution(int[][] triangle) {
            int answer = 0;
            int[][] v = new int[triangle.length][];
            for(int i = 0; i < triangle.length; i++) {
                v[i] = new int[triangle[i].length];
                Arrays.fill(v[i], Integer.MAX_VALUE);
            }
            v[0][0] = triangle[0][0];
            for(int i = 1; i < triangle.length; i++) {
                for(int j = 0; j < triangle[i].length; j++) {
                    if(j-1 < 0)
                        v[i][j] = v[i-1][j] + triangle[i][j];
                    else if( j-1 >= 0 && j < triangle[i-1].length)
                        v[i][j] = Math.max(v[i-1][j-1] , v[i-1][j]) + triangle[i][j];
                    else
                        v[i][j] = v[i-1][j-1] + triangle[i][j];
                    if(v[i][j] > answer)
                        answer = v[i][j];
                }
            }
            return answer;
        }
    }

    public static class Solution3 {
        public int solution(int[][] triangle) {
            int answer = 0;

            int triangleLength = triangle.length;
            int[][] iii = new int[triangleLength][];
            iii[0] = new int[]{triangle[0][0]};

            for (int i = 1; i < triangleLength; i++) {
                int length = triangle[i].length;
                iii[i] = new int[length];
                for (int j = 0; j < length; j++) {

                    if (j == 0){
                        iii[i][j] = iii[i-1][0] + triangle[i][0];
                    }
                    else if (j == length-1){
                        iii[i][j] = iii[i-1][j-1] + triangle[i][j];
                    }
                    else {
                        if (iii[i-1][j-1] >= iii[i-1][j]){
                            iii[i][j] = iii[i-1][j-1] + triangle[i][j];
                        }
                        else {
                            iii[i][j] = iii[i-1][j] + triangle[i][j];
                        }
                    }
                }
            }
            for (int i = 0; i < iii[triangleLength-1].length; i++) {
                int i1 = iii[triangleLength - 1][i];

                if (answer < i1){
                    answer = i1;
                }
            }

            return answer;
        }
    }

    public static class Solution4 {
        public int solution(int[][] triangle) {
            int n = triangle.length;
            int[][] map = new int[n+1][n+1];

            for (int i=1; i<=n; i++) {
                for (int j=1; j<=i; j++) {
                    map[i][j] = triangle[i-1][j-1];
                    if (j==0) map[i][j] += map[i-1][j];
                    else if (i==j) map[i][j] += map[i-1][j-1];
                    else map[i][j] += Math.max(map[i-1][j-1], map[i-1][j]);
                }
            }
            Arrays.sort(map[n]);
            return map[n][n];
        }
    }




}
