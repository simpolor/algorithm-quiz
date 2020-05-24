package io.simpolor.quiz.programmers.sort;

import java.util.*;

/***
 * K번째수
 *
 * ------------------------------
 * 문제 설명
 * ------------------------------
 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
 *
 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
 *
 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
 * 2에서 나온 배열의 3번째 숫자는 5입니다.
 * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
 * commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * ------------------------------
 * 제한사항
 * ------------------------------
 * array의 길이는 1 이상 100 이하입니다.
 * array의 각 원소는 1 이상 100 이하입니다.
 * commands의 길이는 1 이상 50 이하입니다.
 * commands의 각 원소는 길이가 3입니다.
 *
 * ------------------------------
 * 입출력 예
 * ------------------------------
 * array	commands	return
 * [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 *
 * ------------------------------
 * 입출력 예 설명
 * ------------------------------
 * [1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
 * [1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
 * [1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.
 *
 *
 */
public class SORT001 {

    public static void main(String[] args) {

        int[] arrays = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] command = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Solution solution = new Solution();
        int[] result = solution.solution(arrays, command);

        System.out.println(Arrays.toString(result));
    }

    public static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int i=0; i<commands.length; i++){
                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(temp);
                answer[i] = temp[commands[i][2]-1];
            }

            return answer;
        }
    }

    public static class Solution1 {
        public int[] solution(int[] array, int[][] commands) {
            int n = 0;
            int[] ret = new int[commands.length];

            while(n < commands.length){
                int m = commands[n][1] - commands[n][0] + 1;

                if(m == 1){
                    ret[n] = array[commands[n++][0]-1];
                    continue;
                }

                int[] a = new int[m];
                int j = 0;
                for(int i = commands[n][0]-1; i < commands[n][1]; i++)
                    a[j++] = array[i];

                sort(a, 0, m-1);

                ret[n] = a[commands[n++][2]-1];
            }

            return ret;
        }

        void sort(int[] a, int left, int right){
            int pl = left;
            int pr = right;
            int x = a[(pl+pr)/2];

            do{
                while(a[pl] < x) pl++;
                while(a[pr] > x) pr--;
                if(pl <= pr){
                    int temp = a[pl];
                    a[pl] = a[pr];
                    a[pr] = temp;
                    pl++;
                    pr--;
                }
            }while(pl <= pr);

            if(left < pr) sort(a, left, pr);
            if(right > pl) sort(a, pl, right);
        }
    }

    public static class Solution2 {
        public static int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            int index = 0 ;

            for(int i = 0 ; i < commands.length ; i++)
            {
                int start = commands[i][0];
                int end = commands[i][1];
                int k = commands[i][2];

                int[] tmp = new int[end - start + 1];

                int a = 0;
                for(int j = start - 1 ; j < end ; j++)
                    tmp[a++] = array[j];

                Arrays.sort(tmp);
                answer[index++] = tmp[k-1];
            }


            return answer;
        }
    }



}
