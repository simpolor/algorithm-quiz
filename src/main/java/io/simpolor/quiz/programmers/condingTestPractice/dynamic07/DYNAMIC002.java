package io.simpolor.quiz.programmers.condingTestPractice.dynamic07;

/***
 * 타일 장식물
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 대구 달성공원에 놀러 온 지수는 최근에 새로 만든 타일 장식물을 보게 되었다.
 * 타일 장식물은 정사각형 타일을 붙여 만든 형태였는데,
 * 한 변이 1인 정사각형 타일부터 시작하여 마치 앵무조개의 나선 모양처럼 점점 큰 타일을 붙인 형태였다.
 *
 * 타일 장식물의 일부를 그리면 다음과 같다.
 *
 *
 * 그림에서 타일에 적힌 수는 각 타일의 한 변의 길이를 나타낸다.
 * 타일 장식물을 구성하는 정사각형 타일 한 변의 길이를 안쪽 타일부터 시작하여 차례로 적으면 다음과 같다.
 * [1, 1, 2, 3, 5, 8, .]
 *
 * 지수는 문득 이러한 타일들로 구성되는 큰 직사각형의 둘레가 궁금해졌다.
 * 예를 들어, 처음 다섯 개의 타일이 구성하는 직사각형(위에서 빨간색으로 표시한 직사각형)의 둘레는 26이다.
 *
 * 타일의 개수 N이 주어질 때, N개의 타일로 구성된 직사각형의 둘레를 return 하도록 solution 함수를 작성하시오.
 *
 * ------------------------------
 * 제한 사항
 * ------------------------------
 * N은 1 이상 80 이하인 자연수이다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * N	return
 * 5	26
 * 6	42
 *
 */
public class DYNAMIC002 {

    public static void main(String[] args) {

        int n = 5;
        Solution solution = new Solution();
        long result = solution.solution(n);

        System.out.println(result);
    }

    public static class Solution {
        public long solution(int N) {
            long answer = 0;
            long[] dp = new long[81];
            dp[1] = 1;
            dp[2] = 1;
            for(int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            answer = dp[N] * 2 + (dp[N] + dp[N - 1]) * 2;
            return answer;
        }
    }

    public static class Solution1 {
        public long solution(int N) {
            long[] dp = new long[N];
            dp[0] = 4;
            dp[1] = 6;

            for (int i = 2; i < N; i++) {
                dp[i] = dp[i - 2] + dp[i - 1];
            }

            return dp[N -1];
        }
    }

    public static class Solution2 {
        long data[] = new long[81];

        public long solution(int N) {
            return ( 2*piv(N) + piv(N-1) ) * 2;
        }

        long piv(int n) {
            if (n == 1 || n == 2) {return 1;}
            else if (data[n] != 0) {return data[n];}
            else {
                return data[n] = piv(n-1) + piv(n-2);
            }
        }
    }

    public static class Solution3 {
        public long solution(int N) {
            long answer = 0;

            int i=0;

            long DP[] = new long[80];
            long SQ[] = new long[80];

            SQ[0] = 1; SQ[1] = 1;

            for(int j=2; j <= N; j++)
                SQ[j] = SQ[j-1] + SQ[j-2];

            DP[1] = 4;

            for(i=2; i <= N; i++)
                DP[i] = SQ[i-1]*2 + (SQ[i-2] + SQ[i-1])*2;

            answer = DP[N];

            return answer;
        }
    }



}
